package com.rusinek.suszitest.repositories;

import com.rusinek.suszitest.model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject,Long> {
}