# TodoMVC Full Stack Example

This app utilizes the well known TodoMVC example code, coupled with a simple Spring MVC restful API running on Tomcat.  

## Getting Started

This project requires Java (http://www.java.com/) and Maven (http://maven.apache.org/).

1.) Clone the git repo to your local machine.

2.) Run Maven to build and run the app
```bash
    $ mvn clean spring-boot:run
```
3.) Open your browser to: http://localhost:8080/

## Task

Once started, the app creates an in-memory database which will retain any entered data while the server is up and running.  

While things may seem functional on initial inspection, there are some bugs and missing features which we would like implemented.

As a user, I want to be able to fully manage my todo list, which means being able to create a todo item or edit an existing one.  

I also want to be able to mark an item as complete, or remove it all together from my list.  

Most importantly, I want my changes to persist between page refreshes and browser sessions (assuming the server isn't restarted).

Lastly, use the image below as a guide to update the look of the app using CSS.


![mockup](http://i.imgur.com/Nxh4hpX.png)


