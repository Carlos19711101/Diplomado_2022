package co.edu.iudigital.app.controller;




import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.iudigital.app.dto.DelitoDto;
import co.edu.iudigital.app.exception.RestException;
import co.edu.iudigital.app.model.Delito;
import co.edu.iudigital.app.service.iface.IDelitoService;
import co.edu.iudigital.app.service.impl.DelitoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/delitos")

@Api(value="/delitos", tags= {"Delitos"})
@SwaggerDefinition(tags= {
		@Tag (name = "Delitos", description = "Gestion API Delitos")
})
public class DelitoController {

	private static final Logger log = LoggerFactory.getLogger(DelitoController.class);
	
	@Autowired
	private IDelitoService delitoService;
	
	
	/*@Autowired
	public DelitoController() {
		
	}*/
	
	DelitoServiceImpl delitosService = new DelitoServiceImpl();
	
	@ApiOperation(value = "obtiene todos los delitos",
			response = DelitoDto.class,
			responseContainer = "list",
			produces = "Application/json",
			httpMethod = "GET")
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<DelitoDto> index(){
		log.info("Inicio index controller");
		return delitosService.findAll();
	}
	@ApiOperation(value = "obtiene un delitos por su id",
			response = Delito.class,
			produces = "Application/json",
			httpMethod = "GET")
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/delito/{id}")
	public Delito show(@PathVariable final long id) {
		return delitoService.findById(id);
	}
	
	@ApiOperation(value = "Guardar delitos",
			response = Delito.class,
			responseContainer = "list",
			produces = "Application/json",
			httpMethod = "POST")
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public Delito create(@RequestBody @Valid Delito delito) {
		return delitoService.save(delito);
	}
	@ApiOperation(value = "Eliminar un  delito por id",
			produces = "Application/json",
			httpMethod = "POST")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/delito/{id}")
	public void delete(@PathVariable long id)throws RestException {
		 delitoService.delete(id);
	}
	
}
