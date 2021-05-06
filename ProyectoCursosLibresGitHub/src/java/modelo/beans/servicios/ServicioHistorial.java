/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans.servicios;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.beans.ConjuntoMatricula;
import modelo.beans.Matricula;
import modelo.beans.Usuario;

//Se usa iText7 para la creacion de los pdf

/**
 *
 * @author Angelo
 */
public class ServicioHistorial extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        
        Usuario user2 = (Usuario) request.getSession(true).getAttribute("user");
        ConjuntoMatricula matriculas = new ConjuntoMatricula();
        List<Matricula> lista = matriculas.getListaMatriculaIdEstudiate(Integer.parseInt(user2.getId_usuario()));
        
        //Se empieza a crear el pdf
        PdfWriter writer = new PdfWriter(response.getOutputStream());
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate());
        document.setMargins(20, 20, 20, 20);
        
        //Se crea una tabla en el pdff
        Table table = new Table(new float[]{4,8,8,8,4});
        table.setWidth(800);
        document.add(new Paragraph("HISTORIAL").setTextAlignment(TextAlignment.CENTER));
        
        crearTabla(table, lista); //Con la tabla creada y la lista de matricula se crea la tabla        
        document.add(table);     
        document.close();
        
        
    }
    
    
    void crearTabla(Table table, List<Matricula> lista){
        
        //Headers
        table.addHeaderCell(new Cell().add(new Paragraph("Id estudiante")));
        table.addHeaderCell(new Cell().add(new Paragraph("Id grupo")));
        table.addHeaderCell(new Cell().add(new Paragraph("Id curso")));
        table.addHeaderCell(new Cell().add(new Paragraph("Estado")));
        table.addHeaderCell(new Cell().add(new Paragraph("Nota")));
        
        
        for (Matricula m : lista) {
        table.addCell(new Cell().add(new Paragraph(Integer.toString(m.getEstudiante_id()))));
        table.addCell(new Cell().add(new Paragraph(Integer.toString(m.getGrupo_num()))));
        table.addCell(new Cell().add(new Paragraph(Integer.toString(m.getCurso_id()))));
        table.addCell(new Cell().add(new Paragraph(Integer.toString(m.getEstado_id()))));
        table.addCell(new Cell().add(new Paragraph(Integer.toString(m.getNota()))));
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
