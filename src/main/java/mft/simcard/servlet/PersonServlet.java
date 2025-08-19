package mft.simcard.servlet;

import mft.simcard.model.entity.Person;
import mft.simcard.model.service.PersonService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PersonService personService = new PersonService();
            req.getSession().setAttribute("personList", personService.findAll());
            System.out.println("Info : FindAll Persons");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PersonService personService = new PersonService();
//        name,family
            Person person =
                    Person
                            .builder()
                            .name(req.getParameter("name"))
                            .family(req.getParameter("family"))
                            .build();
            personService.save(person);
            System.out.println("Info : Save Person");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        id,name,family
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        id
    }
}
