package demooo.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {
	
	//insert into book_details values(4,'life of pie','Personality development',99,'Vijju','luqman',4),(5,'Rich dad poor dad','personality development',299,'pratyush','shiva',2);
	Connection con = null;
	
	public AlienRepository() {
		String url = "jdbc:mysql://localhost:3306/books";
		String username = "root";
		String password = "Vijaykumar@123";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public List<Alien> getAliens(){
		
		List<Alien> aliens = new ArrayList<>();
		
		try {
			String sql = "select * from book_details";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Alien a = new Alien();
				a.setBook_id(rs.getInt(1));
				a.setBook_title(rs.getString(2));
				a.setCategory(rs.getString(3));
				a.setBook_author(rs.getString(5));
				a.setPrice(rs.getInt(4));
				a.setUsername(rs.getString(6));
				a.setUserId(rs.getInt(7));
				aliens.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return aliens;
		
	}
	
	public Alien getAlien(int id) {
		Alien a = new Alien();
		
		try {
			String sql = "select * from book_details where user_id = "+id;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				a.setBook_id(rs.getInt(1));
				a.setBook_title(rs.getString(2));
				a.setCategory(rs.getString(3));
				a.setBook_author(rs.getString(5));
				a.setPrice(rs.getInt(4));
				a.setUsername(rs.getString(6));
				a.setUserId(rs.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		
	}
	public Alien getUserId(int id) {
		Alien a = new Alien();
		
		try {
			System.out.println(id+"id from rep");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from book_details where user_id ='"+id+"'");
			if(rs.next()) {
				System.out.println("data exists");
				a.setBook_id(rs.getInt(1));
				a.setBook_title(rs.getString(2));
				a.setCategory(rs.getString(3));
				a.setBook_author(rs.getString(5));
				a.setPrice(rs.getInt(4));
				a.setUsername(rs.getString(6));
				a.setUserId(rs.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		
	}
	public Alien getBookId(int id) {
		Alien a = new Alien();
		
		try {
			//System.out.println(id+"id from rep");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from book_details where book_id ='"+id+"'");
			if(rs.next()) {
				System.out.println("data exists");
				a.setBook_id(rs.getInt(1));
				a.setBook_title(rs.getString(2));
				a.setCategory(rs.getString(3));
				a.setBook_author(rs.getString(5));
				a.setPrice(rs.getInt(4));
				a.setUsername(rs.getString(6));
				a.setUserId(rs.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		
	}
	public void create(Alien a1) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into book_details values(?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,a1.getBook_id());
			st.setString(2,a1.getBook_title());
			st.setString(3,a1.getCategory());
			st.setInt(4, a1.getPrice());
			st.setString(5,a1.getBook_author());
			st.setString(6,a1.getUsername());
			st.setInt(7, a1.getUserId());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void update(Alien a1) {
		// TODO Auto-generated method stub
		try {
			String sql = "update book_details set book_title=?,category=?,price=?,book_author=?,username=?,user_id=? where book_id=?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,a1.getBook_title());
			st.setString(2,a1.getCategory());
			st.setInt(3, a1.getPrice());
			st.setString(4,a1.getBook_author());
			st.setString(5,a1.getUsername());
			st.setInt(6, a1.getUserId());
			st.setInt(7,a1.getBook_id());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void delete(int userid) {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from book_details where user_id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,userid);
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Alien> filterCategory(String category,String author) {
		System.out.println(category+" ccc"+author);
		// TODO Auto-generated method stub
		List<Alien> list=new ArrayList<Alien>();
		
		try {
			
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery("select * from book_details where category='"+category+"' or book_author='"+author+"'");
			
			while(rs.next()) {
				Alien a=new Alien();
			System.out.println("name="+rs.getString(2));
			a.setBook_id(rs.getInt(1));
			a.setBook_title(rs.getString(2));
			a.setCategory(rs.getString(3));
			a.setBook_author(rs.getString(5));
			a.setPrice(rs.getInt(4));
			a.setUsername(rs.getString(6));
			a.setUserId(rs.getInt(7));
			list.add(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(list);
//		System.out.println("raale");
		return list;
	}

}
