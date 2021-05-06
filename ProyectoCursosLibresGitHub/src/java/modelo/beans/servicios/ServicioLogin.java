package modelo.beans.servicios;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.beans.Administrador;
import modelo.beans.Estudiante;
import modelo.beans.Profesor;
import modelo.beans.Usuario;

@WebServlet(name = "ServicioLogin", urlPatterns = {"/Login", "/Logout"})
public class ServicioLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        switch (request.getServletPath()) {
            case "/Login":
                this.doLogin(request, response);
                break;
            case "/Logout":
                this.doLogout(request, response);
                break;
        }
    }
    
    //metodo por medio del cual se realizara el login de los usuarios
    protected void doLogin(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession s = request.getSession(true);
            
            //Primero se crea una session que sera utilizada para el manejo de los datos.
            //se crean las variables que almacenan los datos provenientes del formulario
            String id_usuario = request.getParameter("id_usuario");
            String clave = request.getParameter("clave");

            //se crea un usuario nuevo al que se le asigan dichos valos y que sera utilizado para realizar la comparacion de los datos con los valores existentes
            //en la base de datos
            Usuario user = new Usuario();
            user.setId_usuario(id_usuario);
            //primero se confirma por medio del metodo obtenerUsuario que el usuario que se ingreso exista en la base de datos, osea que este registrado
            user = servicioUs.obtenerUsuario(id_usuario);

            //una vez se confirma que el usuario existe, se compara la clave ingresada con la clave actual para dicho usuario 
            //y confirmar que los credenciales son correctos
            if (user.getClave().equals(clave)) {

                //Una vez se confirma que los credenciales con correctos se compara el tipo de rol para realizar el inicio de sesion y mostrar solamente
                //las opciones correspondientes a cada tipo de usuario
                if (user.getRol_id() == 1) {
                    Administrador admin = new Administrador();
                    admin = servicioAdmin.obtenerAdministrador(id_usuario);
                    s.setAttribute("administrador", admin);
                    s.setAttribute("user", user);
                    request.getRequestDispatcher("inicioAdministrador.jsp").
                            forward(request, response);
                } else if (user.getRol_id() == 2) {
                    Profesor profe = new Profesor();
                    profe = servicioProfe.obtenerProfesor(id_usuario);
                    s.setAttribute("profesor", profe);
                    s.setAttribute("user", user);
                    request.getRequestDispatcher("inicioProfesor.jsp").
                            forward(request, response);
                } else if (user.getRol_id() == 3) {
                    Estudiante est = new Estudiante();
                    est = servicioEst.obtenerEstudiante(id_usuario);
                    s.setAttribute("estudiante", est);
                    s.setAttribute("user", user);
                    request.getRequestDispatcher("inicioEstudiante.jsp").
                            forward(request, response);
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            request.setAttribute("error", "Credenciales incorrectas.");
            request.getRequestDispatcher("errorLogin.jsp").
                    forward(request, response);
        }
    }

    protected void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    private final ServicioUsuario servicioUs = new ServicioUsuario();
    private final ServicioEstudiante servicioEst = new ServicioEstudiante();
    private final ServicioAdministrador servicioAdmin = new ServicioAdministrador();
    private final ServicioProfesor servicioProfe = new ServicioProfesor();

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
