package br.unb.cic.integration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.unb.cic.modelling.models.MutRoSe;
import br.unb.cic.modelling.models.MutRoSeProducer;
import br.unb.cic.mutrose.analiser.SintaticAnaliserMutRoSe;

@Service
public class IntegrationService {
	
	private  SintaticAnaliserMutRoSe sintaticAnaliserMutRoSe = new SintaticAnaliserMutRoSe();

	public String generateBinMultRoSe(MutRoSe content) {
		MutRoSeProducer mrs = new MutRoSeProducer();
		return mrs.execute(content.getModelFile(), content.getHddlFile(), content.getConfigFile(), content.getWorldFile());
	}

	public List<String> loadTerminal() {
		List<String> erros = new ArrayList<String>();

		erros.add(sintaticAnaliserMutRoSe.recoverLogsError());

		return erros;
	}


}
