package org.wiprobsc.apiconsumer.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class Estado {
    private String uf;
}
