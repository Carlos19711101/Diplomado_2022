package co.edu.iudigital.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.iudigital.app.dto.UsuarioDto;
import co.edu.iudigital.app.exception.RestException;
import co.edu.iudigital.app.model.Usuario;
import co.edu.iudigital.app.repository.IUsuarioRepository;
import co.edu.iudigital.app.service.iface.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public List<UsuarioDto> ListUsers() throws RestException {
		List<Usuario> usuarioDB = usuarioRepository.findAll();
		List<UsuarioDto> usuario = new ArrayList<>();
		usuarioDB.stream()
		         .forEach(u -> {
		        	 UsuarioDto usuarioDto = new UsuarioDto();
		        	 usuarioDto.setId(u.getId());
		        	 usuarioDto.setNombre(u.getNombre());
		        	 usuarioDto.setApellido(u.getApellido());
		        	 
		        	 
		         });
		
	}

}
