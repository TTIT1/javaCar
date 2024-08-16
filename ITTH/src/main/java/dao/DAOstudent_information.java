package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;


import database.JDBCUtil;
import model.student_information;


public class DAOstudent_information implements Daointerface<student_information> {
 // tạo 1 hàm để không cần tạo đối tuongwg ta chỉ cần gọi tên lớp và chấm đến hàm getInstance và chấm đến phương thức ta muốn dùng
	public static DAOstudent_information getInstance() {
		return new DAOstudent_information();
	}

	@Override
	public int insert(student_information t) {
		
		Connection connection = JDBCUtil.getConnection();
		String sql = "INSERT INTO student_information (FullName, BirthYear, Hometown, IdentificationCode, Combination, Subject1, Subject2, Subject3, Conduct, Major) " +
		        "VALUES (?,?,?,?,?,?,?,?,?,?);";

		try (PreparedStatement st = connection.prepareStatement(sql)) {
		    st.setString(1, t.getFullName());
		    st.setDate(2, t.getBirthYear());
		    st.setNString(3, t.getHomeTown());
		    st.setString(4, t.getIdentificationCode());
		    st.setString(5, t.getComBination());
		    st.setFloat(6, t.getSubject1());
		    st.setFloat(7, t.getSubject2());
		    st.setFloat(8, t.getSubject3());
		    st.setNString(9, t.getConDuct());
		    st.setNString(10, t.getMajor());
		    st.executeUpdate();
  
   JDBCUtil.closeconnection(connection);
		  
		} catch (SQLException e) {
		    e.printStackTrace();
		}	
		return 0;
	}

	@Override
	public int updete(student_information t ) {
		Connection connection = JDBCUtil.getConnection();
		try {			
			String sql = "UPDATE student_information SET " +
			        "FullName =?," +
			        "BirthYear = ?, " +
			        "Hometown =?, " +
			        "IdentificationCode = ?, " +
			        "Combination = ?, " +
			        "Subject1 = ?, " +
			        "Subject2 =?, " +
			        "Subject3 = ?, " +
			        "Conduct = ?, " +
			        "Major = ?' " +
			        "WHERE IdentificationCode = ?;";
			try(PreparedStatement st = connection.prepareStatement(sql)){
				 st.setString(1, t.getFullName());
				    st.setDate(2, t.getBirthYear());
				    st.setNString(3, t.getHomeTown());
				    st.setString(4, t.getIdentificationCode());
				    st.setString(5, t.getComBination());
				    st.setFloat(6, t.getSubject1());
				    st.setFloat(7, t.getSubject2());
				    st.setFloat(8, t.getSubject3());
				    st.setNString(9, t.getConDuct());
				    st.setNString(10, t.getMajor());
				    st.executeUpdate();
					JDBCUtil.closeconnection(connection);
			}} catch (SQLException e) {
			    e.printStackTrace();
			}

		return 0;
	}

	@Override
	public int delete(student_information t) {
		// b1 tao kết nối
		Connection connection = JDBCUtil.getConnection();
		try {
			String sql = "DELETE FROM student_information WHERE IdentificationCode = ? ;";
			
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, t.getIdentificationCode());
			st.executeUpdate();
			JDBCUtil.closeconnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public ArrayList<student_information> selectAll() {
	ArrayList<student_information> student = new ArrayList<student_information>();
	
	  Connection connection = JDBCUtil.getConnection();
	  
	  try {
		
		String sql = "SELECT * FROM student_information ;";
		PreparedStatement st = connection.prepareStatement(sql);
		
		 ResultSet  RS =  st.executeQuery(sql) ;
		 while(RS.next()) {
			String FullName = RS.getString("FullName");
			Date BirthYear = RS.getDate("BirthYear");
			String Hometown = RS.getString("Hometown");
			String IdentificationCode = RS.getNString("IdentificationCode");
			String Combination = RS.getString("Combination");
			float Subject1 = RS.getFloat("Subject1");
			float Subject2 =RS.getFloat("Subject2");
			float Subject3 =RS.getFloat("Subject3");
			String Conduct = RS.getString("Conduct");
			String Major = RS.getString("Major");
			student_information b = new student_information(FullName, BirthYear, Hometown, IdentificationCode, Combination, Subject1, Subject2, Subject3, Conduct, Major);
			 student.add(b);
			 
		 }
		
		JDBCUtil.closeconnection(connection);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		return student;
	}

	@Override
	public student_information selectbyid(student_information t) {
		 Connection cn = JDBCUtil.getConnection();
			student_information b = null ;
		 try {
			 String sql = "SELECT IdentificationCode,FullName FROM student_information;";

			PreparedStatement st = cn .prepareStatement(sql);
			ResultSet rs =  st.executeQuery(sql);
			
			while(rs.next()) {
				String IdentificationCode = rs.getString("IdentificationCode");
				String FullName = rs.getString("FullName");
			 b = new student_information(FullName, null, FullName, IdentificationCode, sql, 0, 0, 0, IdentificationCode, FullName);
				b.toString();
			}
			JDBCUtil.closeconnection(cn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		return b;
	}

	@Override
	public ArrayList<student_information> selectbyCondition(String Condition) {
		  ArrayList<student_information> lisst = new ArrayList<student_information>();
		  Connection con = JDBCUtil.getConnection();
		  String sql = "SELECT *FROM student_information ";
		  
		  try (PreparedStatement pst = con.prepareStatement(sql)){
			  ResultSet RS= pst.executeQuery();
			 while(RS.next()) {
					String FullName = RS.getString("FullName");
					Date BirthYear = RS.getDate("BirthYear");
					String Hometown = RS.getString("Hometown");
					String IdentificationCode = RS.getNString("IdentificationCode");
					String Combination = RS.getString("Combination");
					float Subject1 = RS.getFloat("Subject1");
					float Subject2 =RS.getFloat("Subject2");
					float Subject3 =RS.getFloat("Subject3");
					String Conduct = RS.getString("Conduct");
					String Major = RS.getString("Major");
					if(Combination.equals(Condition)) {
						student_information b = new student_information(FullName, BirthYear, Hometown, IdentificationCode, Combination, Subject1, Subject2, Subject3, Conduct, Major);
						lisst.add(b);
					}
			 }
			  JDBCUtil.closeconnection(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		
		return lisst;
	}
   

}

