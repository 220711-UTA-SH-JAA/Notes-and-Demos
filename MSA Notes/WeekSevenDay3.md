# Spring Cloud Overview

A light weight, event driven Spring framework to quickly build up micro service applications.

It is a replacement for the old Netflix stack, that is now deprecated

# API Gateway

AN API gateway sits between the client and a collection of backend services

It essentially routes the clients requests to the correct service

It acts as a single entry point to the application

In our example we will be using Spring Cloud gateway, which is springs implementation of the outdated Zuul from the netflix stack

# Load Balancing

In Microservice Architecure multiple instances of each service may be deployed for availablity and scalability, this limits failure of a single instance

To manage all these instances you use a load balancing mechanism to ensure that all incoming requests are spread across available instances of that service

A load balancer acts as the traffic cop sitting in front of our servers and routes clients requests across all servers capable of filling those requests

There are two types of load balancing:

- Server Side: a serverside appliction that tracks all the requests coming in and distrivutes them between instances of the required service
    - AWS Elastic Load Balancer
- Client Side: information is made aware to the client about the options for which instance of the service to query. The client decides where to go
    - Ribbon, part of the netflix stack, is a client side load balancer built into Spring Cloud Gateway. This is what we are using under the hood

# Discovery Service and Netflic Eureka Server

Service discovery is a method for different services to locate each other. The service registry is a key part of service discovery

Service Registry:
- Hold network locations of service instances
- Contains currently available instances of each service with connection details
- The services query the service registry to retreive details about other services
- Checks to see if the services are still running

Examples of Service Registries are Netflix Eureka and Consul

Netflix Eureka was developed by Netflix
- It provides a REST API for registering and querying service instances
- Services register themselves with a POST request
- Re-register every 30 seconds with a PUT request
- Remove a service with a DELETE request
- Get a service with a GET request

## Consul Discovery Service

Consul is an open source tool that provides service discovery, health checks, load balancing, a service graph, mutual TLS identity enforcement, and configurable key-value store

Consul agent is the core process of Consul, it maintains membership information, registers services, runs checks, responds to queries, and more. It must run on every node that is part of a Consul cluster.

- Consul addresses the new microservice architecture challenges with service discovery and allowing operators to deploy application into a zero trust network
- Consul offers us a service catalog, heath checks, automatic load balancing, and geo failover across multiple instances of the same service
- It uses mutual TLS and will automically generate and distribute the TLS certificates for every service in the mesh. The certificates are used for both:
    - Service identity verification
    - Service communication encryption
- Consul service mesh deploys sidecar proxies locally along side each service instance, which transparently handles inbound and outbound service connections, automatically verifying and encrypting TLS connections between services
- Helps us secure service communication at the network level by enabling us to manage service to service communication permissions using intentions
    - Intentions define service based access control for services in the Consul service
- In addition to securing our services, Consul mesh can also intercept data about service to service communications and surfice to monitoring tools

You can easily get started with Consul by using ther Spring Cloud Consul project that easily integrates Consul into a Spring Project

# Circuit Breaker design pattern

Circuit breaking is used to prevent a network, or service failure from cascading to other services

A circuit breaker wraps a function call with a monitor, where the monitor will be tracking potential failures. If the service is in the failed stage, the circuit will send the error message without making a call. If the service is up, the breaker forwards the call to the needed service.

Circuit Breakers have three states

- Closed state, when the service is up and running, the circuit remains closed and all calls pass through to the service

- Open state, when the number of failures exceeds a predetermined threshold the breaker trips, then goes into the open state. The open state returns an error for all calls to the service without making the calls to the supplier microservice

- Half-open state, the circuit breaker makes a trial call to the failed service periodically to check if it has recovered. If the call to the service times out, the circuit breaker will remain open, if the call returns successfully it will close it.

Netflix's Hystrix Library gives implemenation of Spring Clouds Cirtuit Breaker

# Messaging Queues

A message queue is a software component used for passing data between services, it exposes an interface for adding reading and removing messages

They facilitate async communication between services

Mesaging queue uses producers and consumers

There are two models:

- Point to Point: the producer is called the sender, the consumer is called the reciever
    - Sender and reciever exchange messages through a queue
    - Each message is recieved by only one reciever
    - Messages are ordered

- Pub/Sub: allows a message producer to broadcast a message to one or more consumers
    - The producers are called publishers, and they publish messages to a topic
    - The consumers are called subscribers, and they can subscribe to topics and consume messages

Examples are RabbitMQ, Amazon SQS, and Apache Kafka

# Config Server

We cannot simply store configuration details in our code, we need a way to have our configurations be flexible enough to cope with multiple applications, environments, and service instances

Spring Cloud Config allows us to do that by keeping configurations on VCS' like GIT

Instead of having local configuations, Spring Cloud Config lets you store all of your configurations in one repository, and pull the files whenever configuration is needed, for any service or environment

# Distributed Tracing

Tells the story of an end to end request, including everything from mobile performance to database health

It gives a solution for describing and analyzing cross-platform transactions, which can perfm anomaly detection, diagnosing steady state problems, distributed profiling, resource attribution, and workload modeling

A trace starts when a user sends a request

A span is a record of time spend in different services, these are given unique id's

All spans of a request get combined into a single distributed trace, where we can view what all happened during the request

Some distributed tracing tools are:
- Zipkin, Jaeger, Prometheus, OpenTelemetry
- Spring Cloud Sleuth, which provides Spring Boot auto configuration

# Monitoring Tools

Monitoring is the process of reporting, gathering, and storing data. Monitoring microservices helps the organization to:

- Understand the overall health of the application
- gain insight into the performance of each individual service that makes up an application
- isolate problematic transactions and endpoints
- optimize the end-user experience

Some Monitoring tools:
- Zipkin
- Grafana
- Prometheus
- CAdivsor
- Sensu
- Nagios