/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Profesor;
import ModeloPersistencia.datosProfesores;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jalc
 */
public class profesoresServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {

        HttpSession session = request.getSession(false);
        datosProfesores dp = new datosProfesores();

        if (session != null) {

            String accion = request.getParameter("Accion");

            //alta
            if (accion.equalsIgnoreCase("formAlta")) {

                String url = "/Vista/add.jsp";
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);

            } else if (accion.equalsIgnoreCase("altaProfesor")) {

                Profesor p = new Profesor();

                p.setDni(request.getParameter("dni"));
                p.setNombre(request.getParameter("nombre"));
                p.setApellidos(request.getParameter("apellidos"));

                String diaAlta = request.getParameter("diaAlta");
                String mesAlta = request.getParameter("mesAlta");
                String anioAlta = request.getParameter("anioAlta");
                SimpleDateFormat formatoFecha = new SimpleDateFormat("d-MM-yyyy");
                Date FechaAlta = formatoFecha.parse(diaAlta + "-" + mesAlta + "-" + anioAlta);
                p.setFechaAlta(FechaAlta);

                p.setDepartamento(request.getParameter("departamento"));

                dp.insertarProfesor(p);

                //modificar
            } else if (accion.equalsIgnoreCase("formModificar")) {

                String url = "/Vista/modify.jsp";
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);

            } else if (accion.equalsIgnoreCase("modicicarProfe")) {

                Profesor p = new Profesor();

                p.setDni(request.getParameter("dni"));
                p.setNombre(request.getParameter("nombre"));
                p.setApellidos(request.getParameter("apellidos"));

                String diaAlta = request.getParameter("diaAlta");
                String mesAlta = request.getParameter("mesAlta");
                String anioAlta = request.getParameter("anioAlta");
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-d");
                Date FechaAlta = formatoFecha.parse(diaAlta + "-" + mesAlta + "-" + anioAlta);
                p.setFechaAlta(FechaAlta);

                p.setDepartamento(request.getParameter("departamento"));

                dp.actualizarProfesor(p);

                //eliminar
            } else if (accion.equalsIgnoreCase("formEliminar")) {
                String url = "/Vista/delete.jsp";
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);

            } else if (accion.equalsIgnoreCase("eliminarProfe")) {

                String dni = request.getParameter("dni");
                dp.eliminarProfesor(dni);

                //profesores mayor o igual que una fecha introducida
            } else if (accion.equalsIgnoreCase("listNuevos")) {
                String url = "/Vista/profesMayor2016.jsp";
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);

            } else if (accion.equalsIgnoreCase("filtrarFecha")) {

                String diaAlta = request.getParameter("diaAlta");
                String mesAlta = request.getParameter("mesAlta");
                String anioAlta = request.getParameter("anioAlta");
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-d");
                Date FechaAlta = formatoFecha.parse(diaAlta + "-" + mesAlta + "-" + anioAlta);

                request.setAttribute("profesores", dp.listarMayor2016(FechaAlta));
                String url = "/Vista/listEmpty.jsp";
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);

                //cancelar
            } else if (accion.equalsIgnoreCase("cancelarAlta")) {

                request.setAttribute("profesores", dp.listaProfesores());
                String url = "/Vista/list.jsp";
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);

            }
           
            if(!accion.equalsIgnoreCase("filtrarFecha")){
            //refresque la lista al insertar un profe nuevo.
            request.setAttribute("profesores", dp.listaProfesores());
            String url = "/Vista/list.jsp";
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher(url);
            rd.forward(request, response);
            }

        } else {

            request.setAttribute("profesores", dp.listaProfesores());
            String url = "/Vista/list.jsp";
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher(url);
            rd.forward(request, response);
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
        try {
            processRequest(request, response);

        } catch (Exception ex) {
            Logger.getLogger(profesoresServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);

        } catch (Exception ex) {
            Logger.getLogger(profesoresServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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
