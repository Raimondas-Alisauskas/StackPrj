package controller;

import model.DTO.UserDTO;
import service.IService.IRegistrationService;
import service.implService.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IRegistrationService registrationService = new RegistrationService();

        String name = req.getParameter("regName");
        String email = req.getParameter("regEmail");
        String password = req.getParameter("regPassword");

        UserDTO userDTO = new UserDTO(name, email);

        req.setAttribute("user", userDTO);

        HttpSession sessionRegistration = req.getSession();
        sessionRegistration.setAttribute("name", name);

        registrationService.insertUser(name, email, password);
        resp.sendRedirect("welcome");

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session != null)
            session.invalidate();
        resp.sendRedirect("welcome");

    }


}
