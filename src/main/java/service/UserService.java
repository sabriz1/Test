package service;

import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import beans.User;
import beans.Ticket;
import beans.User;
import connexion.Connexion;
import dao.IDao;
import jakarta.servlet.http.HttpServletRequest;

public class UserService implements IDao<User> {

	@Override
	public boolean create(User o) {
		String sql = "insert into User values (null, ? , ?)";
		try {
			 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			 ps.setString(2, o.getUsername());
			ps.setString(2, o.getPassword());
			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(User o) {
		String sql = "delete from User where id  = ?";
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
	public boolean update(User o) {

		String sql = "update User set username = ?  , password= ?    where id  = ?";
		try {
			 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			 ps.setString(2, o.getUsername());
				ps.setString(2, o.getPassword());
			ps.setInt(3, o.getId());

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
	public User findById(int id) {

		String sql = "select * from User where id  = ?";
		try {
			 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
			}

		} catch (SQLException e) {
			System.out.println("findById " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> Users = new ArrayList<User>();

		String sql = "select * from User";
		try {
			 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Users.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("password")));
			}

		} catch (SQLException e) {
			System.out.println("findAll " + e.getMessage());
		}
		return Users;
	}

}
