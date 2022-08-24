package com.example.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.models.Employee;

//We want spring to manage our aspect, so we will mark it with @Component
@Component
//We also have to mark this class as an aspect
@Aspect
public class LoggingAspect {
	
	/* Advice
	 * Are actions that are take at a specific moment in the application execution, these are defined as a method (inside of the aspect)
	 * We have 5 types of advice:
	 * - Before: this is some advice that runs before the join point
	 * - After Returning: this is some advice that runs after a join point returns successfully
	 * - After Throwing: this is some advice that runs after a join point throws an exception
	 * - After: this is some advice that runs no matter what after a join point
	 * - Around: this is some adive that runs before and after a join point, this is most powerful, and is only recommeded to be used
	 * 		if you have no other options
	 * 
	 * It is best practice to use the least powerful possible
	 * 
	 * Pointcuts and Join Points with AspectJ
	 * 
	 * Pointcuts determine the joinpoints, because they define which methods in our application advice ought to be injected into or around
	 * 
	 * Joinpoints are the specific moment during the executino of a program where an advice is taken
	 * 
	 * Our pointcuts are comprised of a name, any parameters, and keep in mind they define EXACTLY where the advice will be taken
	 * 
	 * To create these use @Pointcut annotation with regular method signatures
	 * - execution
	 * - within
	 * - this
	 * - target
	 * - args...
	 * 
	 * 
	 * Execution will be the most widely used, (when some method executes), to specify the method to listen for you use this syntax
	 * with different wild cards
	 * 
	 * @AdviceType("execution(modifiers? return-types declaring-type? name(parameters) throws?")
	 * 
	 */
	
    /*
     * PointCut expressions are used to select joinpoints, or in other works, pointcuts target a subset of joinpoints
     * PointCut expression symbols
     * "*" is a wildcard that for return types, methods, and single parameter in a parameter list
     * ".." us a wildcard for the parameter list of a method
     * These examples are from another trainers examples, but you can still take a look to see some examples of more wildcard use
     * @Before("execution(* *(..)") this will execute on all the methods
     * @Before("execution(* draw*(..))") this one will match any method with draw in the name and one or zero parameter
     * @Before("execution(int *aw*(..))") this one will match any method that returns an integer and has aw in the method name, with one or zero parameters
     * @Before("execution(* *(char, int)") this one will match any method that takes in a char and int as its paramaters
     * @Before("execution(* *aw*(..,int))") this one will match any method with aw in its name, and has 1 or 2 paremeters, the second parameter being an int
     * @Before("execution(protected * *(..)") this one will match any method with one or zero parameters that is protected
     */
	
	//Create a set of joinpoint that gets called before the execution of any method in the entire application
	@Before("execution(* com.example.services.*.*(..))")
	public void printBeforeAll(JoinPoint jp) {
		System.out.println("The method: " + jp.getSignature() + " was called");
	}
	
	//Now we should see the only messages are for userservice, not ticket service
	@Before("execution(* com.example.services.EmployeeService.*(..))")
	public void printEmployeeServicesCalled(JoinPoint jp) {
		System.out.println("The user service was called");
	}
	
	//AfterReturning
	@AfterReturning("execution(* com.example.services.EmployeeService.login(..))")
	public void printSuccessfulLogin(JoinPoint jp) {
		System.out.println("User: " + jp.getArgs()[0] + " was logged in");
	}
	
	//After throwing an exception
	@AfterThrowing("execution(* com.example.services.EmployeeService.saveEmployee(..))")
	public void printUnsuccessfulEmployeeDao(JoinPoint jp) {
		System.out.println("There was a problem in the saving the employee");
	}
	
	//After anything
	@After("execution(* com.example.services.*.*(..))")
	public void printNoMatterWhat(JoinPoint jp) {
		System.out.println("This will print no matter if there was an exception or if there was no exception");
	}
	
	//Around advice
	@Around("execution(* com.example.services.EmployeeService.login(..))")
	public void around(ProceedingJoinPoint pjp) throws Throwable{
		
		//The top will act as before
		System.out.println("In the around advice, a user is currently attempting to login");
		
		//To continue executing the method, we have to call pjp.proceed()
		pjp.proceed();
		
		System.out.println("The user may or may not have logged in, but this is printing after the proceed");
		
	}

}
