package uz.pdp.coursewithreportnew.repositories;

import jakarta.persistence.EntityManager;
import uz.pdp.coursewithreportnew.classes.Modules;

import java.util.List;

import static uz.pdp.coursewithreportnew.MyListener.EMF;

public class ModuleRepo {
    public static List<Modules> getModuleByCourseId(int courseId){
        try(
                EntityManager entityManager = EMF.createEntityManager()
                ) {
       return entityManager.createQuery(
               "select m from Modules m where m.course.id = :courseId", Modules.class
       ).setParameter("courseId", courseId).getResultList();
        } finally {

        }
    }
}
