/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Automoviles;
import modelo.AutomovilesCRUD;

/**
 *
 * @author Bueno
 */
public class ServletAutomovil extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String op = request.getParameter("op");
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAutomovil</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAutomovil at " + request.getContextPath() + "</h1>");
            
        if (op.equals("listar")) {
            List<Automoviles> misProductos = AutomovilesCRUD.getAutomoviles();
            request.setAttribute("misAutos", misProductos);
            request.getRequestDispatcher("listar.jsp").forward(request, response);
        }

        if (op.equals("insert1")) { 
            request.getRequestDispatcher("insert.jsp").forward(request, response);

        }

        if (op.equals("insert2")) { 

            Automoviles miAuto = new Automoviles();
            miAuto.setMarca(request.getParameter("marca"));
            miAuto.setModelo(request.getParameter("modelo"));
            miAuto.setCv(Integer.parseInt(request.getParameter("cv")));
            AutomovilesCRUD.insertaAutomovil(miAuto);
            out.println("<h1>Registro insertado " + "<a href='index.jsp'>Volver</a>" + "</h1>");
        }

        if (op.equals("borrar")) {
            id = Integer.parseInt(request.getParameter("id"));

            if (AutomovilesCRUD.destroyAutomovil(id) > 0) {
                out.println("<h1>Registro borrado " + "<a href='index.jsp'>Volver</a>" + "</h1>");
            }
        }

        if (op.equals("update1")) {
            id = Integer.parseInt(request.getParameter("id"));

            Automoviles miAuto = AutomovilesCRUD.getAutomovil(id);
            request.setAttribute("miAuto", miAuto);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        }

        if (op.equals("update2")) {
            Automoviles miAuto = new Automoviles();
            miAuto.setId(id);
            miAuto.setMarca(request.getParameter("marca"));
            miAuto.setModelo(request.getParameter("modelo"));
            miAuto.setCv(Integer.parseInt(request.getParameter("cv")));
            
            int filas = AutomovilesCRUD.actualizaAutomovil(miAuto);
            
            String mensaje = "Automóvil actualizado";
            
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("miAuto", miAuto);
            request.getRequestDispatcher("update.jsp").forward(request, response);
            
            out.println("<h1>" + filas + " filas actualizadas</h1>");
            
        }
            
            
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
