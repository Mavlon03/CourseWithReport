package uz.pdp.coursewithreportnew.repositories;

import jakarta.persistence.EntityManager;
import uz.pdp.coursewithreportnew.classes.Payment;

import java.util.List;

import static uz.pdp.coursewithreportnew.MyListener.EMF;

public class PaymentRepo {
    public static List<Payment> getPaymentByStudentId(Integer studentId){
        try(
                EntityManager entityManager = EMF.createEntityManager()

                ) {
            return entityManager.createQuery(
                    "select p from Payment p where p.student.id = :studentId", Payment.class)
                    .setParameter("studentId", studentId)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
