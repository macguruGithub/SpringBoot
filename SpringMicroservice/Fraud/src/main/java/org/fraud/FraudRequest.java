package org.fraud;

import lombok.Builder;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Comparator;

//@Builder
@ConstructorBinding
public record FraudRequest(String customerId, Boolean isFraudster)  {



}
