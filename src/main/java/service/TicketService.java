package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Section;
import beans.Ticket;
import connexion.Connexion;
import dao.IDao;

public class TicketService implements IDao<Ticket>{
	@Override
	public boolean create(Ticket o) {
		String sql = "insert into Ticket values (null, ? , ?)";
		try {
			 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			ps.setString(1, o.getHeureDentrer());
			ps.setInt(2, o.getPlace().getId());
			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	@Override
	public boolean delete(Ticket o) {
		String sql = "delete from Ticket where id  = ?";
        try {
        	 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("delete : erreur sql : " + e.getMessage());

        }
        return false;
    }

	@Override
	public boolean update(Ticket o) {
		 String sql = "update Ticket set HeureDentrer  = ? ,idPlace = ?  where id  = ?";
	        try {
	        	 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
	            ps.setString(1, o.getHeureDentrer());
	            ps.setInt(2, o.getPlace().getId());
	            ps.setInt(3, o.getId());
	            if (ps.executeUpdate() == 1) {
	                return true;
	            }
	        } catch (SQLException e) {
	            System.out.println("update : erreur sql : " + e.getMessage());

	        }
	        return false;
	    }

	@Override
	public Ticket findById(int id) {
		String sql = "select * from Ticket where id  = ?";
        try {
        	 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	PlaceService pss = new PlaceService();

                return new Ticket(rs.getInt("id"),rs.getString("HeureDentrer"), pss.findById(rs.getInt("idPlace")));
                
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }


	@Override
	public List<Ticket> findAll() {
		 List<Ticket> tickets = new ArrayList<Ticket>();
	        String sql = "select * from Ticket";
	        try {
	        	 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	PlaceService pss = new PlaceService();

	                tickets.add(new Ticket(rs.getInt("id"),rs.getString("heureDentrer"), pss.findById(rs.getInt("idPlace"))));
	            }

	        } catch (SQLException e) {
	            System.out.println("findAll " + e.getMessage());
	        }
	        return tickets;
	    }
}
