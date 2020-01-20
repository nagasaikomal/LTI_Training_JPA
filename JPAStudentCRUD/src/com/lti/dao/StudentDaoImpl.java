package com.lti.dao;

import javax.persistence.EntityManager;
import com.lti.model.Student;
import com.lti.utils.JpaUtils;

public class StudentDaoImpl implements StudentDao {

	private EntityManager entityManage;
	
	public StudentDaoImpl() {
		entityManage= JpaUtils.getEntityManager();
	}
	
	@Override
	public int createStudent(Student student) {
		entityManage.persist(student);
		return 1;
	}

	@Override
	public Student readStudent(int rollNumber) {
		return entityManage.find(Student.class, rollNumber);
		
	}

	@Override
	public void beginTransaction() {
		// TODO Auto-generated method stub
		entityManage.getTransaction().begin();
		
	}

	@Override
	public void commitTransaction() {
		// TODO Auto-generated method stub
		entityManage.getTransaction().commit();
		
	}

	@Override
	public void rollbackTransaction() {
		// TODO Auto-generated method stub
		entityManage.getTransaction().rollback();
		
	}
	
}
