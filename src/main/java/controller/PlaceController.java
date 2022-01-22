package controller;
import service.SectionService;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import beans.Place;
import beans.Section;
import connexion.Connexion;
import dao.IDao;
import service.PlaceService;

@WebServlet(name = "PlaceController", urlPatterns = { "/PlaceController" })
public class PlaceController extends HttpServlet {
	PlaceService ps = new PlaceService();
SectionService ss = new SectionService();
public static int Section;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("delete")) {
				ps.delete(ps.findById(Integer.parseInt(request.getParameter("id"))));
				response.sendRedirect("tablePlace.jsp");
				
			} else if (request.getParameter("op").equals("update")) {
				int id = Integer.parseInt(request.getParameter("id"));
				Place p = ps.findById(id);
				response.sendRedirect("tablePlace.jsp?id=" + p.getId() + "&numeroPla=" + p.getNumeroPla() + "&etat=" + p.getEtat()+"&Section="+ss.findById(Section));
				
			}else if(request.getParameter("id") !=null && !request.getParameter("id").equals("")) {
				int numeroPla = Integer.parseInt(request.getParameter("numeroPla"));
				String etat = request.getParameter("etat");
				int id = Integer.parseInt(request.getParameter("id"));
				Place p = ps.findById(id);
				int SectionId = Integer.parseInt(request.getParameter("Section"));
				p.setNumeroPla(numeroPla);
				p.setEtat(etat);
				p.setSection(ss.findById(SectionId));
				ps.update(p);
				response.sendRedirect("tablePlace.jsp");
			}
			
		} else {
			int numeroPla = Integer.parseInt(request.getParameter("numeroPla"));
			String etat = request.getParameter("etat");
			PlaceService ps = new PlaceService();
			int SectionId = Integer.parseInt(request.getParameter("Section"));
			Section s = ss.findById(SectionId);
			ps.create(new Place(numeroPla, etat,s));
			response.sendRedirect("tablePlace.jsp");
		}
	}
}

