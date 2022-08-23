package com.example.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.Employee;

@Transactional //Tells Spring ORM to manage our transactions
@Repository("EmployeeDaoBean")
public class EmployeeDaoImpl implements EmployeeDao{
	
	private SessionFactory sessFact;
	
	@Autowired
	public EmployeeDaoImpl(SessionFactory sessFact) {
		this.sessFact = sessFact;
	}

	@Override
	public List<Employee> selectAllEmployees() {
		// TODO Auto-generated method stub
		return sessFact.getCurrentSession().createQuery("from Employee", Employee.class).list();
	}

	@Override
	public void createEmployee(Employee e) {
		/* Originally if we wanted to save an employee
		 * Session ses = hibernateUtil.getSession()
		 * Transaction transaction = ses.beginTransaction()
		 * ses.save(e)
		 * transaction.commit()
		 * ses.close()
		 */
		sessFact.getCurrentSession().save(e);
		
	}

	@Override
	public void updateEmployee(Employee e) {
		sessFact.getCurrentSession().update(e);
	}

	@Override
	public void deleteEmployee(Employee e) {
		sessFact.getCurrentSession().delete(e);
	}

}
