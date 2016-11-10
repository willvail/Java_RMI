# Java_RMI
Assignment 2 for NET4005 @ Carleton University
Author(s): William Vail 

Objective:
Objective of this assignment is to write a simple client-server network application using the Remote Procedure Call (RPC)
or the Remote Method Invocation (RMI) system.

You will write a simple air-ticket reservation system, using RPC/RMI mechanism. The reservation server (rsvserver)
maintains the seat availability information and responds to client requests for reservation or availability. For simplicity,
we are concerned about one flight on one date only. The reservation information will be maintained only in memory, no
need to maintain a persistent database.

1. Rmi_Interface

This program runs as the communicator between the following programs. 
It allows the server to communicate with the client with or without the use of a network.

2. rsvserver

This program holds the air plane state information (i.e seats that have been taken) and 
processes the information as the client attempts to book seats.

3. rsvclient

This program is where the user will request for one of three diffrent options.
	a) Book a flight (java rsvclient <hostname> <class type> <User name> <seat #)
	b) List the avaliable seats and ticket prices. (java rsvclient <hostname> list)
	c) List all passengers on the flight and retrospective seat numbers and class. (java rsvclient <hostname> passengerlist)
The only requirement for this implementation is for the hostname to specify it as such:
	/localhost/rsvserver
Since both programs will be run locally and the destination is the rsvserver application.
