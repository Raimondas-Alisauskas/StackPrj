package controller;

import model.DTO.UserDTO;
import service.IService.ILoginService;
import service.implService.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ILoginService loginService = new LoginService();

        String email = req.getParameter("email");
        String password = req.getParameter("password");


        UserDTO userDTO = loginService.checkUser(email,password);

        req.setAttribute("user", userDTO);

        HttpSession sessionRegistration = req.getSession();
        sessionRegistration.setAttribute("name", userDTO.name);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/welcome");
        dispatcher.forward(req, resp);

    }

}
