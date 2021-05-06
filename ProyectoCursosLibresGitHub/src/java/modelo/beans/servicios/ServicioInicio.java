package modelo.beans.servicios;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.Administrador;
import modelo.beans.ConjuntoAdministradores;
import modelo.beans.ConjuntoEstados;
import modelo.beans.ConjuntoRol;
import modelo.beans.ConjuntoUsuarios;
import modelo.beans.Estado;
import modelo.beans.Rol;
import modelo.beans.Usuario;

@WebServlet(name = "ServicioInicio", urlPatterns = {"/ServicioInicio"})
public class ServicioInicio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //creando y annadiendo estados de matricula
        Estado estado1 = new Estado(1, "Activo");
        Estado estado0 = new Estado (0, "Inactivo");
        ConjuntoEstados estados = new ConjuntoEstados();
        try {
            estados.add(estado1);
            estados.add(estado0);
        } catch (SQLException ex) {
            //Logger.getLogger(ServicioInicio.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("estados");
        }
        
        //creando roles y annadiendo roles
        Rol rolAdmin = new Rol(1,"administrador");
        Rol rolProfesor = new Rol(2,"profesor");
        Rol rolEstudiante = new Rol(3,"estudiante");
        ConjuntoRol roles = new ConjuntoRol();
        
        try {
            roles.add(rolAdmin);
            roles.add(rolProfesor);
            roles.add(rolEstudiante);
        } catch (SQLException ex) {
            //Logger.getLogger(ServicioInicio.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("roles");
        } 
        
        //creando usuario admin
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        Usuario usuario = new Usuario("111111111", 1, "admin", ts, true);
        ConjuntoUsuarios usuarios = new ConjuntoUsuarios();
        try {
            usuarios.add(usuario);
        } catch (SQLException ex) {
            //Logger.getLogger(ServicioInicio.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("usuarios");
        }
        
        Administrador admin = new Administrador(111111111, "111111111", "istra", "tor", "admin", "88888888", "admin@gmail.com");
        ConjuntoAdministradores administradores = new ConjuntoAdministradores();
        try {
            administradores.add(admin);
        } catch (SQLException ex) {
            System.out.println("admins");
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }

    private final ServicioCurso servicio = new ServicioCurso();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
