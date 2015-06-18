/**
 * collectd - src/obsaggregation.c
 * Copyright (C) 2005-2008  Florian octo Forster
 * Copyright (C) 2015       Ying venomJ Gao
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
 *   Florian octo Forster <octo at verplant.org>
 *   Ying venomJ Gao	  <joelyinggao at gmail.com>
 **/

#define _BSD_SOURCE

#include "collectd.h"
#include "common.h"
#include "plugin.h"
#include "configfile.h"
#include "meta_data.h"
#include "utils_cache.h" /* for uc_get_rate() */
#include "utils_subst.h"
#include "utils_vl_lookup.h"

#include <pthread.h>

//static pthread_mutex_t agg_instance_list_lock = PTHREAD_MUTEX_INITIALIZER;

static void obsaggr_submit (gauge_t aggr_val, counter_t num_total_nodes, counter_t num_aggr_nodes, const char *plugin, const char *type)
{
	//value_t values[3];
	value_t values[1];
	value_list_t vl = VALUE_LIST_INIT;

	values[0].gauge   = aggr_val;
	//values[1].counter = num_total_nodes;
	//values[2].counter = num_aggr_nodes;

	vl.values = values;
	vl.values_len = STATIC_ARRAY_SIZE (values);
	sstrncpy (vl.host, "global-aggr", sizeof (vl.host));
	sstrncpy (vl.plugin, plugin, sizeof (vl.plugin));
	sstrncpy (vl.type, type, sizeof (vl.type));

	plugin_dispatch_values (&vl);
}

static int obsaggr_read (void)
{
	obsaggr_submit(0.555, 2, 1, "obsaggregation", "cpu");
	obsaggr_submit(12345678, 2, 1, "obsaggregation", "memory");

	return (0);
}

static int obsagg_write (data_set_t const *ds, value_list_t const *vl, /* {{{ */
    __attribute__((unused)) user_data_t *user_data)
{
  _Bool created_by_aggregation = 0;
  int status;

  /* Ignore values that were created by the aggregation plugin to avoid weird
   * effects. */
  (void) meta_data_get_boolean (vl->meta, "aggregation:created",
      &created_by_aggregation);
  if (created_by_aggregation)
    return (0);

  if (lookup == NULL)
    status = ENOENT;
  else
  {
    status = lookup_search (lookup, ds, vl);
    if (status > 0)
      status = 0;
  }

  return (status);
} /* }}} int agg_write */

void module_register (void)
{
	plugin_register_complex_config ("aggregation", obsagg_config);
  	plugin_register_write ("obsaggregation", obsagg_write, /* user_data = */ NULL);
	plugin_register_read ("obsaggregation", obsaggr_read);
} /* void module_register */
