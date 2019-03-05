package com.rusinek.suszitest.services;

import com.rusinek.suszitest.model.Lecturer;
import com.rusinek.suszitest.repositories.LecturerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LecturerServiceImpl implements LecturerService {

    private final LecturerRepository lecturerRepository;

    public LecturerServiceImpl(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    @Override
    public Lecturer findById(Long id) {
        Optional<Lecturer> lecturer = lecturerRepository.findById(id);

        if(lecturer.isPresent()) {
            return lecturer.get();
        }
        return null;
    }

    @Override
    public Set<Lecturer> getLecturers() {
        Set<Lecturer> lecturers = new HashSet<>();

        lecturerRepository.findAll().forEach(lecturers::add);

        return lecturers;
    }

    @Override
    public List<Lecturer> findAllByLastNameLike(String lastName) {
        List<Lecturer> lecturers = (List<Lecturer>) lecturerRepository.findAll();

        return lecturers.stream()
                .filter(n -> n.getLastName().toLowerCase().contains(lastName.toLowerCase()))
                .collect(Collectors.toList());
    }
}
