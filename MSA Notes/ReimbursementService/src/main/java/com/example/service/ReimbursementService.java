package com.example.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Reimbursement;
import com.example.repository.ReimbursementRepository;

@Service
public class ReimbursementService {
	
	ReimbursementRepository rRepo;
	
	@Autowired
	public ReimbursementService(ReimbursementRepository rRepo) {
		this.rRepo = rRepo;
		
	}
	
	public Reimbursement createReimbursement(Reimbursement r) {
		
		Reimbursement newR = new Reimbursement(r.getDescription(), r.getAmount(), r.getType(), r.getSubmitter());
		
		return rRepo.save(newR);
	}
	
	public Reimbursement approveOrDenyTicket(Integer ticketId, Boolean approved, Integer managerId) {
		Reimbursement r = rRepo.findById(ticketId).get();
		
		if(!r.getStatus().equals("PENDING")) {
			return r;
		}
		
		if(approved == true) {
			r.setStatus("APPROVED");
		}else {
			r.setStatus("DENIED");
		}
		
		r.setApprover(managerId);
		r.setReviewDate(new Date(System.currentTimeMillis()));
		
		return rRepo.save(r);
	}
	
	public List<Reimbursement> getAll(){
		return rRepo.findAll();
	}
	
	public List<Reimbursement> getAllByEmployee(Integer id){
		return rRepo.findAllBySubmitter(id);
	}

}
