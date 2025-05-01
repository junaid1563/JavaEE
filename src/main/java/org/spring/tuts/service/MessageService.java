package org.spring.tuts.service;

import java.util.List;

import org.spring.tuts.entity.Message;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@RequestScoped
@Transactional
public class MessageService {

	@Inject
	private EntityManager em;
	
	public void create(Message message) {
		em.persist(message);
	}
	
	public List<Message> findAllMessages(){
		return em.createQuery("from Message m", Message.class)
				.getResultList();
	}
}
