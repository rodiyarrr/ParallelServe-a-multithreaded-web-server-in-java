# ParallelServe - A Multithreaded Web Server in Java

ParallelServe is a Java-based web server project developed using Core Java Socket Programming. The project demonstrates different server architectures for handling HTTP requests, including Single Threaded, Multithreaded, and Thread Pool based implementations.

The project focuses on understanding low-level client-server communication, multithreading, concurrency handling, and HTTP request-response processing without using external frameworks such as Spring Boot.

# Features

- HTTP Request and Response handling using Core Java
- Socket-based client-server communication
- Single Threaded Server implementation
- Multithreaded Server implementation
- Thread Pool based Server implementation using ExecutorService
- Concurrent client simulation
- Modular project architecture
- Request parsing and response generation
- Browser-based testing support
- JMeter performance testing support

# Project Structure 

```text
src/
├── helper/
│   ├── Client.java
│   ├── ClientHandler.java
│   ├── RequestParser.java
│   └── ResponseGenerator.java
│
├── singlethreaded/
│   └── SingleThreadedWebServer.java
│
├── multithreaded/
│   └── MultithreadedServer.java
│
└── threadpool/
    └── ThreadPoolServer.java

```
# Components Description

## Client

Simulates multiple concurrent clients sending HTTP requests to the server.

## ClientHandler

Handles communication between the client and the server. It processes requests and sends responses.

## RequestParser

Parses incoming HTTP requests and extracts requested resources and request details.

## ResponseGenerator

Generates HTTP responses including status codes, headers, and HTML content.

## SingleThreadedWebServer

Processes one client request at a time sequentially.

## MultithreadedServer

Creates a separate thread for every client request to support concurrent processing.

## ThreadPoolServer

Uses a fixed-size thread pool with ExecutorService for efficient and scalable request handling.


# Technologies Used
- Java
- Socket Programming
- Multithreading
- ExecutorService
- Maven
- IntelliJ IDEA
- Apache JMeter

# How to Run

## 1)Compile the Project
```
javac -d out src/helper/*.java src/singlethreaded/*.java src/multithreaded/*.java src/threadpool/*.java
```
## 2)Run Single Threaded Server
```
java -cp out singlethreaded.SingleThreadedWebServer
```
## 3) Run Multi Threaded Server
```
java -cp out multithreaded.MultithreadedServer
```
## 4) Run Thread Pool Server
```
java -cp out threadpool.ThreadPoolServer
```
## 5) Run Client
```
java -cp out helper.Client
```

# Browser Testing

After starting any server, open:
```
http://localhost:8010
```
in a web browser.

# Performance Testing

Apache JMeter was used to compare the performance of:

- Single Threaded Server
- Multithreaded Server
- Thread Pool Server

## Metrics analyzed:

- Response Time
- Throughput
- Concurrent Request Handling
- Scalability

# Learning Outcomes
 - Understanding HTTP protocol fundamentals
- Low-level socket communication
- Concurrent programming in Java
- Thread management and optimization
- Client-server architecture design
- Performance analysis using JMeter

# Future Enhancements
- Static HTML file serving
- Logging support
- Dynamic content handling
- HTTPS support
- File upload support
- REST API support


# Author

Anirudh Singh Shekhawat
