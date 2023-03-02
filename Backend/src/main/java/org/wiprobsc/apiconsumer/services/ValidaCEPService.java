package org.wiprobsc.apiconsumer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.wiprobsc.apiconsumer.config.RegiaoFactory;
import org.wiprobsc.apiconsumer.dtos.EnderecoDTO;
import org.wiprobsc.apiconsumer.entities.Endereco;
import org.wiprobsc.apiconsumer.dtos.CepDTO;
import org.wiprobsc.apiconsumer.entities.Estado;
import org.wiprobsc.apiconsumer.entities.Regiao;
import org.wiprobsc.apiconsumer.mapper.Mappable;
import org.wiprobsc.apiconsumer.services.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ValidaCEPService implements Mappable {

    @Autowired
    private RegiaoFactory factory;
    public Optional<EnderecoDTO> buscarEnderecoByCEP(CepDTO entrada){
        String URL = "https://viacep.com.br/ws/"+ entrada.getCep() +"/json/";

        RestTemplate restTemplate = new RestTemplate();
        Endereco endereco = restTemplate.getForObject(URL, Endereco.class);
        isError(endereco);

        endereco = buscarValorFrete(Estado.builder().uf(endereco.getUf()).build(), endereco);

        return Optional.of(map(endereco,EnderecoDTO.class));
    }

    private void isError(Endereco endereco) {
        if(endereco.isErro()){
            throw new ResourceNotFoundException("Cep não encontrado.");
        }

    }

    private Endereco buscarValorFrete(Estado uf, Endereco endereco){
        List<Regiao> regiaos = factory.baseRegiao().stream().filter(reg ->
            reg.getEstados().contains(uf)).collect(toList());

        regiaos.forEach(regiao -> endereco.setFrete(regiao.getCustoFrete()));
        return endereco;
    }

}
