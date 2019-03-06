package com.rusinek.suszitest.repositories;

import com.rusinek.suszitest.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {

}
