package uz.pdp.coursewithreportnew.servlets;

import jakarta.persistence.EntityManager;
import uz.pdp.coursewithreportnew.classes.Payment;
import uz.pdp.coursewithreportnew.classes.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static uz.pdp.coursewithreportnew.MyListener.EMF;

@WebServlet("/add/payment")
public class AddPaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(
                EntityManager entityManager = EMF.createEntityManager()
                ) {
            entityManager.getTransaction().begin();
            int amount = Integer.parseInt(req.getParameter("amount"));
            String id = req.getParameter("studentId");
            Student student = entityManager.find(Student.class, Integer.parseInt(id));
            Payment payment = new Payment();
            payment.setAmount(amount);
            payment.setStudent(student);
            entityManager.persist(payment);
            entityManager.getTransaction().commit();
            resp.sendRedirect("/payment.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
