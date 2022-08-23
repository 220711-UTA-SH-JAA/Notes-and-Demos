package com.example.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ticket_id")
	private Integer ticketId;
	private String description;
	private Double amount;
	private String type;
	private String status;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private Employee submitter;
	
	@Column(name="submited_date")
	private LocalDateTime submittedDate;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name="manager_ticket_junction",
			joinColumns = {@JoinColumn(name="ticket_id")},
			inverseJoinColumns = {@JoinColumn(name="manager_id")}
	)
	private List<Employee> resolver;
	
	@Column(name="resolved_date")
	private LocalDateTime resolvedDate;
	
	public Ticket() {
		super();
		this.resolver = new ArrayList<>();
	}

	public Ticket(Integer ticketId, String description, Double amount, String type, String status, Employee submitter,
			LocalDateTime submittedDate, List<Employee> resolver, LocalDateTime resolvedDate) {
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

	public List<Employee> getResolver() {
		return resolver;
	}

	public void setResolver(List<Employee> resolver) {
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
				+ ", status=" + status + ", submitter=" + submitter.getEmployeeId() + ", submittedDate=" + submittedDate + ", resolver="
				+ resolver + ", resolvedDate=" + resolvedDate + "]";
	}
	
}
