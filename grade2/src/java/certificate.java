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
@WebServlet(urlPatterns = {"/certificate"})
public class certificate extends HttpServlet {
String usernamee,uusername,rs1,rs2,rss1,rss2,rss3,rss4,rss5,t,a,g;
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
            out.println("<title>Servlet certificate</title>");            
            out.println("</head>");
            out.println("<body>");
            
            HttpSession session = request.getSession();
            usernamee=session.getAttribute("username").toString();
            System.out.println("username "+usernamee);
            
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Welcome certificate");
                
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/java_project?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","root");
            System.out.println("Connection Created (certificate)");
            String sql = ("SELECT name, Rollno FROM student_reg WHERE username=? ");
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,usernamee);
            ResultSet rs = st.executeQuery();

            while(rs.next()){   
                    rs1 = rs.getString("name");
                    rs2 = rs.getString("Rollno");
                }
            System.out.println("name:"+rs1);
                System.out.println("Roll no:"+rs2);
                
            String sql1 = ("SELECT Total, Average, Grade, percentage, PassorFail FROM marks WHERE username=? ");
            PreparedStatement st1 = conn.prepareStatement(sql1);
            st1.setString(1,usernamee);
            ResultSet rss = st1.executeQuery();

            while(rss.next()){   
                    rss1 = rss.getString("Total");
                    rss2 = rss.getString("Average");
                    rss3 = rss.getString("Grade");
                    rss5 = rss.getString("percentage");
                    rss4 = rss.getString("PassorFail");
                    
                   // t=Integer.parseInt(rss1);
                   // a=Integer.parseInt(rss2);
                   // g=Integer.parseInt(rss3);    
            }
            //int t=Integer.parseInt(rss1);
            //int a=Integer.parseInt(rss2);
            //int g=Integer.parseInt(rss3);
            
            System.out.println("total:"+rss1);
            System.out.println("average:"+rss2);    
            System.out.println("grade:"+rss3);
            System.out.println("passorfail:"+rss4);
            System.out.println("percent:"+rss5);
                
            }catch (Exception e){
                System.out.println("Expection:"+e);
            }
            String P ="Pass";
            
            if(rss4.equals(P) ){
            out.println(" <html>\n" +
"    <head>\n" +
"        <title>TODO supply a title</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <style>\n" +
"           body{\n" +
"               background-image: url(\"certificate12.jpg\");\n" +
"               background-repeat: no-repeat; \n" +
"               background-size:  cover;\n" +
"            }h2{\n" +
"                font-size:25px;\n" +
"            }#percent{\n" +
"                position: absolute;\n" +
"                top:311px;\n" +
"                left:540px;\n" +
"                font-size: 14px;\n" +
"                font-family: 'Trebuchet MS', sans-serif;\n" +
"            }#name{\n" +
"                position: absolute;\n" +
"                top:195px;\n" +

"                font-size:30px;\n" +
"                left:330px;\n" +
"                font-family:Lucida Handwriting;\n" +
"            }#total{\n" +
"                position: absolute;\n" +
"                top:248px;\n" +
"                left:459px;\n" +
"                font-size: 14px;\n" +
"                font-family: 'Trebuchet MS', sans-serif;\n" +
"            }#avg{\n" +
"                position: absolute;\n" +
"                top:290px;\n" +
"                font-size: 14px;\n" +
"                font-family: 'Trebuchet MS', sans-serif;\n" +
"                left:480px;\n" +
"            }#grade{\n" +
"                font-size: 14px;\n" +
"                font-family: 'Trebuchet MS', sans-serif;\n" +
"                position: absolute;\n" +
"                top:312px;\n" +
"                left:317px;\n" +
"            }\n" +
"            form{\n" +
"                text-align:center;\n" +
"                border: 1px solid black;\n" +
"                position: absolute;\n" +
"                margin-left:250px;\n" +
"                margin-top:15px;\n" +
"                width:550px;\n" +
"                padding-top: 10px;\n" +
"                padding-bottom: 20px;\n" +
"                padding-right: 20px;\n" +
"                padding-left: 20px;\n" +
"                border-radius: 30px;\n" +
"            }\n" +
"           .inp{\n" +
"                border-radius: 10px;\n" +
"                padding: 5px;\n" +
"                text-align: center;\n" +
"                width:200px;\n" +
"            }\n" +
"            .input{\n" +
"                border-radius: 10px;\n" +
"                padding: 5px;\n" +
"                text-align: center;\n" +
"                width:50px;\n" +
"            }\n" +
"            .tol{\n" +
"                border-radius: 10px;\n" +
"                padding: 5px;\n" +
"                text-align: center;\n" +
"                width:80px;\n" +
"            }\n" +
"            .P{\n" +
"                width:100px;\n" +
"                border-radius: 10px;\n" +
"                padding: 8px;\n" +
"                text-align: center;\n" +
"            }\n" +
"            button{\n" +
"                border-radius: 10px;\n" +
"                padding-top: 5px;\n" +
"                padding-bottom: 5px;\n" +
"                width:100px;\n" +
"                text-align: center;\n" +
"            }\n" +
"            span{\n" +
"                color:red;\n" +
"            }\n" +
"            label{\n" +
"                padding-bottom:10px;\n" +
"            }\n" +
"        </style>\n" +
"       \n" +
"    </head>\n" +
"    <body>\n" +
"     \n" +
"        \n" +
"        \n" +
"            \n" +
"            <label id='name'>"+rs1+"  </label>\n" +
"            \n" +
"            \n" +
"            \n" +

"           \n" +
"            \n" +
"            \n" +
"             <label id='avg'> "+rss2+" </label>\n" +
"            \n" +
"           \n" +
"            <label id='total'>"+rss1+"</label>\n" +
"           \n" +
"            \n" +
"           <label id='grade'>"+rss3+"</label>\n" +
"         \n" +
"         \n" +
"           <label id='percent'>"+rss5+"</label>\n" +
"         \n" +
"         \n" +
"    </body>\n" +
"</html>");
            
            }else{
               out.println("<html>\n" +
"    <head>\n" +
"        <title>TODO supply a title</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <style>\n" +
"           body{\n" +
"               background-image: url(\"certifail.jpg\");\n" +
"               background-repeat: no-repeat; \n" +
"               background-size:  cover;\n" +
"            }\n" +
"            h2{\n" +
"                font-size:25px;\n" +
"            }#percent{\n" +
"                position: absolute;\n" +
"                top:228px;\n" +
"                left:520px;\n" +
"                font-family: 'Trebuchet MS', sans-serif;\n" +
"            }\n" +
"            #name{\n" +
"                position: absolute;\n" +
"                top:175px;\n" +
"                top:175px;\n" +
"                font-size:30px;\n" +
"                left:335px;\n" +
"                font-family:Lucida Handwriting;\n" +
"            }#total{\n" +
"                font-family: 'Trebuchet MS', sans-serif;\n" +
"                position: absolute;\n" +
"                top:228px;\n" +
"                left:343px;\n" +
"            }#avg{\n" +
"                position: absolute;\n" +
"                top:269px;\n" +
"                font-family: 'Trebuchet MS', sans-serif;\n" +
"                left:415px;\n" +
"            }#grade{\n" +
"                font-family: 'Trebuchet MS', sans-serif;\n" +
"                position:absolute;\n" +
"                top:291px;\n" +
"                left:322px;\n" +
"            }\n" +
"            form{\n" +
"                text-align:center;\n" +
"                border: 1px solid black;\n" +
"                position: absolute;\n" +
"                margin-left:250px;\n" +
"                margin-top:15px;\n" +
"                width:550px;\n" +
"                padding-top: 10px;\n" +
"                padding-bottom: 20px;\n" +
"                padding-right: 20px;\n" +
"                padding-left: 20px;\n" +
"                border-radius: 30px;\n" +
"            }\n" +
"           .inp{\n" +
"                border-radius: 10px;\n" +
"                padding: 5px;\n" +
"                text-align: center;\n" +
"                width:200px;\n" +
"            }\n" +
"            .input{\n" +
"                border-radius: 10px;\n" +
"                padding: 5px;\n" +
"                text-align: center;\n" +
"                width:50px;\n" +
"            }\n" +
"            .tol{\n" +
"                border-radius: 10px;\n" +
"                padding: 5px;\n" +
"                text-align: center;\n" +
"                width:80px;\n" +
"            }\n" +
"            .P{\n" +
"                width:100px;\n" +
"                border-radius: 10px;\n" +
"                padding: 8px;\n" +
"                text-align: center;\n" +
"            }\n" +
"            button{\n" +
"                border-radius: 10px;\n" +
"                padding-top: 5px;\n" +
"                padding-bottom: 5px;\n" +
"                width:100px;\n" +
"                text-align: center;\n" +
"            }\n" +
"            span{\n" +
"                color:red;\n" +
"            }\n" +
"            label{\n" +
"                padding-bottom:10px;\n" +
"            }\n" +
"        </style>\n" +
"       \n" +
"    </head>\n" +
"    <body>\n" +
"     \n" +
"        \n" +
"        \n" +
"            \n" +
"            <label id='name'>"+rs1+ "  </label>\n" +
"            \n" +
"            <label id='avg'> "+rss2+" </label>\n" +
"            \n" +
"           \n" +
"            <label id='total'>"+rss1+"  </label>\n" +
"           \n" +
"            \n" +
"           <label id='grade'> "+rss3+" </label>\n" +
"          <label id='percent'>"+rss5+" </label>\n" +
"         \n" +
"    </body>\n" +
"</html>");
            }
            
            
            //out.println("<h1>Servlet certificate at " + request.getContextPath() + "</h1>");
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
