package org.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Data
public class FraudEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String customerId;
    private Boolean isFraudster;
    private LocalDateTime localDateTime = LocalDateTime.now();

    public String toString(){
        return "id = "+id+", customerId = "+customerId+", isFraudster = "+isFraudster+" localDateTime = "+localDateTime;
    }

}


