package com.rusinek.suszitest.services;

import com.rusinek.suszitest.model.Lecturer;

import java.util.List;
import java.util.Set;

public interface LecturerService {

    Lecturer findById(Long id);

    Set<Lecturer> getLecturers();

    void deleteLecturerById(Long id);

    List<Lecturer> findAllByLastNameLike(String lastName);
}
