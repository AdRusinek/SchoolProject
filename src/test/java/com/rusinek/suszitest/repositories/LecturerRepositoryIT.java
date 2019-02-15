package com.rusinek.suszitest.repositories;


import com.rusinek.suszitest.model.Lecturer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LecturerRepositoryIT {

    @Autowired
    LecturerRepository lecturerRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findLecturerByPesel() throws Exception {

        Optional<Lecturer> lecturerOptional = lecturerRepository.findByNrPesel(734829882);

        assertEquals(Optional.of(734829882),Optional.of(lecturerOptional.get().getNrPesel()));
    }
}