package com.daniel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.dao.ProfesorDao;
import com.daniel.entity.Profesor;

@Service
public class ProfesorImpl implements ProfesorService{
	
	@Autowired
	private ProfesorDao profesorDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Profesor> findAll() {
		// TODO Auto-generated method stub
		return (List<Profesor>) profesorDao.findAll();
	}

}
