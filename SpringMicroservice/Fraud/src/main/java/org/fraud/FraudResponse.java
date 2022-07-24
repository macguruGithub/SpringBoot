package org.fraud;

import lombok.Data;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@Component
public class FraudResponse {
    private String CustomerId;
    private Boolean isFraudster;

}
