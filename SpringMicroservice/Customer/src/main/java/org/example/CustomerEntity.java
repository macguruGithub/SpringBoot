package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data //getters and setters
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerEntity {
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Id
    private Long id;
    private String name;

    //TODO : email - unique - handled in the code, later needs to handled in jpa
    private String email;

    @Transient
    @JsonIgnore
    private CustomerController.Error errorMsg;

}
