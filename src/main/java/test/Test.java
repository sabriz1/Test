package test;

import java.sql.SQLException;
import java.sql.Statement;

import beans.Section;
import connexion.Connexion;

public class Test {

	public static void main(String[] args) {
		try {

			String createTableSection = "create table Section (" 
									  + "id int primary key auto_increment,"
									  + "code varchar(20),"
									  + "type varchar(20),"
									  + "PrixParHeure int);";
									 
									  
			
			String createTablePlace = "create table Place (" 
					  + "id int primary key auto_increment,"
					  + "numeroPla int,"
					  + "etat varchar(20),"
					  + "idSection int"
					  + ");";
					  
			String createTableTicket = "create table Ticket (" 
					  + "id int primary key auto_increment,"
					  + "heureDentrer varchar(20),"
					  + "idPlace int );";
			
			String createTableUser = "create table User (" 
					  + "id int primary key auto_increment,"
					  + "username varchar(20),"
					  + "password varchar(20));";
			//String heureDentrer, Section section
			
			String constraint = "alter table Place add "
                    + "constraint fk foreign key (idSection)"
                    + "references Section(id)";
			
			String constraint1 = "alter table Ticket add "
                    + "constraint fk_1 foreign key (idPlace)"
                    + "references Place(id)";

			Statement st = Connexion.getInstane().getConnection().createStatement();
			st.executeUpdate("drop table if exists Ticket");  
			st.executeUpdate("drop table if exists Place"); 
			st.executeUpdate("drop table if exists Section");   
			st.executeUpdate("drop table if exists User"); 
			st.executeUpdate(createTableUser);
			st.executeUpdate(createTablePlace);
			st.executeUpdate(createTableSection);
			st.executeUpdate(createTableTicket);
			 st.execute(constraint);
			 st.execute(constraint1);
			 Connexion.getInstane().getConnection().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
