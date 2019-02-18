package controllers;

import models.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;


public class RequestPostForm extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {


        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("user_name");
        String email = req.getParameter("user_email");
        String password = req.getParameter("user_password");
        String age = req.getParameter("user_age");
        String bio = req.getParameter("user_bio");
        String job = req.getParameter("user_job");

        String[] interest = req.getParameterValues("user_interest");


        List<String> interest1 = Arrays.asList(interest);

        Person person = new Person(name, email, password, age, bio, job, interest1);

        req.setAttribute("myPerson", person);

        RequestDispatcher res = req.getRequestDispatcher("login.jsp");
        res.forward(req, resp);

    }

}