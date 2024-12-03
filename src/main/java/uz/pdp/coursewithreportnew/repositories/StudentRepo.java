package uz.pdp.coursewithreportnew.repositories;

import jakarta.persistence.EntityManager;
import uz.pdp.coursewithreportnew.classes.Student;

import java.util.List;

import static uz.pdp.coursewithreportnew.MyListener.EMF;

public class StudentRepo {
    public static List<Student> getStudentByGroupId(Integer groupId){
        try(
                EntityManager entityManager = EMF.createEntityManager()

                ) {
            return entityManager.createQuery(
                    "select s from Student s where s.groups.id = :groupId", Student.class)
                    .setParameter("groupId", groupId)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
