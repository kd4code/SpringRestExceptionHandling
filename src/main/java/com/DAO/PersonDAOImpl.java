package com.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Entity.Person;
import com.ExceptionClasses.IDExistException;
import com.ExceptionClasses.NotValidAgeException;

@Repository
public class PersonDAOImpl implements PersonDAO {
	@Autowired
	SessionFactory sf;

	@Override
	public int register(Person p) throws IDExistException, NotValidAgeException {
		Session s = sf.openSession();
		s.beginTransaction();
		if (p.getAge() < 18)
			throw new NotValidAgeException("Entered Age Is Not Valid");
		Person p1 = s.get(Person.class, p.getId());
		if (p1 != null)
			throw new IDExistException("ID Already Exist,Please Check Again");
		int id = (int) s.save(p);
		s.getTransaction().commit();
		return id;

	}

}
