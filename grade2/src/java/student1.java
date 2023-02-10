/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sohail
 */
@WebServlet(urlPatterns = {"/student1"})
public class student1 extends HttpServlet {
String studentusername, Password,rs2,rs1,username,uusername;
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet student1</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            studentusername=request.getParameter("username");
            Password=request.getParameter("password");
            
            try{
            
             Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Welcome student");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/java_project?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","root");
                
                System.out.println("Connection Created");
                
                System.out.println(studentusername);
                System.out.println(Password);
                
                String sql =("SELECT username, password FROM student_reg WHERE username=? and password=?");
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1,studentusername);
                st.setString(2,Password);
                ResultSet rs = st.executeQuery();

                HttpSession session = request.getSession();
                session.setAttribute("username",studentusername);
                //session.setAttribute("uusername",studentusername);
                
                while(rs.next()){   
                    rs2 = rs.getString("username");
                    rs1 = rs.getString("password");
                }
                
                if(st.execute()==true){
                    
                   if(Password.equals(rs1)){
                        if(studentusername.equals(rs2)){
                            System.out.println("Yes student exist1");
                            response.sendRedirect("certificate");
                        }else{
                            response.sendRedirect("studenterror.html");
                            System.out.println("Error in username and password");
                        }
                   }else{
                        response.sendRedirect("studenterror.html");
                        System.out.println("Error in username and password");
                   } 
                }
                else{
                     response.sendRedirect("studenterror.html");
                     System.out.println("Error in username and password");
                }
                conn.close();
                }
            catch (Exception e){
                System.out.println("Expection:"+e);
                }
            
            out.println("<h1>Servlet student1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
