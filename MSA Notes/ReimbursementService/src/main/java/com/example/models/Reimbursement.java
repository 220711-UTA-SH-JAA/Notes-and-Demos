package com.example.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reimbursements")
public class Reimbursement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="reimbursement_id")
	private Integer reimbursementId;
	
	private String description;
	
	private Double amount;
	
	private String type;
	
	@Column(name="employee_id")
	private Integer submitter;
	
	@Column(name="submitted_date")
	private Date submittedDate;
	
	@Column(name="manger_id")
	private Integer approver;
	
	@Column(name="review_date")
	private Date reviewDate;
	
	private String status;

	public Reimbursement() {
		super();
	}

	public Reimbursement(Integer reimbursementId, String description, Double amount, String type, Integer submitter,
			Date submittedDate, Integer approver, Date reviewDate, String status) {
		super();
		this.reimbursementId = reimbursementId;
		this.description = description;
		this.amount = amount;
		this.type = type;
		this.submitter = submitter;
		this.submittedDate = submittedDate;
		this.approver = approver;
		this.reviewDate = reviewDate;
		this.status = status;
	}

	public Reimbursement(String description, Double amount, String type, Integer submitter) {
		super();
		this.description = description;
		this.amount = amount;
		this.type = type;
		this.submitter = submitter;
		this.status = "PENDING";
		this.submittedDate = new Date(System.currentTimeMillis());
		this.approver = null;
		this.reviewDate = null;
	}

	public Integer getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(Integer reimbursementId) {
		this.reimbursementId = reimbursementId;
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

	public Integer getSubmitter() {
		return submitter;
	}

	public void setSubmitter(Integer submitter) {
		this.submitter = submitter;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Integer getApprover() {
		return approver;
	}

	public void setApprover(Integer approver) {
		this.approver = approver;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", description=" + description + ", amount="
				+ amount + ", type=" + type + ", submitter=" + submitter + ", submittedDate=" + submittedDate
				+ ", approver=" + approver + ", reviewDate=" + reviewDate + ", status=" + status + "]";
	}

}
