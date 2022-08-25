package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*	Spring Boot Intro
 * 
 *	Spring Boot is an open source Spring Framework project used to rapidly create java based, production-grade application
 *	utilizing the Spring Framework
 *	- An opinionated view of Spring, or an opinionated way of created Spring applications
 *	- Spring Boot is NOT a module of spring, it is a way to generated preconfigured spring applications based on the
 *		dependences that you want
 *
 *	Spring boot simplifies project creation because it allows you to pick and choose different Spring Frameworks and dependencies
 *	and configures them for you
 *	
 *	Spring boot also has a built in TomCat server, so you don't have to map or handle servlets
 *	- Spring boot handles everything behind the scenes
 */


/* To enable auto configuration of Spring boot, you just need to annotate your driver with @SpringBootApplication
 * - Is a combination of the following annotations
 * 	- @SpringBootConfiguration
 * 	- @EnabledAutoConfiguration
 * 	- @ComponentScan
 * 
 * We can also override any auto configuration in the application.properties file located in the src/main/java/resources
 * 
 */

/* Spring Boot DevTools
 * A development tool for Spring Boot applications which only does two things
 * - Cache Disable: caching is helpful in production, however, it can hinder development workflow
 * - Automatically refesh your tomcat server
 */
@SpringBootApplication
public class GroceryListSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryListSpringBootApplication.class, args);
	}

}
