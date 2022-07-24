package org.fraud;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

@Component
public record FraudService(FraudRepository repository) {

    public FraudEntity getFraudsterDetail(String customerId){
        //TODO :: this bad query needs to correct later
        List<FraudEntity> fraudEntityList = repository.findAll();
        Optional<FraudEntity> optionalFraudEntity = fraudEntityList.stream().filter(fraudEntity -> fraudEntity.getCustomerId().equals(customerId)).findFirst();
        FraudEntity fraudEntity = null;
        if(optionalFraudEntity.isEmpty()){
            fraudEntity = repository.save(FraudEntity.builder().customerId(customerId).isFraudster(false).localDateTime(LocalDateTime.now()).build());
        }else{
            fraudEntity = optionalFraudEntity.get();
        }
        return fraudEntity;
    }
}
