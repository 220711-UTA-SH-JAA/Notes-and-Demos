package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Reimbursement;

@Repository
public interface ReimbursementRepository extends JpaRepository<Reimbursement, Integer>{
	
	List<Reimbursement> findAllBySubmitter(Integer id);

}
