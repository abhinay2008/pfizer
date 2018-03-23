package com.pfizer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pfizer.models.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>{

}
