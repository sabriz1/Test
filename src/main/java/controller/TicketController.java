package controller;

import java.io.IOException;

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
import service.TicketService;
@WebServlet(name = "TicketController", urlPatterns = { "/TicketController" })
public class TicketController extends HttpServlet{

	PlaceService ps = new PlaceService();
	SectionService ss = new SectionService();
	TicketService ts = new TicketService();
	public static int Place;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("delete")) {
				ts.delete(ts.findById(Integer.parseInt(request.getParameter("id"))));
				response.sendRedirect("tableTicket.jsp");
				
			} else if (request.getParameter("op").equals("update")) {
				int id = Integer.parseInt(request.getParameter("id"));
				Ticket t = ts.findById(id);
				response.sendRedirect("tableTicket.jsp?id=" + t.getId() + "&heureDentrer=" + t.getHeureDentrer() + "&Section=" + ss.findById(id));
				
			}
		
		} else {
			
			String heureDentrer = request.getParameter("heureDentrer");
			PlaceService ps = new PlaceService();
			SectionService ss = new SectionService();
			TicketService ts = new TicketService();
			int PlaceId = Integer.parseInt(request.getParameter("Place"));
			Place s = ps.findById(PlaceId);
			ts.create(new Ticket(heureDentrer, s));
			response.sendRedirect("tableTicket.jsp");
		}
	}

}
