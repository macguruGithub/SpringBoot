package org.fraud;

import ch.qos.logback.classic.Logger;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class FraudController {
    FraudService fraudService;
    FraudResponse fraudResponse;

//    FraudRequest fraudRequest;
//
//    FraudController(FraudRequest fraudRequest){
//        this.fraudRequest = fraudRequest;
//    }


    @RequestMapping(value = "/{customer-id}")
    public ResponseEntity<FraudEntity> isFraudCustomer(@PathVariable(required = true, name = "customer-id")
                                                             Optional<String> optionalCustomerId){
        String customerId = optionalCustomerId.orElse("2");
        FraudEntity fraudEntity = fraudService.getFraudsterDetail(customerId);
        System.out.println("fraudEntity controller ==> "+fraudEntity);
//        fraudEntit
        return new ResponseEntity<>(fraudEntity, HttpStatus.OK);
    }




}
