package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.matriculated_students;

public class DAOmatriculated_students implements Daointerface<matriculated_students> {
 
	public static DAOmatriculated_students getmatriculted_students() {
		
		return new DAOmatriculated_students();
	}
	@Override
	public int insert(matriculated_students t) {
		  Connection connection = JDBCUtil.getConnection();
		  
		  	  String sql = "INSERT INTO matriculated_students (FullName, BirthYear, Hometown, IdentificationCode, Studentcode, Combination, Subject1, Subject2, Subject3, Sumsubject, Conduct, Major) " +
					    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			try (PreparedStatement  preparedStatement = connection.prepareStatement(sql)){				
				    preparedStatement.setString(1,t.getFullName());
				    preparedStatement.setDate(2,t.getBirthYear());
				    preparedStatement.setString(3, t.getHomeTown());
				    preparedStatement.setString(4, t.getIdentificationCode());
				    preparedStatement.setString(5, t.getStudentcode());
				    preparedStatement.setString(6,t.getComBination());
				    preparedStatement.setFloat(7, t.getSubject1());
				    preparedStatement.setFloat(8,  t.getSubject2());
				    preparedStatement.setFloat(9,  t.getSubject3());
				    preparedStatement.setFloat(10,( t.getSubject1() + t.getSubject2() + t.getSubject3()));
				    preparedStatement.setString(11, t.getConDuct());
				    preparedStatement.setString(12, t.getMaJor());
				    preparedStatement.executeUpdate();
				JDBCUtil.closeconnection(connection);
			} catch (Exception e) {
				e.printStackTrace();
			} 
 
		
		return 0;
	}

	@Override
	public int updete(matriculated_students t) {
		
		
		return 0;
	}

	@Override
	public int delete(matriculated_students t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<matriculated_students> selectAll() {
		ArrayList<matriculated_students> list = new ArrayList<matriculated_students>();
		Connection connection = JDBCUtil.getConnection();
		try {
		
			String sql = "SELECT * FROM matriculated_students;";

			PreparedStatement ts =connection.prepareStatement(sql);
				 ResultSet rs = ts.executeQuery();
			while(rs.next()) {
				 String fullName =rs.getNString("FullName");
				  Date  birthYear = rs.getDate("BirthYear");
				   String homeTown = rs.getNString("Hometown");
				   String identificationCode = rs.getNString("IdentificationCode");
				   String Studentcode = rs.getNString("Studentcode");
				   String comBination =rs.getNString("Combination");
				  float Subject1 =rs.getFloat("Subject1") ;
				   float Subject2 = rs.getFloat("Subject2");
				   float Subject3 =rs.getFloat("Subject3") ;
				   float Sumsubject =rs.getFloat("Sumsubject");
				  String conDuct = rs.getNString("Conduct");
				 String maJor  = rs.getNString("Major");
				 matriculated_students b = new matriculated_students(fullName, birthYear, homeTown, identificationCode, Studentcode, comBination, Subject1, Subject2, Subject3, Sumsubject, conDuct, maJor);
				 list.add(b);
			}
			
			JDBCUtil.closeconnection(connection);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		
		return list;
	}
	

	

	@Override
	public ArrayList<matriculated_students> selectbyCondition(String Condition) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public matriculated_students selectbyid(matriculated_students t) {
	Connection con =JDBCUtil.getConnection();
	
	String sql = "SELECT *FROM matriculated_students wwhere IdentificationCode = ?";
	try {
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rt = st.executeQuery();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
		
	}

	public  void sort_student() {
		   Connection con = JDBCUtil.getConnection();
		   try {
			Statement st = con.createStatement();
			String sql = "SELECT * FROM matriculated_students ORDER BY Sumsubject ASC;";
			st.execute(sql);
			JDBCUtil.closeconnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
}
