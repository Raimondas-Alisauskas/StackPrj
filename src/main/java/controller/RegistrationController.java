package controller;

import service.IService.IRegistrationService;
import service.implService.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IRegistrationService registrationService = new RegistrationService();

        String name = req.getParameter("regName");
        String email = req.getParameter("regEmail");
        String password = req.getParameter("regPassword");


    }

}
