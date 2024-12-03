package uz.pdp.coursewithreportnew.servlets;

import jakarta.persistence.EntityManager;
import uz.pdp.coursewithreportnew.classes.Groups;
import uz.pdp.coursewithreportnew.classes.Modules;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static uz.pdp.coursewithreportnew.MyListener.EMF;

@WebServlet("/add/group")
public class AddGroupsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(
                EntityManager entityManager = EMF.createEntityManager()
                ) {
            entityManager.getTransaction().begin();
            String name = req.getParameter("name");
            String id = req.getParameter("moduleId");
            Modules modules = entityManager.find(Modules.class, Integer.parseInt(id));
            Groups groups = new Groups();
            groups.setName(name);
            groups.setModules(modules);
            entityManager.persist(groups);
            entityManager.getTransaction().commit();
            resp.sendRedirect("/groups.jsp");

        }
    }
}
