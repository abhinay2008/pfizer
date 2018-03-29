package com.pfizer.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pfizer.models.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long>{

}
