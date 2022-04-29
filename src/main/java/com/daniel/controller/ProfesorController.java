package com.daniel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.service.ProfesorService;

@RestController
@RequestMapping("/api/v1")
public class ProfesorController {
	
	@Autowired
	private ProfesorService profesorService;
	
	@GetMapping("/profesores")
	public ResponseEntity<?> getProfesores(){
		return new ResponseEntity<>(profesorService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/profesores/public")
	public ResponseEntity<?> getProfesoresPublico(){
		return new ResponseEntity<>(profesorService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/profesores/admin")
	public ResponseEntity<?> getProfesoresAdmin(){
		return new ResponseEntity<>(profesorService.findAll(), HttpStatus.OK);
	}

}
