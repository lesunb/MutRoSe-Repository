package br.unb.cic.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unb.cic.modelling.models.MutRoSe;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "API REST MUTROSE")
public class IntegrationController {
	@Autowired
	private IntegrationService service;

	@ApiOperation(value = "Executa a decomposição realizada pelo MutRoSe.")
	@RequestMapping(value = "/load/mutrose", method = RequestMethod.POST)
	public String loadMultRoSe(@RequestBody MutRoSe content) {
		return this.service.generateBinMultRoSe(content);
	}

	@ApiOperation(value = "Recupera os logs do terminal para o PiStar.")
	@RequestMapping(value = "/load/terminal", method = RequestMethod.GET)
	public List<String> loadTerminal() {
		return this.service.loadTerminal();
	}

}