package it.education.dao;

import java.util.Collection;


	public interface DaoInterface <T,k>{
//	    T--> Type   K-->Key
		Collection<T> retrieveAll();
		//retrieveOne(); ---> one record
		T retrieveOne(k id);
		//to insert
		void create(T  t);
		//Delete
		void delete(k id);
		//update
		void update(T t);
		
		
	}


