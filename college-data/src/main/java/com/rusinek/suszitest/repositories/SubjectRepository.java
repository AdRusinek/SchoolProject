package com.rusinek.suszitest.repositories;

import com.rusinek.suszitest.model.Subject;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface SubjectRepository extends CrudRepository<Subject,Long> {

    Optional<Subject> findBySubjectName(String subjectName);
}
