package com.rusinek.suszitest.converters;

import com.rusinek.suszitest.commands.StudentCommand;
import com.rusinek.suszitest.model.Student;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class StudentToStudentCommand implements Converter<Student, StudentCommand> {

    @Synchronized
    @Nullable
    @Override
    public StudentCommand convert(Student source) {
        if (source == null) {
            return null;
        }

        final StudentCommand command = new StudentCommand();
        command.setId(source.getId());
        command.setFirstName(source.getFirstName());
        command.setLastName(source.getLastName());
        command.setDateOfBirth(source.getDateOfBirth());
        command.setNrPesel(source.getNrPesel());

        return command;
    }
}
