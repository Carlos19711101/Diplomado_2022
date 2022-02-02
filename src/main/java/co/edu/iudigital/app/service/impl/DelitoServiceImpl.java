package co.edu.iudigital.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.iudigital.app.dto.DelitoDto;
import co.edu.iudigital.app.model.Delito;
import co.edu.iudigital.app.repository.IDelitoRepository;
import co.edu.iudigital.app.service.iface.IDelitoService;




@Service
public class DelitoServiceImpl implements IDelitoService {
	@Autowired
	private IDelitoRepository delitoRepository;

	
	@Override
	public List<DelitoDto> findAll() {
		List<Delito> delitos = delitoRepository.findAll();
		List<DelitoDto> delitosDto = new ArrayList<>();
		
		for(Delito delito : delitos ) {
			DelitoDto delitoDto = new DelitoDto();
			delitoDto.setId(delito.getId());
			delitoDto.setNombre(delito.getNombre());
			delitoDto.setDescripcion(delito.getDescripcion());
			delitosDto.add(delitoDto);
		}
		return delitosDto;
	}

	@Override
	public Delito findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Delito save(Delito delito) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
