package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Section;
import connexion.Connexion;
import dao.IDao;

public class SectionService implements IDao<Section> {
	 PlaceService pss = new PlaceService();
    @Override
    public boolean create(Section o) {
        String sql = "insert into Section values (null, ? ,? ,? )";
        try {
        	 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getCode());
            ps.setString(2, o.getType());
            ps.setInt(3, o.getPrixParHeure());
           
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Section o) {
        String sql = "delete from Section where id  = ?";
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
    public boolean update(Section o) {

        String sql = "update Section set code  = ? ,type = ? ,PrixParHeure = ?  where id  = ?";
        try {
        	 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getCode());
            ps.setString(1, o.getType());
            ps.setInt(3, o.getPrixParHeure());
            ps.setInt(4, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("update : erreur sql : " + e.getMessage());

        }
        return false;
    }

    @Override
    public Section findById(int id) {
        
       
        String sql = "select * from Section where id  = ?";
        try {
        	 PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
           	 PlaceService pss = new PlaceService();

                return new Section(rs.getInt("id"),rs.getString("code"), rs.getString("type"),rs.getInt("PrixParHeure"));
                
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Section> findAll() {
        List<Section> sections = new ArrayList<Section>();

        String sql = "select * from Section";
        try {
        	PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
           	 

                sections.add(new Section(rs.getInt("id"),rs.getString("code"), rs.getString("type"),rs.getInt("prixParHeure") ));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return sections;
    }
    
   

}
