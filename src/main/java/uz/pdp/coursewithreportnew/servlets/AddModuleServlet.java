package uz.pdp.coursewithreportnew.servlets;

import jakarta.persistence.EntityManager;
import uz.pdp.coursewithreportnew.classes.Course;
import uz.pdp.coursewithreportnew.classes.Modules;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static uz.pdp.coursewithreportnew.MyListener.EMF;

@WebServlet("/add/modules")
public class AddModuleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try(
                EntityManager entityManager = EMF.createEntityManager()
                ) {
            entityManager.getTransaction().begin();
            String name = req.getParameter("name");
            String courseId = req.getParameter("courseId");

            Course course = entityManager.find(Course.class, Integer.parseInt(courseId));
            Modules modules = new Modules();
            modules.setName(name);
            modules.setCourse(course);
            entityManager.persist(modules);
            entityManager.getTransaction().commit();
            resp.sendRedirect("/module.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
