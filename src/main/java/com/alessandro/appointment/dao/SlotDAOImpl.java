package com.alessandro.appointment.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.alessandro.appointment.model.Slot;

public class SlotDAOImpl implements SlotDAO{
	
	private SessionFactory sessionFactory;

	public SlotDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public void insert(Slot slot) {
		Session session = sessionFactory.getCurrentSession();
		session.save(slot);
	}
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Slot> getAll() {
		 Session session = sessionFactory.getCurrentSession();
		 List<Slot> list = (List<Slot>) session.createQuery("from Slot").list();		
		 return list;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Slot> getAllByUser(int user) {
		Session session = sessionFactory.getCurrentSession();
		List<Slot> list = (List<Slot>) session.createQuery("FROM Slot AS sl WHERE sl.reservation.user.id ="+user).list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Slot> getAllByAppointment(int appointment) {
		Session session = sessionFactory.getCurrentSession();
		List<Slot> list = (List<Slot>) session.createQuery("FROM Slot AS sl WHERE sl.appointment.id ="+appointment).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public void update(int reservation, int slot) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "UPDATE Slot set reservation.id = :reservation "  + 
	             "WHERE id = :slot";
		Query query = session.createQuery(hql);
		query.setParameter("reservation", reservation);
		query.setParameter("slot", slot);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
		
	}

}
