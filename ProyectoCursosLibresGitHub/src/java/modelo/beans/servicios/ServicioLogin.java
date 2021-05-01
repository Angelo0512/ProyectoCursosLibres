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

    protected void doLogin(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession s = request.getSession(true);

            String id_usuario = request.getParameter("id_usuario");
            String clave = request.getParameter("clave");

            Usuario user = new Usuario();
            user.setId_usuario(id_usuario);
            user = servicioUs.obtenerUsuario(id_usuario);

            if (user.getClave().equals(clave)) {

                if (user.getRol_id() == 1) {
                    Administrador admin = new Administrador();
                    admin = servicioAdmin.obtenerAdministrador(id_usuario);
                    s.setAttribute("administrador", admin);
                    request.getRequestDispatcher("inicioAdministrador.jsp").
                            forward(request, response);
                } else if (user.getRol_id() == 2) {
                    Profesor profe = new Profesor();
                    profe = servicioProfe.obtenerProfesor(id_usuario);
                    s.setAttribute("profesor", profe);
                    request.getRequestDispatcher("inicioProfesor.jsp").
                            forward(request, response);
                } else if (user.getRol_id() == 3) {
                    Estudiante est = new Estudiante();
                    est = servicioEst.obtenerEstudiante(id_usuario);
                    s.setAttribute("estudiante", est);
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
