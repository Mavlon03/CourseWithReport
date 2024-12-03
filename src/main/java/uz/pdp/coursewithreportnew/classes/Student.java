package uz.pdp.coursewithreportnew.classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.PrintWriter;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "student_name")
    private String name;

    @ManyToOne
    private Groups groups;
}
