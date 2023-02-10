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
import javax.servlet.RequestDispatcher;
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
@WebServlet(urlPatterns = {"/admin"})
public class admin extends HttpServlet {
 String name,username,uusername,PhoneNo,password,email,Rollno,rss1;
 
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
            out.println("<title>Servlet admin</title>");            
            out.println("</head>");
            out.println("<body>");
            
            name=request.getParameter("Name");
            username=request.getParameter("UserName");
            Rollno=request.getParameter("Rollno");
            password=request.getParameter("Password");
            email=request.getParameter("Email");
            PhoneNo=request.getParameter("PhoneNo");
            
            
            
            
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Welcome admin");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/java_project?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","root");
                
                System.out.println("Connection Created (student_reg)");
                //Statement st = con.createStatement();
                
                String sql1= "(Select username from student_reg where username=?)";
                PreparedStatement st1 = conn.prepareStatement(sql1);
                st1.setString(1,username);
                ResultSet rss = st1.executeQuery();

            if(rss.next()){   
                response.sendRedirect("usernameerror.html");    
                rss1 = rss.getString("username");
                }else{
                
                
                String sql= "insert into  student_reg(name, username, Rollno, password, email, PhoneNo) values(?,?,?,?,?,?)";
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setString (1, name);
                preparedStmt.setString (2, username);
                preparedStmt.setString   (3, Rollno);
                preparedStmt.setString(4, password);
                preparedStmt.setString    (5, email);
                preparedStmt.setString    (6, PhoneNo);
                
                preparedStmt.execute();
                
                

        
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                //session.setAttribute("uusername",username);
               
                conn.close();
                response.sendRedirect("index1.html");
                
                }
                
                }
            catch (Exception e){
                System.out.println("Expection:"+e);
                }
            
            out.println("<h1>Servlet admin at " + request.getContextPath() + "</h1>");
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
        
        //RequestDispatcher rd = request.getRequestDispatcher("marks");
        //rd.forward(request, response);

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
        /*
        PrintWriter out = response.getWriter();
        username=request.getParameter("UserName");
        //System.out.println(username);
        
        HttpSession session = request.getSession(true);
        session.putValue("username",username);
        response.sendRedirect(request.getContextPath()+"/marks");*/
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
