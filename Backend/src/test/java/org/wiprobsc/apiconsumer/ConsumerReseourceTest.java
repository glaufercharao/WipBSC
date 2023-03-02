package org.wiprobsc.apiconsumer;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.wiprobsc.apiconsumer.dtos.EnderecoDTO;
import org.wiprobsc.apiconsumer.dtos.CepDTO;
import org.wiprobsc.apiconsumer.resources.ConsumerResource;
import org.wiprobsc.apiconsumer.services.ValidaCEPService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsumerResource.class)
public class ConsumerReseourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ValidaCEPService service;

    private EnderecoDTO endereco;

    @BeforeEach
    public void beforeSetup() {
        endereco = new EnderecoDTO();
        endereco.setCep("89254300");
        endereco.setLogradouro("logradouro");
        endereco.setComplemento("de 1156/1157 ao fim");
        endereco.setBairro("Rau");
        endereco.setLocalidade("Jaraguá do Sul");
        endereco.setUf("SC");
    }


    @Test
    public void deveraRetornarUmaCotacao() throws Exception {
        CepDTO entrada = new CepDTO();
        entrada.setCep("89254300");

        Mockito.when(service.buscarEnderecoByCEP(entrada)).thenReturn(Optional.of(endereco));

        mockMvc.perform(post("/v1/consulta-endereco/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writer().writeValueAsString(entrada)))
                        .andExpect(status().isOk());

        assertTrue(endereco.getCep().equals(entrada.getCep()));
    }
}
