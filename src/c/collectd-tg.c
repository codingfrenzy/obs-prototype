/**
 * collectd-td - collectd traffic generator
 * Copyright (C) 2010-2012  Florian octo Forster
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; only version 2 of the License is applicable.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 *
 * Authors:
 *   Florian Forster <octo at collectd.org>
 **/

#if HAVE_CONFIG_H
# include "config.h"
#endif

#ifndef _ISOC99_SOURCE
# define _ISOC99_SOURCE
#endif

#ifndef _POSIX_C_SOURCE
# define _POSIX_C_SOURCE 200809L
#endif

#ifndef _XOPEN_SOURCE
# define _XOPEN_SOURCE 700
#endif

#if !__GNUC__
# define __attribute__(x) /**/
#endif

#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <time.h>
#include <signal.h>
#include <errno.h>

#include "utils_heap.h"

#include "utils_time.h"

#include "libcollectdclient/collectd/client.h"
#include "libcollectdclient/collectd/network.h"
#include "libcollectdclient/collectd/network_buffer.h"

#define DEF_NUM_HOSTS    1000
#define DEF_NUM_PLUGINS    20
#define DEF_NUM_VALUES 100000
#define DEF_INTERVAL       10.0
#define DEF_HOSTPREFIX  "OBS-"

static int conf_num_hosts = DEF_NUM_HOSTS;
static int conf_num_plugins = DEF_NUM_PLUGINS;
static int conf_num_values = DEF_NUM_VALUES;
static double conf_interval = DEF_INTERVAL;
static const char *conf_destination = NET_DEFAULT_V6_ADDR;
static const char *conf_service = NET_DEFAULT_PORT;
static const char *conf_host_prefix = DEF_HOSTPREFIX;

static lcc_network_t *net;

static c_heap_t *values_heap = NULL;

static struct sigaction sigint_action;
static struct sigaction sigterm_action;

static _Bool loop = 1;

__attribute__((noreturn))
static void exit_usage (int exit_status) /* {{{ */
{
  fprintf ((exit_status == EXIT_FAILURE) ? stderr : stdout,
      "collectd-tg -- collectd traffic generator - modified\n"
      "\n"
      "  Usage: collectd-ng [OPTION]\n"
      "\n"
      "  Valid options:\n"
      "    -n <number>    Number of value lists. (Default: %i)\n"
      "    -H <number>    Number of hosts to emulate. (Default: %i)\n"
      "    -p <number>    Number of plugins to emulate. (Default: %i)\n"
      "    -i <seconds>   Interval of each value in seconds. (Default: %.3f)\n"
      "    -d <dest>      Destination address of the network packets.\n"
      "                   (Default: %s)\n"
      "    -D <port>      Destination port of the network packets.\n"
      "                   (Default: %s)\n"
      "    -X <prefix>    Prefix to host name.\n"
      "                   (Default: %s)\n"
      "    -h             Print usage information (this output).\n"
      "\n"
      "Copyright (C) 2010-2012  Florian Forster\n"
      "Copyright (C) 2014       Ying Gao\n"
      "Licensed under the GNU General Public License, version 2 (GPLv2)\n",
      DEF_NUM_VALUES, DEF_NUM_HOSTS, DEF_NUM_PLUGINS,
      DEF_INTERVAL,
      NET_DEFAULT_V6_ADDR, NET_DEFAULT_PORT, DEF_HOSTPREFIX);
  exit (exit_status);
} /* }}} void exit_usage */

static void signal_handler (int signal) /* {{{ */
{
  loop = 0;
} /* }}} void signal_handler */

static int compare_time (const void *v0, const void *v1) /* {{{ */
{
  const lcc_value_list_t *vl0 = v0;
  const lcc_value_list_t *vl1 = v1;

  if (vl0->time < vl1->time)
    return (-1);
  else if (vl0->time > vl1->time)
    return (1);
  else
    return (0);
} /* }}} int compare_time */

static int get_boundet_random (int min, int max) /* {{{ */
{
  int range;

  if (min >= max)
    return (-1);
  if (min == (max - 1))
    return (min);

  range = max - min;

  return (min + ((int) (((double) range) * ((double) random ()) / (((double) RAND_MAX) + 1.0))));
} /* }}} int get_boundet_random */

static lcc_value_list_t *create_value_list (int vl_no) /* {{{ */
{
  lcc_value_list_t *vl;
  int host_num;

  vl = malloc (sizeof (*vl));
  if (vl == NULL)
  {
    fprintf (stderr, "malloc failed.\n");
    return (NULL);
  }
  memset (vl, 0, sizeof (*vl));

  vl->values = calloc (/* nmemb = */ 1, sizeof (*vl->values));
  if (vl->values == NULL)
  {
    fprintf (stderr, "calloc failed.\n");
    free (vl);
    return (NULL);
  }

  vl->values_types = calloc (/* nmemb = */ 1, sizeof (*vl->values_types));
  if (vl->values_types == NULL)
  {
    fprintf (stderr, "calloc failed.\n");
    free (vl->values);
    free (vl);
    return (NULL);
  }

  vl->values_len = 1;

  //host_num = get_boundet_random (0, conf_num_hosts);
  host_num = (vl_no % conf_num_hosts);

  vl->interval = conf_interval;
  vl->time = 1.0 + time (NULL)
    + (host_num % (1 + (int) vl->interval));

/*
  if (get_boundet_random (0, 2) == 0)
    vl->values_types[0] = LCC_TYPE_GAUGE;
  else
    vl->values_types[0] = LCC_TYPE_DERIVE;
*/
  vl->values_types[0] = LCC_TYPE_GAUGE;

  //snprintf (vl->identifier.host, sizeof (vl->identifier.host),
  //    "host%04i", host_num);
  snprintf (vl->identifier.host, sizeof (vl->identifier.host),
      "%shost%04i", conf_host_prefix, host_num);
  //fprintf (stdout, "Host prefix %s, Host %s", conf_host_prefix, vl->identifier.host);
  
  int plugin_no =  (vl_no % conf_num_plugins);
  //snprintf (vl->identifier.plugin, sizeof (vl->identifier.plugin),
  //    "plugin%03i", get_boundet_random (0, conf_num_plugins));
  snprintf (vl->identifier.plugin, sizeof (vl->identifier.plugin),
      "plugin%03i", plugin_no);

  strncpy (vl->identifier.type,
      (vl->values_types[0] == LCC_TYPE_GAUGE) ? "gauge" : "derive",
      sizeof (vl->identifier.type));
  // Modified by Joel Gao Jly 24th 2015
  //snprintf (vl->identifier.type_instance, sizeof (vl->identifier.type_instance),
  //    "ti%li", random ());
  //int metric_no = (vl_no % 30);
  //snprintf (vl->identifier.type_instance, sizeof (vl->identifier.type_instance),
  //    "ti%i", metric_no);
  snprintf (vl->identifier.type_instance, sizeof (vl->identifier.type_instance),
      "ti");

  return (vl);
} /* }}} int create_value_list */

static void destroy_value_list (lcc_value_list_t *vl) /* {{{ */
{
  if (vl == NULL)
    return;

  free (vl->values);
  free (vl->values_types);
  free (vl);
} /* }}} void destroy_value_list */

cdtime_t cdtime (void) /* {{{ */
{
  int status;
  struct timespec ts = { 0, 0 };

  status = clock_gettime (CLOCK_REALTIME, &ts);
  if (status != 0)
  {
    //char errbuf[1024];
    //ERROR ("cdtime: clock_gettime failed: %s",
     //   sstrerror (errno, errbuf, sizeof (errbuf)));
    return (0);
  }

  return (TIMESPEC_TO_CDTIME_T (&ts));
} /* }}} cdtime_t cdtime */

static int send_value (lcc_value_list_t *vl) /* {{{ */
{
  int status;

  // Modified by Joel Gao Jly 24 2015
  cdtime_t vltime = vl->time;
  vl->time = cdtime();
  if (vl->values_types[0] == LCC_TYPE_GAUGE)
    vl->values[0].gauge = 100.0 * ((gauge_t) random ()) / (((gauge_t) RAND_MAX) + 1.0);
  else
    vl->values[0].derive += get_boundet_random (0, 100);

  status = lcc_network_values_send (net, vl);
  if (status != 0)
    fprintf (stderr, "lcc_network_values_send failed with status %i.\n", status);
  vl->time = vltime;
  vl->time += vl->interval;

  return (0);
} /* }}} int send_value */

static int get_integer_opt (const char *str, int *ret_value) /* {{{ */
{
  char *endptr;
  int tmp;

  errno = 0;
  endptr = NULL;
  tmp = (int) strtol (str, &endptr, /* base = */ 0);
  if (errno != 0)
  {
    fprintf (stderr, "Unable to parse option as a number: \"%s\": %s\n",
        str, strerror (errno));
    exit (EXIT_FAILURE);
  }
  else if (endptr == str)
  {
    fprintf (stderr, "Unable to parse option as a number: \"%s\"\n", str);
    exit (EXIT_FAILURE);
  }
  else if (*endptr != 0)
  {
    fprintf (stderr, "Garbage after end of value: \"%s\"\n", str);
    exit (EXIT_FAILURE);
  }

  *ret_value = tmp;
  return (0);
} /* }}} int get_integer_opt */

static int get_double_opt (const char *str, double *ret_value) /* {{{ */
{
  char *endptr;
  double tmp;

  errno = 0;
  endptr = NULL;
  tmp = strtod (str, &endptr);
  if (errno != 0)
  {
    fprintf (stderr, "Unable to parse option as a number: \"%s\": %s\n",
        str, strerror (errno));
    exit (EXIT_FAILURE);
  }
  else if (endptr == str)
  {
    fprintf (stderr, "Unable to parse option as a number: \"%s\"\n", str);
    exit (EXIT_FAILURE);
  }
  else if (*endptr != 0)
  {
    fprintf (stderr, "Garbage after end of value: \"%s\"\n", str);
    exit (EXIT_FAILURE);
  }

  *ret_value = tmp;
  return (0);
} /* }}} int get_double_opt */

static int read_options (int argc, char **argv) /* {{{ */
{
  int opt;

  while ((opt = getopt (argc, argv, "n:H:p:i:d:D:h:X:")) != -1)
  {
    switch (opt)
    {
      case 'n':
        get_integer_opt (optarg, &conf_num_values);
        break;

      case 'H':
        get_integer_opt (optarg, &conf_num_hosts);
        break;

      case 'p':
        get_integer_opt (optarg, &conf_num_plugins);
        break;

      case 'i':
        get_double_opt (optarg, &conf_interval);
        break;

      case 'd':
        conf_destination = optarg;
        break;

      case 'D':
        conf_service = optarg;
        break;

      case 'X'://Added by Joel Gao Jly 21 2015
        conf_host_prefix = optarg;
        break;

      case 'h':
        exit_usage (EXIT_SUCCESS);

      default:
        exit_usage (EXIT_FAILURE);
    } /* switch (opt) */
  } /* while (getopt) */

  return (0);
} /* }}} int read_options */

int main (int argc, char **argv) /* {{{ */
{
  int i;
  time_t last_time;
  int values_sent = 0;

  read_options (argc, argv);

  sigint_action.sa_handler = signal_handler;
  sigaction (SIGINT, &sigint_action, /* old = */ NULL);

  sigterm_action.sa_handler = signal_handler;
  sigaction (SIGTERM, &sigterm_action, /* old = */ NULL);


  values_heap = c_heap_create (compare_time);
  if (values_heap == NULL)
  {
    fprintf (stderr, "c_heap_create failed.\n");
    exit (EXIT_FAILURE);
  }

  net = lcc_network_create ();
  if (net == NULL)
  {
    fprintf (stderr, "lcc_network_create failed.\n");
    exit (EXIT_FAILURE);
  }
  else
  {
    lcc_server_t *srv;
    
    srv = lcc_server_create (net, conf_destination, conf_service);
    if (srv == NULL)
    {
      fprintf (stderr, "lcc_server_create failed.\n");
      exit (EXIT_FAILURE);
    }

    lcc_server_set_ttl (srv, 42);
#if 0
    lcc_server_set_security_level (srv, ENCRYPT,
        "admin", "password1");
#endif
  }

  fprintf (stdout, "Creating %i values ... ", conf_num_values);
  fflush (stdout);
  for (i = 0; i < conf_num_values; i++)
  {
    lcc_value_list_t *vl;

    vl = create_value_list (i);
    if (vl == NULL)
    {
      fprintf (stderr, "create_value_list failed.\n");
      exit (EXIT_FAILURE);
    }

    c_heap_insert (values_heap, vl);
  }
  fprintf (stdout, "done\n");

  last_time = 0;
  while (loop)
  {
    lcc_value_list_t *vl = c_heap_get_root (values_heap);

    if (vl == NULL)
      break;

    if (vl->time != last_time)
    {
      printf ("%i values have been sent.\n", values_sent);

      /* Check if we need to sleep */
      time_t now = time (NULL);

      while (now < vl->time)
      {
        /* 1 / 100 second */
        struct timespec ts = { 0, 10000000 };
        nanosleep (&ts, /* remaining = */ NULL);
        now = time (NULL);

        if (!loop)
          break;
      }
      last_time = vl->time;
    }

    send_value (vl);
    values_sent++;

    c_heap_insert (values_heap, vl);
  }

  fprintf (stdout, "Shutting down.\n");
  fflush (stdout);

  while (42)
  {
    lcc_value_list_t *vl = c_heap_get_root (values_heap);
    if (vl == NULL)
      break;
    destroy_value_list (vl);
  }
  c_heap_destroy (values_heap);

  lcc_network_destroy (net);
  exit (EXIT_SUCCESS);
  return (0);
} /* }}} int main */

/* vim: set sw=2 sts=2 et fdm=marker : */
