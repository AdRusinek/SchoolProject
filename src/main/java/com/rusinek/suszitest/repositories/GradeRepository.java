package com.rusinek.suszitest.repositories;

import com.rusinek.suszitest.model.Grade;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade,Long> {

}
