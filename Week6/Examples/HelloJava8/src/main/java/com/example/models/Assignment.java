package com.example.models;

import java.time.LocalDateTime;
import java.util.Optional;

public class Assignment {
	
	private Student student;
	private String description;
	
	/*
	 * Date and Time API
	 * Previously in Java Dates and Times were in separate packages, and there were issues with the old classes
	 * - They introduced a new API where all the Date and Time related classes were in the same package
	 * 
	 * The java.time package includes:
	 * - LocalDate: the date info only
	 * - LocalTime: time info only
	 * - LocalDateTime: date and time info
	 * - ZonedDateTime: for working with timezones
	 * - Period: quantity of time, (years, months, days)
	 * - Duration: quantity of time (seconds, nanoseconds)
	 * - DateTimeFormatter - this allows you to represent dates/times with different formats
	 */
	private LocalDateTime dueDate;
	
	/* Optional Class
	 * Was introduced to reduce excessive null value checking
	 * 
	 * The optional class is a wrapper object which may or may not contain a value, and you use this check instead of nulls
	 * 
	 * They are use to replace nulls, because you can just set the object to empty if there is nothing there
	 */
	//The reason behind using an optional here, is because we do not have a submittedDate to start, but I don't want to
	//set the submittedDate to null
	private Optional<LocalDateTime> submittedDate;
	private Boolean graded;
	private Double grade;
	
	public Assignment(Student s, String description, LocalDateTime due) {
		this.student = s;
		this.description = description;
		this.dueDate = due;
		this.submittedDate = Optional.empty();
		this.graded = false;
		this.grade = 0.0;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public Optional<LocalDateTime> getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Optional<LocalDateTime> submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Boolean getGraded() {
		return graded;
	}

	public void setGraded(Boolean graded) {
		this.graded = graded;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Assignment [student=" + student + ", description=" + description + ", dueDate=" + dueDate
				+ ", submittedDate=" + submittedDate + ", graded=" + graded + ", grade=" + grade + "]";
	}
}
