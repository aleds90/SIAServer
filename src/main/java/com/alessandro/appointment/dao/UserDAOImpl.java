package com.alessandro.appointment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.alessandro.appointment.model.Role;
import com.alessandro.appointment.model.User;


public class UserDAOImpl implements UserDAO {
	   
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	 public User loadUserByUsername(String username) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User u where u.username ='" + username + "'" );
		System.out.println("sono qua");
		User u = new User();
		u = (User) query.uniqueResult();
		Role r = new Role();
        r.setName("ROLE_APP");
        List<Role> roles = new ArrayList<Role>();
        roles.add(r);
        u.setAuthorities(roles);
		return u;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<User> getAll() {
		Session session = sessionFactory.getCurrentSession();
	   
	   	List<User> list = (List<User>) session.createQuery("from User").list();

		return list;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public void insert(User user) {
		Session session = sessionFactory.getCurrentSession();
		   
	   	session.save(user);
	   	
	
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<User> getBySearch(String search) {
	
		Session session = sessionFactory.getCurrentSession();
		
	
        List<User> listUser = session.createCriteria(User.class)
        		.add(Restrictions.disjunction()
        				.add(Restrictions.like("name", search+"%"))
        				.add(Restrictions.like("surname", search+"%"))
        				.add(Restrictions.like("competence", search+"%"))
        				.add(Restrictions.like("city", search+"%"))
        				.add(Restrictions.like("address", "%"+search+"%"))
        			).list();
        
  

		return listUser;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<User> getRandomAnnouncement() {
		
		Session session = sessionFactory.getCurrentSession();
		List<User> list = (List<User>) session.createQuery("from User as u where u.competence is not null ").list();
		
		return list;
	}
	


}
