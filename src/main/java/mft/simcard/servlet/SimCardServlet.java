package mft.simcard.servlet;

import mft.simcard.model.entity.Person;
import mft.simcard.model.entity.SimCard;
import mft.simcard.model.service.PersonService;
import mft.simcard.model.service.SimCardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mft.simcard.servlet.exception.SimCardNotFoundException;

import java.io.IOException;

public class SimCardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            SimCardService simCardService = new SimCardService();
            req.getSession().setAttribute("simCardList", simCardService.findAll());
            System.out.println("Info : FindAll SimCards");
        } catch (SimCardNotFoundException e) {
            System.out.println("Error : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PersonService personService = new PersonService();
            personService.findByNameAndFamily(req.getParameter("name"), req.getParameter("family"));

            SimCardService simCardService = new SimCardService();
            SimCard simCard =
                    SimCard
                            .builder()
                            .name(req.getParameter("name"))
                            .family(req.getParameter("family"))
                            .build();
            simCardService.save(simCard);
            System.out.println("Info : Save SimCard");
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
