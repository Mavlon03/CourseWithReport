package uz.pdp.coursewithreportnew.repositories;

import jakarta.persistence.EntityManager;
import uz.pdp.coursewithreportnew.classes.Groups;

import java.util.List;

import static uz.pdp.coursewithreportnew.MyListener.EMF;

public class GroupsRepo {
    public static List<Groups> getGroupsByModuleId(int moduleId) {
        EntityManager entityManager = null;
        try {
            entityManager = EMF.createEntityManager();
            return entityManager.createQuery(
                            "select g from Groups g where g.groups.id = :moduleId", Groups.class)
                    .setParameter("moduleId", moduleId)
                    .getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
