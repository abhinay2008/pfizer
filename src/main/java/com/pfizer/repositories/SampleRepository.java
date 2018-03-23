package com.pfizer.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pfizer.models.Sample;

public interface SampleRepository extends CrudRepository<Sample, Integer>{

}
