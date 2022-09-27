package com.ejercicio.semillero.liferay.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.semillero.liferay.models.entity.Usuario;
import com.ejercicio.semillero.liferay.service.IUsuarioService;
import org.springframework.http.HttpStatus;


@CrossOrigin(origins= {"http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class UsuarioControllers {
	
	@Autowired
	IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario>listarUsuario(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario findById(@PathVariable Long id) {
		return usuarioService.findById(id);
		
	}
	
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
		
	}
	
	@PutMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usuarioActual=usuarioService.findById(id);
		usuarioActual.setNombres(usuario.getNombres());
		usuarioActual.setApellidos(usuario.getApellidos());
		usuarioActual.setTelefono(usuario.getTelefono());
		usuarioActual.setTipoDocumento(usuario.getTipoDocumento());
		usuarioActual.setCelular(usuario.getCelular());
		usuarioActual.setNumeroDocumento(usuario.getNumeroDocumento());
		usuarioActual.setDireccion(usuario.getDireccion());
		usuarioActual.setEdad(usuario.getEdad());
		usuarioActual.setCiudadResidencia(usuario.getCiudadResidencia());
		
		return usuarioService.save(usuarioActual);
	}
	
	
	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable long id) {
		usuarioService.delete(id);
	}


}
