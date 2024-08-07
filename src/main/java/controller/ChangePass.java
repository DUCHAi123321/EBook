/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAOUser;

/**
 *
 * @author acer
 */
@WebServlet(name = "ChangePass", urlPatterns = {"/changepass"})
public class ChangePass extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        final String CHANGE_PASS_WORD = "changepassword.jsp";
        final String FAILED_MSG = "failedMsg";

        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            User u = (User) session.getAttribute("userobj");
            String pass = request.getParameter("password");
            String newpass = request.getParameter("newpassword");
            String repass = request.getParameter("repassword");
            DAOUser dao = new DAOUser();
            int check = dao.checkUserPassword(u.getId(), pass);

            if (check > 0) {
                if (newpass.equals(repass)) {
                    int n = dao.setPassword(u.getId(), newpass);
                    if (n > 0) {
                        session.setAttribute("successMsg", "Update Password Successfully");
                        response.sendRedirect(CHANGE_PASS_WORD);
                    } else {
                        session.setAttribute(FAILED_MSG, "Something wrong on server....");
                        response.sendRedirect(CHANGE_PASS_WORD);
                    }
                } else {
                    session.setAttribute(FAILED_MSG, "Please check repassword");
                    response.sendRedirect(CHANGE_PASS_WORD);
                }
            } else {
                session.setAttribute(FAILED_MSG, "Please check password right");
                response.sendRedirect(CHANGE_PASS_WORD);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
