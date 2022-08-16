package com.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import com.example.lambdas.MyFunctionalInterface;
import com.example.models.Assignment;
import com.example.models.Student;

public class Driver {
	
	/* Lambdas:
	 * Are possibly the biggest addition to java 8, in conjunction with functional interfaces
	 * - introduce important aspects of functional programming to java, and allow disembodied methods aka functions
	 * 
	 * The syntax will look something like this parameters -> expression
	 * 
	 * For multiple parameters you will need parenthesis, and for multiple lines of logic in the expression curly braces
	 * are needed
	 * 
	 * The return keyword is optional for single expression lambdas
	 * 
	 * Lambdas are used a lot in conjunction with forEach loops on collections, and with Stream API to apply some logic
	 * before passing data to the next stream
	 */
	
	//Lets use our functional interface with a lambda
	public static Student makeStudentFunction(String first, String last) {
		//The arrow syntax/lambda expression, is implementing the one and only method of that interface
		MyFunctionalInterface<Student> s = () -> {
			Random rand = new Random();
			//Create a random 4 digit number, and converts it to a string
			String id = String.format("%04d", rand.nextInt(10000));
			String username = first + last + id;
			String email = first + "." + last + id + "@school.edu";
			return new Student(first, last, username, email, "p@ssw0rd", true);
		};
		
		return s.execute();
	}
	
	public static Assignment makeAssignmentFunction(Student s, String description, String due) {
		
		MyFunctionalInterface<Assignment> a = () -> {
			
			//We can use a DateTimeFormatter to parse dates from strings
			DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			return new Assignment(s, description, LocalDateTime.parse(due, formatDate));
		};
		
		return a.execute();
	}
	
	public static void main(String args[]) {
		
		/* Java 8 Features
		 * 	Java 8 implemented many new and useful features
		 * 	- Functional Interface
		 * 	- Lambda Expressions
		 * 	- Stream API
		 * 	- Reflections
		 * 	- Date and Time API
		 * 	- Optional Class
		 * 	- Predicates
		 */
		Student s1 = makeStudentFunction("Ethan", "McGill");
		Student s2 = makeStudentFunction("JD", "Megargel");
		s2.setPassword("resetPassword");
		Student s3 = makeStudentFunction("Matt", "Myers");
		Student s4 = makeStudentFunction("James", "Walker");
		s4.setPassword("diffPassword");
		Student s5 = makeStudentFunction("Ryan", "Ducolon");
		
		List<Student> students = List.of(s1, s2, s3, s4, s5);
		System.out.println(students);
		
		//Take a look at a lambda in a forEach loop
		System.out.println("Printing the students");
		//For each student in the students list, do some logic on each student
		students.forEach((student) -> {
			if(student.getPassword().equals("p@ssw0rd")) {
				System.out.println(student.getFirstName() + " " + student.getLastName() + " needs to reset their password");
			}
		});
		
		//Lets use a forEach to create some assignments for the students
		List<Assignment> assignmentList = new ArrayList<>();
		
		//For each student, create 4 assignments with due dates, then add them to the assignment list
		students.forEach((student) -> {
			assignmentList.add(makeAssignmentFunction(student, "Adding", "2022-05-30 17:00"));
			assignmentList.add(makeAssignmentFunction(student, "Subtraction", "2022-06-30 17:00"));
			assignmentList.add(makeAssignmentFunction(student, "Multiplication", "2022-07-30 17:00"));
			assignmentList.add(makeAssignmentFunction(student, "Division", "2022-08-30 17:00"));
		});
		
		System.out.println("The assignments: ");
		assignmentList.forEach((assignment) -> System.out.println(assignment));
		
		/* 	Stream API
		 * 	Is a functional style of defining operations on a stream of elements
		 * 	- Streams are an abstraction which allow defining operations which do not modify the source data, and are
		 * 		lazily loaded
		 * 	Streams DO NOT store data, they simply operate on it, like filtering, mapping, or reducing it
		 * 
		 * 	Streams are divided into two types:
		 * 	- Intermediate streams: return a new stream of elements, and are always lazy, they don't execute until the
		 * 		terminal operation is executed
		 * - Terminal streams: trigger the operation of the pipeline, they perform all the operations, and return whatever we
		 * 		want
		 * Reductions/terminal operations will take a sequence of elements and combine them into a single result
		 * - .reduce(), .collect(), reduce can be used to reduce to a single value, collect can be used to put multiple results
		 * 		into a collection
		 */
		
		//Lets say, we want to get all the assignments only from the first student
		/* Naive way */
		/*
		List<Assignment> s1AssignmentNaive = new ArrayList<>();
		for(int i=0; i<assignmentList.size(); i++) {
			Assignment a = assignmentList.get(i);
			if(a.getStudent().equals(s1)) {
				s1AssignmentNaive.add(a);
			}
		}
		
		System.out.println("The student 1's assignments");
		System.out.println(s1AssignmentNaive);
		*/
		
		/* Doing this and more with streams */
		//Filter out only the assignments from student 1
		List<Assignment> s1Assignments = assignmentList.stream()
				//Filter filtered out certain data, and returned what it filtered
				.filter(assignment -> assignment.getStudent().equals(s1))
				.collect(Collectors.toList());
		
		System.out.println(s1Assignments);
		
		s1Assignments = s1Assignments.stream()
				//Map, will allows us to transform data, and return it to a collection
				.map(assignment -> {
					if(assignment.getDescription().equals("Adding")) {
						assignment.setSubmittedDate(Optional.of(LocalDateTime.of(2022, 5, 29, 15, 30)));
						assignment.setGraded(true);
						assignment.setGrade(95.0);
					}
					if(assignment.getDescription().equals("Subtraction")) {
						assignment.setSubmittedDate(Optional.of(LocalDateTime.of(2022, 6, 30, 17, 05)));
						assignment.setGraded(true);
						assignment.setGrade(65.0);
					}
					if(assignment.getDescription().equals("Multiplication")) {
						assignment.setSubmittedDate(Optional.of(LocalDateTime.of(2022, 7, 28, 12, 45)));
						assignment.setGraded(true);
						assignment.setGrade(75.0);
					}
					//The map needs a return for the transformed data
					return assignment;
				}).collect(Collectors.toList());
		
		System.out.println(s1Assignments);
		
		//We want to return all the assignments from S1 which are turned in and on time
		List<Assignment> onTimeAssignments = s1Assignments.stream()
				//First we can filter out all the assignments which are turned in
				.filter(assignment -> assignment.getSubmittedDate().isPresent())
				.filter(assignment -> assignment.getSubmittedDate().get().isBefore(assignment.getDueDate()))
				.toList();
		
		System.out.println(onTimeAssignments);
		
		//We can even use streams to reduce a collection of elements down to a single number
		Double slAverageGrade = s1Assignments.stream()
				.filter(assignment -> assignment.getGraded())
				.mapToDouble(assignment -> assignment.getGrade())
				.average()
				.getAsDouble();
		
		System.out.println("Student one average is: " + slAverageGrade);
		
	}

}
