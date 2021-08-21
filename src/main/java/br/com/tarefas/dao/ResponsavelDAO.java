package br.com.tarefas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.tarefas.models.Responsavel;
import br.com.tarefas.util.HibernateUtil;

public class ResponsavelDAO {
	
private EntityManager entityManager;
	
	public ResponsavelDAO() {
		entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
	}
	
	public void save(Responsavel responsavel) {
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(responsavel);
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			entityManager.getTransaction().rollback();
		}
	}
	
	public void update(Responsavel responsavel) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(responsavel);
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			entityManager.getTransaction().rollback();
		}
	}	
	
	public void delete(Long id) {
        try {
        	entityManager.getTransaction().begin();
        	Responsavel obj = entityManager.find(Responsavel.class, id);
            entityManager.remove(obj);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
        	entityManager.getTransaction().rollback();
        }
    }
	
	public Responsavel findById(Long id) {
		return entityManager.find(Responsavel.class, id);
	}
	
	public List<Responsavel> findAll() {
		List<Responsavel> result = null;
		try {
			Query query = entityManager.createQuery("FROM Responsavel ORDER BY id ASC");
			result = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}	
	

}
