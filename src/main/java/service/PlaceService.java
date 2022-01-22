package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Place;
import beans.Section;
import connexion.Connexion;
import dao.IDao;

/*
private int id;
private int numeroPla;
private String type;
private boolean etat;
*/
public class PlaceService implements IDao<Place> {

	@Override
	public boolean create(Place o) {
		String sql = "insert into Place values (null, ? , ? , ?)";
		try {
			 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			ps.setInt(1, o.getNumeroPla());
			ps.setString(2, o.getEtat());
			ps.setInt(3, o.getSection().getId());
			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Place o) {
		String sql = "delete from Place where id  = ?";
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
	public boolean update(Place o) {

		String sql = "update Place set numeroPla  = ?  , etat= ? ,idSection=?   where id  = ?";
		try {
			 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			ps.setInt(1, o.getNumeroPla());
			ps.setString(2, o.getEtat());
			ps.setInt(3, o.getSection().getId());
			ps.setInt(4, o.getId());

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("update : erreur sql : " + e.getMessage());

		}
		return false;
	}

	/*
	 * private int id; private int numeroPla; private String type; private boolean
	 * etat;
	 */
	@Override
	public Place findById(int id) {

		String sql = "select * from Place where id  = ?";
		try {
			 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				SectionService ss = new SectionService();

				return new Place(rs.getInt("id"), rs.getInt("numeroPla"), rs.getString("etat"),ss.findById(rs.getInt("idSection")));
			}

		} catch (SQLException e) {
			System.out.println("findById " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Place> findAll() {
		List<Place> places = new ArrayList<Place>();

		String sql = "select * from Place";
		try {
			 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SectionService ss = new SectionService();

				places.add(new Place(rs.getInt("id"), rs.getInt("numeroPla"), rs.getString("etat"),ss.findById(rs.getInt("idSection"))));
			}

		} catch (SQLException e) {
			System.out.println("findAll " + e.getMessage());
		}
		return places;
	}

}
