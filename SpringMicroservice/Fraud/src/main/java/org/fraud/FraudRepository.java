package org.fraud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FraudRepository extends JpaRepository<FraudEntity,Long> {

}
