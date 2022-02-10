package co.edu.iudigital.app.service.iface;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.iudigital.app.dto.UsuarioDto;
import co.edu.iudigital.app.exception.RestException;

@Service
public interface IUsuarioService {

	public List<UsuarioDto> ListUsers() throws RestException;
}
