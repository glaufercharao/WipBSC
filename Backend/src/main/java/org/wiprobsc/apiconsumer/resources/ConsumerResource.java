package org.wiprobsc.apiconsumer.resources;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.wiprobsc.apiconsumer.dtos.EnderecoDTO;
import org.wiprobsc.apiconsumer.dtos.CepDTO;
import org.wiprobsc.apiconsumer.services.ValidaCEPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "v1/consulta-endereco/")
public class ConsumerResource {

    @Autowired
    private ValidaCEPService validaCEPService;

    @PostMapping
    public ResponseEntity<EnderecoDTO> findAllCharacter(@Valid @RequestBody CepDTO cep){
        System.out.println(cep);
        Optional<EnderecoDTO> endereco =  validaCEPService.buscarEnderecoByCEP(cep);
        System.out.println(endereco.get());
        return endereco.isPresent() ?
               ResponseEntity.ok().body(endereco.get()) :  ResponseEntity.status(HttpStatus.NOT_FOUND.value()).build();
    }
}
