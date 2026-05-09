ParallelServe - A Multithreaded Web Server in Java

ParallelServe is a Java-based web server project developed using Core Java Socket Programming. The project demonstrates different server architectures for handling HTTP requests, including Single Threaded, Multithreaded, and Thread Pool based implementations.

The project focuses on understanding low-level client-server communication, multithreading, concurrency handling, and HTTP request-response processing without using external frameworks such as Spring Boot.

Features
HTTP Request and Response handling using Core Java
Socket-based client-server communication
Single Threaded Server implementation
Multithreaded Server implementation
Thread Pool based Server implementation using ExecutorService
Concurrent client simulation
Modular project architecture
Request parsing and response generation
Browser-based testing support
JMeter performance testing support

Project Structure 

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

Components Description


Client

Simulates multiple concurrent clients sending HTTP requests to the server.

ClientHandler

Handles communication between the client and the server. It processes requests and sends responses.

RequestParser

Parses incoming HTTP requests and extracts requested resources and request details.

ResponseGenerator

Generates HTTP responses including status codes, headers, and HTML content.

SingleThreadedWebServer

Processes one client request at a time sequentially.

MultithreadedServer

Creates a separate thread for every client request to support concurrent processing.

ThreadPoolServer

Uses a fixed-size thread pool with ExecutorService for efficient and scalable request handling.

Technologies Used
Java
Socket Programming
Multithreading
ExecutorService
Maven
IntelliJ IDEA
Apache JMeter
