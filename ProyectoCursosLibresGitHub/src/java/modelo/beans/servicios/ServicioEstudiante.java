package modelo.beans.servicios;

import java.util.Date;
import cursolibres.db.Database;
import modelo.beans.ConjuntoEstudiantes;
import modelo.beans.Estudiante;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.beans.ConjuntoUsuarios;
import modelo.beans.Usuario;

@WebServlet(name = "ServicioEstudiante", urlPatterns = {"/ServicioEstudiante"})
public class ServicioEstudiante extends HttpServlet {

    Date date = new Date();
    Timestamp ts = new Timestamp(date.getTime());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("Servlet ServicioEstudiante..");

        //Metodo por medio del cual se realizar el registro de los estudiantes. Este inicia una session para luego crear primeramente un usuario que sera la base
        //para la creacion del estudiante.
        try {
            
            HttpSession s = request.getSession(true);
            Usuario u = new Usuario(
                    request.getParameter("id"),
                    3,
                    String.valueOf(generacionClave()),
                    ts,
                    true
            );

            ConjuntoUsuarios usuarios = (ConjuntoUsuarios) getServletContext().getAttribute("usuarios");
            usuarios.add(u);
            
            //Una vez se crea el usuario, comienza la creacion y asignacion de valores correspondientes al estudiante que se esta registrando
            Estudiante e = new Estudiante(
                    Integer.parseInt(request.getParameter("id")),
                    request.getParameter("id"),
                    request.getParameter("apellido1"),
                    request.getParameter("apellido2"),
                    request.getParameter("nombre"),
                    request.getParameter("telefono"),
                    request.getParameter("email"));

            //se agrega el estudiante registrado al conjunto de estudiantes
            ConjuntoEstudiantes estudiantes
                    = (ConjuntoEstudiantes) getServletContext().getAttribute("estudiantes");
            estudiantes.add(e);
            System.out.println(estudiantes);

            //redireccion a la pagina en que se mostrara la clave generada de manera aleatoria
            s.setAttribute("generacionClave", u);
            response.sendRedirect("visualizarClave.jsp");

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            response.sendRedirect("error.jsp");
        }
    }

    //metodo que se encarga de conectarse a la base de datos para retornar el estudiante al cual le corresponde el id utilizado en la busqueda
    public Estudiante obtenerEstudiante(String id_usuario) {
        Estudiante est = new Estudiante();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(EstudianteCRUD.RETRIEVE_CMD);) {
            stm.clearParameters();
            stm.setString(1, id_usuario);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    est.setId_estudiante(rs.getInt("id_estudiante"));
                    est.setUsuario_id(rs.getString("usuario_id"));
                    est.setApellido1(rs.getString("apellido1"));
                    est.setApellido2(rs.getString("apellido2"));
                    est.setNombre(rs.getString("nombre"));
                    est.setTelefono(rs.getString("telefono"));
                    est.setE_mail(rs.getString("e_mail"));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return est;
    }

    //Metodo para generar la clave dinamica
    public static int generacionClave() {
        return (int) (10000 * Math.random());
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
        return "ServicioEstudiante";
    }
}
