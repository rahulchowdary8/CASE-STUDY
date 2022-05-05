package com.ondemandcarwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ondemandcarwash.model.Payments;

public interface PaymentRepository extends MongoRepository<Payments, Integer> {

}
