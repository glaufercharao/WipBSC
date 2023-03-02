package org.wiprobsc.apiconsumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.wiprobsc.apiconsumer.entities.Estado;
import org.wiprobsc.apiconsumer.entities.Regiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
public class RegiaoFactory {

    @Bean
    public List<Regiao> baseRegiao(){

        Regiao norte = Regiao.builder()
                .nomeRegiao("Norte")
                .custoFrete(20.83)
                .estados(Arrays.asList(Estado.builder().uf("AC").build(),
                        Estado.builder().uf("AP").build(),
                        Estado.builder().uf("AM").build(),
                        Estado.builder().uf("PA").build(),
                        Estado.builder().uf("RO").build(),
                        Estado.builder().uf("RR").build(),
                        Estado.builder().uf("TO").build())).build();

        Regiao nordeste = Regiao.builder()
                .nomeRegiao("Nordeste")
                .custoFrete(15.98)
                .estados(Arrays.asList(Estado.builder().uf("AL").build(),
                        Estado.builder().uf("BA").build(),
                        Estado.builder().uf("CE").build(),
                        Estado.builder().uf("MA").build(),
                        Estado.builder().uf("PB").build(),
                        Estado.builder().uf("PE").build(),
                        Estado.builder().uf("PI").build(),
                        Estado.builder().uf("RN").build(),
                        Estado.builder().uf("SE").build())).build();

        Regiao centroOste = Regiao.builder()
                .nomeRegiao("Centro-Oeste")
                .custoFrete(12.50)
                .estados(Arrays.asList(Estado.builder().uf("DF").build(),
                        Estado.builder().uf("GO").build(),
                        Estado.builder().uf("MT").build(),
                        Estado.builder().uf("MS").build())).build();

        Regiao sudeste = Regiao.builder()
                .nomeRegiao("Sudeste")
                .custoFrete(7.85)
                .estados(Arrays.asList(Estado.builder().uf("ES").build(),
                        Estado.builder().uf("MG").build(),
                        Estado.builder().uf("RJ").build(),
                        Estado.builder().uf("SP").build())).build();

        Regiao sul = Regiao.builder()
                .nomeRegiao("Sul")
                .custoFrete(17.30)
                .estados(Arrays.asList(Estado.builder().uf("RS").build(),
                        Estado.builder().uf("SC").build(),
                        Estado.builder().uf("PR").build())).build();

        List<Regiao> regioes = new ArrayList<>();
        regioes.add(sul);
        regioes.add(sudeste);
        regioes.add(centroOste);
        regioes.add(nordeste);
        regioes.add(norte);

        return regioes;
    }
}
