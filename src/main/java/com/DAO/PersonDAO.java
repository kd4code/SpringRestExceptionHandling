package com.DAO;

import com.Entity.Person;
import com.ExceptionClasses.IDExistException;
import com.ExceptionClasses.NotValidAgeException;

public interface PersonDAO {

	public int register(Person p)throws IDExistException,NotValidAgeException;
	
}
