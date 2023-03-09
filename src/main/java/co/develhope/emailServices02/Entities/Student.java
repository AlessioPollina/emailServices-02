package co.develhope.emailServices02.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.File;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private String id;
    private String name;
    private String surname;
    private String email;
}
