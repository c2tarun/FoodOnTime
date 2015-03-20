package com.fot.dao;

import java.util.List;

import com.fot.model.Model;

public interface DAO {
	
	public List<Model> getAll();
	public Model getById(String id);
	
}
