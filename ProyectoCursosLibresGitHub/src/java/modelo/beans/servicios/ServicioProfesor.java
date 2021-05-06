package modelo.beans.servicios;

import cursolibres.db.Database;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.beans.ConjuntoEspecialidades;
import modelo.beans.ConjuntoProfesores;
import modelo.beans.ConjuntoUsuarios;
import modelo.beans.Especialidad;
import modelo.beans.Profesor;
import modelo.beans.Usuario;
import static modelo.beans.servicios.ServicioEstudiante.generacionClave;

@WebServlet(name = "ServicioProfesor", urlPatterns = {"/ServicioProfesor"})
public class ServicioProfesor extends HttpServlet {

    Date date = new Date();
    Timestamp ts = new Timestamp(date.getTime());
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("Servlet ServicioProfesor..");
        
        try {
            //Antes de ingresar el profesor se ingresa a la base de datos el usuario
            //que le corresponde
            HttpSession s = request.getSession(true);
            Usuario u = new Usuario(
                    request.getParameter("id"),
                    2,
                    String.valueOf(generacionClave()),
                    ts,
                    true
            );

            ConjuntoUsuarios usuarios = (ConjuntoUsuarios) getServletContext().getAttribute("usuarios");
            usuarios.add(u);

            //Creado y ingresado a la base de datos, se crea el profesor asignado
            //al profesor para ingresarlo tambien a la base de datos
            
            Profesor e = new Profesor(
                    Integer.parseInt(request.getParameter("id")),
                    request.getParameter("id"),
                    request.getParameter("apellido1"),
                    request.getParameter("apellido2"),
                    request.getParameter("nombre"),
                    request.getParameter("telefono"),
                    request.getParameter("email"));

            ConjuntoProfesores profesores
                    = (ConjuntoProfesores) getServletContext().getAttribute("profesores");
            profesores.add(e);
            
            //A partir de la area tematica selecciona se ingresan las especialidades
            //del profesor a la base de datos
                        
            int idArea = Integer.parseInt(request.getParameter("especialidad"));
            int idProfesor = Integer.parseInt(request.getParameter("id"));
            
            Especialidad ep = new Especialidad(idProfesor,idArea);
            
            ConjuntoEspecialidades especialidades
                    = (ConjuntoEspecialidades) getServletContext().getAttribute("especialidades");
            especialidades.add(ep);

            //Finalmente se asigna una contrasena al usuario
            s.setAttribute("generacionClave", u);
            response.sendRedirect("visualizarClave.jsp");

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            response.sendRedirect("error.jsp");
        }
    }

    public Profesor obtenerProfesor(String id_usuario) {
        Profesor profe = new Profesor();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(ProfesorCRUD.RETRIEVE_CMD);) {
            stm.clearParameters();
            stm.setString(1, id_usuario);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    profe.setId_profesor(rs.getInt("id_profesor"));
                    profe.setUsuario_id(rs.getString("usuario_id"));
                    profe.setApellido1(rs.getString("apellido1"));
                    profe.setApellido2(rs.getString("apellido2"));
                    profe.setNombre(rs.getString("nombre"));
                    profe.setTelefono(rs.getString("telefono"));
                    profe.setE_mail(rs.getString("e_mail"));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return profe;
    }

    public Connection obtenerConexion() throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException,
            SQLException {
        Database db = Database.getInstance();
        Connection cnx = db.getConnection();
        return cnx;
    }

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
        return "ServicioProfesor";
    }
}