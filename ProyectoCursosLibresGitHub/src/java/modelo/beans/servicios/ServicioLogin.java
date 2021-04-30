package modelo.beans.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            user.setClave(clave);
            user = servicio.obtenerUsuario(id_usuario);

            if (user.getRol_id() == 1) {
                s.setAttribute("administrador", user);
                request.getRequestDispatcher("index.jsp").
                        forward(request, response);
            } else if (user.getRol_id() == 2) {
                s.setAttribute("profesor", user);
                request.getRequestDispatcher("index.jsp").
                        forward(request, response);
            } else if (user.getRol_id() == 3) {
                s.setAttribute("estudiante", user);
                request.getRequestDispatcher("index.jsp").
                        forward(request, response);
            }
        } catch (IOException | ServletException e) {
            request.setAttribute("error", "Credenciales incorrectas..");
            request.getRequestDispatcher("Error.jsp").
                    forward(request, response);
        }
    }

    protected void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    private final ServicioUsuario servicio = new ServicioUsuario();

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
