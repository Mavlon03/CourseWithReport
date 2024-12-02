package uz.pdp.coursewithreportnew.repositories;

import jakarta.persistence.EntityManager;
import uz.pdp.coursewithreportnew.classes.Module;

import java.util.List;

import static uz.pdp.coursewithreportnew.MyListener.EMF;

public class ModuleRepo {
    public static List<Module> getModuleByCourseId(int courseId){
        try(
                EntityManager entityManager = EMF.createEntityManager()
                ) {
       return entityManager.createQuery(
               "select m from Module m where m.course.id = :courseId", Module.class
       ).setParameter("courseId", courseId).getResultList();
        } finally {

        }
    }
}
