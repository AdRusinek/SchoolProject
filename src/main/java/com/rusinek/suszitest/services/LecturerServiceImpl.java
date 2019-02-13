package com.rusinek.suszitest.services;

import com.rusinek.suszitest.model.Lecturer;
import com.rusinek.suszitest.repositories.LecturerRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LecturerServiceImpl implements LecturerService {

    private final LecturerRepository lecturerRepository;

    public LecturerServiceImpl(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    @Override
    public Set<Lecturer> getLecturers() {
        Set<Lecturer> lecturers = new HashSet<>();

        lecturerRepository.findAll().forEach(lecturers::add);

        return lecturers;
    }
}
