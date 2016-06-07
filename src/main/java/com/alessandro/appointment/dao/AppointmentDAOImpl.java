package com.alessandro.appointment.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.alessandro.appointment.model.Appointment;
import com.alessandro.appointment.model.User;

public class AppointmentDAOImpl implements AppointmentDAO {
	
	private SessionFactory sessionFactory;

	public AppointmentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public void insert(Appointment appointment) {
		Session session = sessionFactory.getCurrentSession();
		session.save(appointment);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Appointment> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Appointment> list = (List<Appointment>) session.createQuery("from Appointment").list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Appointment> getAllByUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<Appointment> list = (List<Appointment>) session.createQuery("FROM Appointment AS ap WHERE ap.user.id ="+id).list();
		return list;
	}



}
