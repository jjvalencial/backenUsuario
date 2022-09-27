package com.ejercicio.semillero.liferay.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ejercicio.semillero.liferay.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	
	

}
