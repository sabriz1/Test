package test;

import beans.Place;
import beans.Section;
import beans.Ticket;
import service.PlaceService;
import service.SectionService;
import service.TicketService;

public class Testall {
public static void main(String[] args) {
	PlaceService ps = new PlaceService();
	SectionService ss = new SectionService();
	TicketService ts = new TicketService();
	//Place( int numeroPla, String type, boolean etat, double nbrHeureOccupper) 
	//Section( String code,  int prixParHeure, Place place)
	ss.create(new Section("sa", "sa", 10));
	ps.create(new Place(2, "dz", ss.findById(1)));
	
	
	for(Place p : ps.findAll())
		System.out.println(p);
	
	
}
}