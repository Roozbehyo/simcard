package mft.simcard.servlet;

import mft.simcard.model.entity.Person;
import mft.simcard.model.entity.SimCard;
import mft.simcard.model.enums.SimCardOperators;
import mft.simcard.model.enums.SimStatus;
import mft.simcard.model.service.PersonService;
import mft.simcard.model.service.SimCardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mft.simcard.servlet.exception.SimCardNotFoundException;

import java.io.IOException;
import java.time.LocalDate;

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
           Person person = personService.findByNameAndFamily(req.getParameter("name"), req.getParameter("family"));
            SimCardService simCardService = new SimCardService();
            SimCard simCard =
                    SimCard
                            .builder()
                            .person(person)
                            .operator(SimCardOperators.valueOf(req.getParameter("operator")))
                            .number(req.getParameter("number"))
                            .status(SimStatus.ENABLE)
                            .registrationDate(LocalDate.now())
                            .build();
            simCardService.save(simCard);
            System.out.println("Info : Save SimCard");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PersonService personService = new PersonService();
            Person person = personService.findById(Integer.parseInt(req.getParameter("person_id")));
            SimCardService simCardService = new SimCardService();
            SimCard simCard =
                    SimCard
                            .builder()
                            .id(Integer.parseInt(req.getParameter("sim_card_id")))
                            .person(person)
                            .status(SimStatus.valueOf(req.getParameter("status")))
                            .build();
            simCardService.edit(simCard);
            System.out.println("Info : Update SimCard");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            SimCardService simCardService = new SimCardService();
            SimCard simCard =
                    SimCard
                            .builder()
                            .id(Integer.parseInt(req.getParameter("id")))
                            .status(SimStatus.DISABLE)
                            .build();
            simCardService.edit(simCard);
            System.out.println("Info : Delete SimCard");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
