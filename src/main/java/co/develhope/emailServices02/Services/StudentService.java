package co.develhope.emailServices02.Services;

import co.develhope.emailServices02.Entities.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    static List<Student> students = Arrays.asList(
            new Student("1", "Alessio", "Pollina", "pollinaalessio1@gmail.com"),
            new Student("2", "Mario", "Rossi", "lory1991@develhope.co"),
            new Student("3", "Giulio", "Verdi", "lory1992@devlhope.co"),
            new Student("4", "Giovanna", "Giallo", "iovanna@develhope.co")
    );
    public Student getStudentById(String id) {
        Optional<Student> userFromDB = students.stream().filter(student -> student.getId().equals(id)).findAny();
        if (userFromDB.isPresent()) return userFromDB.get();
        return null;
    }
}
