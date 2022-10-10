# Richardson Maturity Model

This is a model that breaks down the principle elements of a REST approach into three steps

0. Start with HTTP
- Interaction for your application are built on HTTP with some type of payload
1. Introduce resources
- API endpoints will be directed at particular resources
2. Verbs of HTTP
- Tie the actions taken as closely as possible with the verbs of HTTP
3. HyperMedia Controls
- The point of hypermedia controls is that they tell us what we can do next, and the URI of the resource we need to manipulate it

# SOAP
Simple Object Access Protocol, it is a contract based protocol for sending information

The specications for SOAP outline a distributed processing model
- Components in the SOAP model are nodes, and they send messages back and forth

SOAP based webservices are split into providers, requesters and registry
- Providers perform some particular service, and communicate to the requester via SOAP message
- Requesters are consumers, they utilize some service, they utilize the web service description in order to interface with the provider
- Registry is a centralized location to which providers publish their service

The Web Service Descriptor is a document that forms a contract between a provider and a requester, it is written in a specific form of XML called WSDL (Web Service Description Language)

Two versions of the WSDL 1.1, 2.0

WSDL 2.0 elements:

-   `<description>` the root of any WSDL
-   `<types>` data types used for messaging in the web service
-   `<interface>` responsible for specifying how an operation relates to its messages and how the messages relate to their datatypes
-   `<binding>` decides the protocol and format for each of the actions in the portType element
-   `<service>` contains endpoints as sub-elements

## There are two ways to create a SOAP service:

Contract first: you write the WSDL then make the code conform to it

Contract last: you write the code, then make the WSDL conform to it

SOAP message are an XML document that have a particular form, each message has:

-   `<envolope>` the root
-   `<header>` optional sub-element of the envolope
-   `<body>` contains the core info of the message
-   `<fault>` used for error reporting

# REST and SOAP Differences

| SOAP                                                        | REST                                                                                             |
| ----------------------------------------------------------- | ------------------------------------------------------------------------------------------------ |
| SOAP is a protocol.                                         | REST is an architectural style.                                                                  |
| SOAP stands for Simple Object Access Protocol.              | REST stands for REpresentational State Transfer.                                                 |
| SOAP can't use REST because it is a protocol.               | REST can use SOAP web services because it is a concept and can use any protocol like HTTP, SOAP. |
| SOAP uses services interfaces to expose the business logic. | REST uses URI to expose business logic.                                                          |
| JAX-WS is the java API for SOAP web services.               | JAX-RS is the java API for RESTful web services.                                                 |
| SOAP defines standards to be strictly followed.             | REST does not define too much standards like SOAP.                                               |
| SOAP requires more bandwidth and resource than REST.        | REST requires less bandwidth and resource than SOAP.                                             |
| SOAP defines its own security.                              | RESTful web services inherits security measures from the underlying transport.                   |
| SOAP permits XML data format only.                          | REST permits different data format such as Plain text, HTML, XML, JSON etc.                      |
| SOAP is less preferred than REST.                           | REST more preferred than SOAP.                                                                   |

# Service Oriented Architecture

Service Oriented Archicture (SOA) separates out an application into services, which are individual units of logic. These services interact with each via standardized interfaces through a network

Each service should perform a specific functionality. or piece of business logic

The goals of Service Oriented Archiecture include:
- Modularity
- Reuse of Software
- More easily adapted
- Loose Coupling Between components
- Hide Complexity
- Encapsulate Business Logic

Webservices and MicroServices are both subsets of this larger Service Oriented Architecture

# MSA

Micro Service Architecure

## What is microservices

Small, autonomous services that work together

We divide application that serve a specific purpose, and each of these communicate to create a more complicated system.

You essentially create multiple Java applications that serve a specific purpose, and each of these communicate to create a more complicated system

![arch](microservice.png)

Microservice Architecture gives us a more decentralized approach for building software, which also scales well, and has greater agility

Netflix popularized the MSA, and created their own API to handle their microservices, these were used by developers everywhere. But it is now being slowly phased out by newer API's

# Charactistics of MSA

Break our application into multiple individually deployable components, should be independently replaceable, and upgradable

Services should be organized by business logic

Provides infrastructure automation with continous delivery and automated testing

Service failures should be isolated, failure of one service should not take down the entire app

Challenges
- Finding concrete boundries between services
- Finding a root cause of an issue
- Version Management
- Logging is distributed between services
- An issue caused by one service can cause trouble elsewhere

## Advantages / Disadvantages

Advantages:
- Microservice architecture follows the single reponsibility principle
- Fault isolation - If one service crashes, the rest of the application can most likely continue running
- Microservices are language and platform independent
- Dynamic scaling - we can dynamicalkly scale up/down the service instances whenever required
- Developers have freedom to develop and deploy services indenpently
- Use of containers allowing for a quick deployment and development of the application
 
Disadvantages:
- Microservice Archictures are complex
- Harder to test and monitor because of the complexity
- Large numbers of microservices are harder to manage and secure

## MSA vs Monolith

| Monolithic                                                                                                        | MSA                                                                                                                                        |
| ----------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------ |
| Simple to develop and deploy.                                                                                     | Complex and hard to develop and deploy.                                                                                                    |
| Code changes affect the entire system.                                                                            | Only the microservice that is changed would be affected.                                                                                   |
| One codebase and one shared database.                                                                             | A codebase and database for each microservice.                                                                                             |
| Hard to scale or upgrade.                                                                                         | Easy to scale and upgrade.                                                                                                                 |
| Less expensive and faster to develop.                                                                             | More expensive and takes more time to develop.                                                                                             |
| Monolithic uses a shared database.                                                                                | Each microservice uses a single database. Each service can use any database system (MySQL, Oracle, NoSQL) depending on its business logic. |
| Monolithic applications are tightly coupled. Here, it is difficult to change technology or language or framework. | MSA ensures that the services are loosely coupled, so it's easy to make changes since services are independent to each other.              |
| The entire system can be affected by a single error or bug.                                                       | The entire system is shielded from the error or bug on one microservice.                                                                   |

## Best Practices

Use the single responisibility principle

Have separate data base for each service

Use asynchronous calls to achieve loose coupling

Fail Fast using a circuit breaker to achieve fault tolerance