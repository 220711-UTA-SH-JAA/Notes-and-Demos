package com.example.models;

import java.time.LocalDateTime;

public class Ticket {
	
	private Integer ticketId;
	private String description;
	private Double amount;
	private String type;
	private String status;
	private Employee submitter;
	private LocalDateTime submittedDate;
	private Employee resolver;
	private LocalDateTime resolvedDate;
	
	public Ticket() {
		super();
	}

	public Ticket(Integer ticketId, String description, Double amount, String type, String status, Employee submitter,
			LocalDateTime submittedDate, Employee resolver, LocalDateTime resolvedDate) {
		super();
		this.ticketId = ticketId;
		this.description = description;
		this.amount = amount;
		this.type = type;
		this.status = status;
		this.submitter = submitter;
		this.submittedDate = submittedDate;
		this.resolver = resolver;
		this.resolvedDate = resolvedDate;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getSubmitter() {
		return submitter;
	}

	public void setSubmitter(Employee submitter) {
		this.submitter = submitter;
	}

	public LocalDateTime getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(LocalDateTime submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Employee getResolver() {
		return resolver;
	}

	public void setResolver(Employee resolver) {
		this.resolver = resolver;
	}

	public LocalDateTime getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(LocalDateTime resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", description=" + description + ", amount=" + amount + ", type=" + type
				+ ", status=" + status + ", submitter=" + submitter + ", submittedDate=" + submittedDate + ", resolver="
				+ resolver + ", resolvedDate=" + resolvedDate + "]";
	}
	
}
