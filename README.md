# Observability #

Observability project is:
- A monitoring tool that is capable of monitoring up to 10,000 separate nodes hosting different databases (such as MongoDB, Cassandra, Redis, PostGRE). 
- Any type of metrics, from system metrics such as CPU, Memory usage, to database specific metrics such as total number of requests, active connections, etc., can be collected and displayed in a web page in the main server. 
- The configuration of the entire system can be controlled from a single system (admin's PC/laptop). This is done using a modeling based approach. The configurations are then automatically propagated into all the nodes in the system.
- System includes additional features such as on-the-fly and post-collection aggregation of measurements, notification alerts for configuration changes and system thresholds, and a cluster health monitor to keep track of dead and alive nodes.

Frameworks used:
- Sirius - EMF based modeling framework
- collectd - metric collection framework
- Grafana - graphing tool

*For further information and queries, please contact owner.*
