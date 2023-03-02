package org.wiprobsc.apiconsumer.entities;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Regiao {
    private String nomeRegiao;
    private double custoFrete;
    private List<Estado> estados;
}
