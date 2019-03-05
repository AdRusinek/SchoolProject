package com.rusinek.suszitest.repositories;

import com.rusinek.suszitest.model.Lecturer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LecturerRepository extends CrudRepository<Lecturer,Long> {

    Optional<Lecturer> findByNrPesel(Integer pesel);

    List<Lecturer> findAllByLastNameLike(String lastName);
}
