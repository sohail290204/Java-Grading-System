/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
@WebServlet(urlPatterns = {"/marks"})
public class marks extends HttpServlet {
int foa,la,java,se,cn,dotnet,android;
int average,total;
int percentage;
String usernamee,Grade,PassorFail;


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
            out.println("<title>Servlet marks</title>");            
            out.println("</head>");
            out.println("<body>");
            

            //response.sendRedirect("index1.html");
            
            foa=Integer.parseInt(request.getParameter("foa"));
            java=Integer.parseInt(request.getParameter("java"));
            la=Integer.parseInt(request.getParameter("la"));
            se=Integer.parseInt(request.getParameter("se"));
            cn=Integer.parseInt(request.getParameter("cn"));
            dotnet=Integer.parseInt(request.getParameter("dotnet"));
            android=Integer.parseInt(request.getParameter("android"));
            
            
            HttpSession session = request.getSession();
            usernamee=session.getAttribute("username").toString();
            System.out.println("username "+usernamee);
            
            if(foa<=100 && java<=100 && la<=100 && se<=100 && cn<=100 && dotnet<=100 && android<=100){

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Welcome marks");
                
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/java_project?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","root");
                
                System.out.println("Connection Created (marks)");
                
                String sql= "insert into marks (foa, java, la, cn, se, dotnet, android, Username, Total, Average, percentage,Grade, PassorFail) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                total=foa+java+la+cn+se+dotnet+android;
                average=total/7;
                percentage=(total/7)  ;
                
                if(percentage>=95 && percentage<=100){
                    Grade="O";
                }else if(percentage>=90 && percentage<=94){
                    Grade = "A+";
                }else if(percentage>=80 && percentage<=89){
                    Grade = "A";
                }else if(percentage>=70 && percentage<=79){
                    Grade = "B";
                }else if(percentage>=60 && percentage<=69){
                    Grade = "C";
                }else if(percentage>=50 && percentage<=59){
                    Grade = "D";
                }else if(percentage>=35 && percentage<=49){
                    Grade = "E";
                }else if(percentage>=0 && percentage<=34){
                    Grade = "F";
                }else{
                    Grade = "Error";
                    response.sendRedirect("errormarks.html");   
                }
                
                
                if(percentage<35){
                    PassorFail="Fail";
                }else{
                    PassorFail="Pass";
                }
                PreparedStatement preparedStmt = conn.prepareStatement(sql);
                preparedStmt.setInt (1, foa);
                preparedStmt.setInt  (2, java);
                preparedStmt.setInt  (3, la);
                preparedStmt.setInt (4, cn);
                preparedStmt.setInt  (5, se);
                preparedStmt.setInt (6, dotnet);
                preparedStmt.setInt  (7, android);
                preparedStmt.setString (8, usernamee);
                preparedStmt.setInt (9, total);
                preparedStmt.setInt  (10, average);
                preparedStmt.setInt (11, percentage);
                preparedStmt.setString (12, Grade);
                preparedStmt.setString (13, PassorFail);
                
                preparedStmt.execute();
                System.out.println("foa "+foa+" java "+java+" la "+la+" cn "+cn+" se "+se+" dotnet "+dotnet+" android "+android +" PassorFail"+PassorFail);

                //response.sendRedirect("index5.html");
                conn.close(); 
                
            }catch (Exception e){
                System.out.println("Expection:"+e);
                }  
        response.sendRedirect("certificate");
                
        }else{
                response.sendRedirect("errormarks.html");
            }
            
            
            
            out.println("<h1>Servlet marks at " + request.getContextPath() + "</h1>");
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
