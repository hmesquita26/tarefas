package br.com.tarefas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.tarefas.models.Tarefa;
import br.com.tarefas.util.HibernateUtil;

public class TarefaDAO {
	
	private EntityManager entityManager;
	
	
	public TarefaDAO() {
		entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
	}
	
	public void save(Tarefa tarefa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(tarefa);
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			entityManager.getTransaction().rollback();
		}
	}
	
	public void update(Tarefa tarefa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(tarefa);
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			entityManager.getTransaction().rollback();
		}
	}
	
	public void delete(Long id) {
        try {
        	entityManager.getTransaction().begin();
            Tarefa obj = entityManager.find(Tarefa.class, id);
            entityManager.remove(obj);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
        	entityManager.getTransaction().rollback();
        }
    }
	
	public Tarefa findById(Long id) {
		return entityManager.find(Tarefa.class, id);
	}
	
	public List<Tarefa> findAll() {
		List<Tarefa> result = null;
		try {
			Query query = entityManager.createQuery("FROM Tarefa ORDER BY id DESC");
			result = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
