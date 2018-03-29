package com.pfizer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pfizer.models.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long>{

}
