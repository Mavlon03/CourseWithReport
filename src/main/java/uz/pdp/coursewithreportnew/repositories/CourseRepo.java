package uz.pdp.coursewithreportnew.repositories;

import jakarta.persistence.EntityManager;
import uz.pdp.coursewithreportnew.classes.Course;

import java.util.List;

import static uz.pdp.coursewithreportnew.MyListener.EMF;

public class CourseRepo {
    public static List<Course> getCourseList(){
        try(
                EntityManager entityManager = EMF.createEntityManager()

                ) {
            return entityManager.createQuery("select c from Course c ", Course.class).getResultList() ;

        }
    }
}
