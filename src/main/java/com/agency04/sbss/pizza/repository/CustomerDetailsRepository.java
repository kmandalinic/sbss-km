package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {
}
