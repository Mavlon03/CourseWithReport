package uz.pdp.coursewithreportnew.servlets;

import jakarta.persistence.EntityManager;
import uz.pdp.coursewithreportnew.classes.Groups;
import uz.pdp.coursewithreportnew.classes.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static uz.pdp.coursewithreportnew.MyListener.EMF;

@WebServlet("/add/student")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(
                EntityManager entityManager = EMF.createEntityManager()
                ) {
            entityManager.getTransaction().begin();
            String name = req.getParameter("name");
            int groupId = Integer.parseInt(req.getParameter("groupId"));
            Groups groups = entityManager.find(Groups.class, groupId);
            Student student = new Student();
            student.setName(name);
            student.setGroups(groups);
            entityManager.persist(student);
            entityManager.getTransaction().commit();
            resp.sendRedirect("/student.jsp?id=" + groupId);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
