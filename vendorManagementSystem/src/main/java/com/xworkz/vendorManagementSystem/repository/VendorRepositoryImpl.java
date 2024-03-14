package com.xworkz.vendorManagementSystem.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vendorManagementSystem.entity.VendorEntity;

@Repository
public class VendorRepositoryImpl implements VendorRepository {
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	

	public VendorRepositoryImpl() {

		// TODO Auto-generated constructor stub
		System.out.println("invoking VendorRepositoryImpl ");
	}

	@Override
	public boolean save(VendorEntity entity) {
		// TODO Auto-generated method stub
		System.out.println("invoking save in VendorRepositoryImpl");
		System.out.println("entity is passed" + entity);
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transection = manager.getTransaction();
		try {
			transection.begin();
			manager.persist(entity);
			transection.commit();
				
		} 
		catch (Exception e) {
			transection.rollback();

		} 
		finally {
			manager.close();

		}
		return true;

	}

	@Override
	public VendorEntity isExistByNameOrEmailOrWebsite(String name, String email, String website) {
		// TODO Auto-generated method stub
		EntityManager em=entityManagerFactory.createEntityManager();
		VendorEntity isExistVendorEntity=null;
		try {
			Query query= em.createNamedQuery("IsExistByNameOrGstNoOrWebsite");
			query.setParameter("name", name);
			query.setParameter("email", email);
			query.setParameter("website", website);
			isExistVendorEntity= (VendorEntity) query.getSingleResult();
			
		}
		catch (Exception pe) {
			System.out.println("Persistence Exception occured in isexist method "+pe.getMessage());
			return null;
			// TODO: handle exception
		}
		finally {
			System.out.println("resources closed");
			em.close();
		}
		
		return isExistVendorEntity ;
	}

	@Override
	public List<VendorEntity> findAllByAjax() {
		// TODO Auto-generated method stub
		EntityManager em=entityManagerFactory.createEntityManager();
		try {
			Query query=em.createNamedQuery("FindAll");
		List<VendorEntity> list=query.getResultList();
			return list;
		}
		catch(PersistenceException pe) {
			System.out.println("getting exception in findAllByAjax"+pe.getMessage());
		}
		finally {
			System.out.println("closing em");
			em.close();
		}
		return null;
	}
	
	@Override
	public VendorEntity isExistByEmailOtp(String email, String otp) {

		System.out.println("invoking in isExistByEmailOtp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("EntityManager:" + entityManager);
		VendorEntity entity = null;
		try {
		Query query = entityManager.createNamedQuery("isExistByEmailOtp");
		query.setParameter("email", email);
		query.setParameter("otp", otp);
		entity = (VendorEntity) query.getSingleResult();
		}catch (PersistenceException pe) {
		System.out.println("Persistence is saved:" + pe.getMessage());
		}finally {
		entityManager.close();

		}
		return entity;
		}
	
	@Override
	public void updateOtpByEmail(String email, String otp) {
		// TODO Auto-generated method stub
		
		System.out.println("invoking in updatedOtpByEmail");
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		System.out.println("EntityManager:" + entityManager);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
		entityTransaction.begin();
		Query query = entityManager.createNamedQuery("updatedOtpByEmail");
		query.setParameter("email", email);
		Object object = query.getSingleResult();
		VendorEntity entity = (VendorEntity)object;
		if(entity !=null) {
			entity.setOtp(otp);
		entityManager.merge(entity);
		entityTransaction.commit();
		System.out.println("updatedOtpByEmail is updated");
		}
		}catch (PersistenceException pe) {
		System.out.println("Persistence is saved:" + pe.getMessage());
		}finally {
		entityManager.close();
		
	}
	
	
	
	}

}
