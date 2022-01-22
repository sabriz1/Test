package controller;

import java.io.IOException;
import java.util.List;

import org.apache.catalina.ssi.SSICommand;

import com.mysql.cj.x.protobuf.MysqlxExpr.Object;

import beans.Place;
import beans.Section;
import beans.Ticket;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PlaceService;
import service.SectionService;
@WebServlet(name = "SectionController", urlPatterns = { "/SectionController" })
public class SectionController extends HttpServlet {
	PlaceService ps = new PlaceService();
	SectionService ss = new SectionService();
	public static int Place;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("delete")) {
				ss.delete(ss.findById(Integer.parseInt(request.getParameter("id"))));
				response.sendRedirect("table.jsp");
				
			} else if (request.getParameter("op").equals("update")) {
				int id = Integer.parseInt(request.getParameter("id"));
				Section s = ss.findById(id);
				
				response.sendRedirect("table.jsp?id=" + s.getId() + "&code=" + s.getCode() + "&type=" + s.getType() +"&prixParHeure=" +s.getPrixParHeure());
				
				}else if(request.getParameter("id")!=null && !request.getParameter("id").equals("")) {
					String code = request.getParameter("code");
					String type = request.getParameter("type");
					int prixParHeure = Integer.parseInt(request.getParameter("prixParHeure"));
					int placeId = Integer.parseInt(request.getParameter("Place"));
				int id = Integer.parseInt(request.getParameter("id"));
				Section s = ss.findById(id);
				s.setCode(code);
				s.setType(type);
				s.setPrixParHeure(prixParHeure);
				ss.update(s);
				response.sendRedirect("tableSection.jsp");
			}
		
		} else {
			
			String code = request.getParameter("code");
			String type = request.getParameter("type");
			int prixParHeure = Integer.parseInt(request.getParameter("prixParHeure"));
			PlaceService ps = new PlaceService();
			SectionService ss = new SectionService();
			ss.create(new Section(code, type, prixParHeure));
			response.sendRedirect("table.jsp");
		}
	}

}

