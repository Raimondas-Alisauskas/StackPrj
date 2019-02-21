package controllers;

//import model.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;

/**
 * Servlet implementation class controllers.LoginServlet
 */
public class PaginationServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        try {


            String tag = request.getParameter("un");
            String recordsNumb = request.getParameter("pw");



//            UserBean user = new UserBean();
//            user.setUserName(request.getParameter("un"));
//            user.setPassword(request.getParameter("pw"));
//
            PaginationBL paginationBL = new PaginationBL();

            ResultSet resultSet = paginationBL.getLimitedResult();

//
//            if (user.isValid())
//            {
//
//                HttpSession session = request.getSession(true);
//                session.setAttribute("currentSessionUser",user);
//                response.sendRedirect("jsp/userLogged.jsp"); //logged-in page
//            }
//
//            else
//                response.sendRedirect("jsp/invalidLogin.jsp"); //error page

        } catch (Throwable theException)
        {
            System.out.println(theException);
        }
    }
}