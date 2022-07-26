package org.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.List;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {

    public CustomerEntity saveCustomerIfNotFraudster(CustomerRequest customerRequest) {
        if (customerRequest == null || Optional.ofNullable(customerRequest.email()).isEmpty()) {
            return CustomerEntity.builder().errorMsg(CustomerController.Error.BAD_REQEUST).build();
        }
        List<CustomerEntity> customerEntityList = customerRepository.findAll();
        Optional<CustomerEntity> customerEntityOptional = customerEntityList.stream().filter(customer -> customer.getEmail().trim().equalsIgnoreCase(customerRequest.email())).findFirst();
        CustomerEntity customerEntity = null;
        if (customerEntityOptional.isPresent()) {
            customerEntity = customerEntityOptional.get();
        } else {
            customerEntity = customerRepository.save(CustomerEntity.builder().name(customerRequest.name()).email(customerRequest.email()).build());
        }
        String url = "http://FRAUD/v1/" + customerEntity.getId();
        Fraud fraudResponse= restTemplate.getForObject(url, Fraud.class);
        if(fraudResponse.isFraudster()){
            return CustomerEntity.builder().errorMsg(CustomerController.Error.FRAUDSTER_USER).build();
        }
        return customerEntity;
    }

    public List<CustomerEntity> getCustomers() {
        return customerRepository.findAll();
    }
}
record Fraud(Boolean isFraudster){}