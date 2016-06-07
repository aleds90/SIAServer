package com.alessandro.appointment.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.alessandro.appointment.model.Reservation;

public class ReservationDAOImpl implements ReservationDAO{
	private SessionFactory sessionFactory;

	public ReservationDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public void insert(Reservation reservation) {
		Session session = sessionFactory.getCurrentSession();
		session.save(reservation);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Reservation> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Reservation> list = (List<Reservation>) session.createQuery("from Reservation").list();
		return list;
	}
	
	



}
