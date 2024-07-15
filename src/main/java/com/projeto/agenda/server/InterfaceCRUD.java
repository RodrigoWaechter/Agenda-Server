package com.projeto.agenda.server;

import java.util.List;

public interface InterfaceCRUD {

	abstract <T> String save(T clazz);
	abstract <T> String UpdateById(Integer id, T clazz);
	abstract String deleteByID(Integer id);
	abstract List<?> findAll();
	abstract Object findById(Integer id);
	
}