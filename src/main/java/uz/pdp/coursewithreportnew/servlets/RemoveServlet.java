package uz.pdp.coursewithreportnew.servlets;

import jakarta.persistence.EntityManager;
import uz.pdp.coursewithreportnew.classes.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static uz.pdp.coursewithreportnew.MyListener.EMF;

@WebServlet("/remove/course")
public class RemoveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(
                EntityManager entityManager = EMF.createEntityManager()
                ) {
            int id = Integer.parseInt(req.getParameter("id"));
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class , id);
            entityManager.remove(course);
            entityManager.getTransaction().commit();
            resp.sendRedirect("/course.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
