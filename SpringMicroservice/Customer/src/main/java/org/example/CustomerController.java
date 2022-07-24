package org.example;

import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

//allConstructor auto implemented in the record
@RestController
@RequestMapping("/v1")
public record CustomerController(CustomerService customerService) {

    @RequestMapping(value = "/get-customers", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<CustomerEntity>> getCustomers(){
        return new ResponseEntity<>(customerService.getCustomers(),HttpStatus.OK);

    }

    static enum Error{
        BAD_REQEUST,
        FRAUDSTER_USER
    }

    @RequestMapping(value="save-customer", method=RequestMethod.POST, produces = "application/json")
    public ResponseEntity<CustomerEntity> saveCustomerIfNotFraudster(@RequestBody CustomerRequest customerRequest){
        CustomerEntity customerEntity = customerService.saveCustomerIfNotFraudster(customerRequest);
        if(Optional.ofNullable(customerEntity.getErrorMsg()).isPresent()){
                switch (customerEntity.getErrorMsg()){
                    case BAD_REQEUST :
                            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
                    case FRAUDSTER_USER:
                            return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
                    default:
                        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
                }
        }
        return new ResponseEntity<>(customerEntity,HttpStatus.OK);
    }

}

