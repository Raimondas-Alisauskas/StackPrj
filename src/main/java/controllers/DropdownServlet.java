package controllers;

//import model.UserBean;

import models.DocTagDAL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.List;

@WebServlet("")
public class DropdownServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        try {

            DropdownBL dropdownBL = new DropdownBL();

            List<DocTagDAL> tagList = dropdownBL.getLimitedResult();
            request.setAttribute("tagList", tagList);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            System.out.println(tagList);

//
//            if (user.isValid())
//            {
//
//                HttpSession session = request.getSession(true);
//                session.setAttribute("currentSessionUser",user);
//                response.sendRedirect("jsp/userLogged.jsp"); //logged-in page
//            }
//


        } catch (Throwable theException)
        {
            System.out.println(theException);
        }
    }
}