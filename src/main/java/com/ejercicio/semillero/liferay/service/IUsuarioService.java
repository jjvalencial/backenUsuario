package com.ejercicio.semillero.liferay.service;

import java.util.List;

import com.ejercicio.semillero.liferay.models.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario save(Usuario usuario);
	
	public void delete(Long id); 
	
	public Usuario findById(Long id);

}
