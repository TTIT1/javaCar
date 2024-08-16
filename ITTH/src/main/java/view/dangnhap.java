package view;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import dao.DAOmatriculated_students;
import dao.DAOstudent_information;
import dao.DAOuseName;
import database.JDBCUtil;
import model.matriculated_students;
import model.student_information;
import model.useName;

public class dangnhap {
	public static void show_list_student() {
		ArrayList<matriculated_students> list_student =new ArrayList<matriculated_students>();
		list_student = DAOmatriculated_students.getmatriculted_students().selectAll();
		int i = list_student.size();
		System.out.println(i);
		try {
			for (matriculated_students matriculated_students1 : list_student) {
		          System.out.println(matriculated_students1.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}	
 	public static void them(String nganh,float sun) {
		int dem = 0;
		ArrayList<student_information> list_trung = new ArrayList<student_information>();
		list_trung  = DAOstudent_information.getInstance().selectAll();
		for (student_information student_information1 : list_trung) {
			if((student_information1.getSubject1()+student_information1.getSubject2()+student_information1.getSubject3())>=sun && student_information1.getMajor().equals(nganh)){
				   matriculated_students b  = new matriculated_students(student_information1.getFullName(),  student_information1.getBirthYear(), student_information1.getHomeTown(), student_information1.getIdentificationCode(), student_information1.getIdentificationCode()+"IT",student_information1.getComBination(), student_information1.getSubject1(), student_information1.getSubject2(), student_information1.getSubject3(), 0, student_information1.getConDuct(), student_information1.getMajor());
				    System.out.println(b.getFullName());
				  DAOmatriculated_students.getmatriculted_students().insert(b);
				DAOstudent_information.getInstance().delete(student_information1);
				   dem++;
				}
		}
		System.out.println("đã thêm được "+dem+" sinh vien đủ điều kiện ");
	}
 	
    public static boolean quan_tri(String name,String pass) {
		String nameuse = "root";
    	String passwork = "KINH CONG";
    	
    	if(nameuse.equals(name)&& passwork.equals(passwork) ) {
    		return true;
    	}
    	return false;
	}	
    public static void kt_trung_tuyen(String code) {
		matriculated_students b = new matriculated_students(null, null, null, code, null, null, 0, 0, 0, 0, null, null);
		b=DAOmatriculated_students.getmatriculted_students().selectbyid(b);
		if(b!=null) {
			System.out.println(b.toString()); 
			System.out.println("chuc mung ban da chung tuyen hihi");
		}else if(b ==null) {
			System.out.println("rotes");
		}
	}
	public static Boolean DN(String code_DN) {
		
		Connection connection = JDBCUtil.getConnection();
		
		try {
			Statement st = connection.createStatement();
			String sql = "SELECT * FROM usename ";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				
				String  identificationCode = rs.getNString("IdentificationCode");
				 if(identificationCode.equals(code_DN) )  {
					 JDBCUtil.closeconnection(connection);
					return true;
				}
			}
			JDBCUtil.closeconnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
    public static void DK_TK() {
    	System.out.println("Trường đại học Kinh Doanh và Công Nghệ Hà Nội ");
    	System.out.println("             tuyển sinh năm học 2024          ");
    	System.out.println("---------------------------------------------- ");
    	String fullName;
        Date birthYear = null;
        String homeTown;
        String identificationCode;
     
    	 String comBination;
        float Subject1;
         float Subject2;
        float Subject3;
         String conDuct;
         String Major;
    	Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Full Name: ");
        fullName = scanner.nextLine();

        System.out.print("Enter Birth Year (YYYY-MM-DD): ");
        // Assume you want to input the birth year as a string and convert it to Date later
       String birthYearString = scanner.nextLine();
       birthYear =  Date.valueOf(birthYearString);
        // You need to handle the conversion from String to Date based on your requirements

        System.out.print("Enter Home Town: ");
        homeTown = scanner.nextLine();

        System.out.print("Enter Identification Code: ");
        identificationCode = scanner.nextLine();

        System.out.print("Enter Combination: ");
        comBination = scanner.nextLine();

        System.out.print("Enter Subject 1 score: ");
        Subject1 = scanner.nextFloat();

        System.out.print("Enter Subject 2 score: ");
        Subject2 = scanner.nextFloat();

        System.out.print("Enter Subject 3 score: ");
        Subject3 = scanner.nextFloat();
        scanner.nextLine(); // consume the newline character

        System.out.print("Enter Conduct: ");
        conDuct= scanner.nextLine();

        System.out.print("Enter Major: ");
        Major= scanner.nextLine();

        // Close the scanner to avoid resource leak
        scanner.close();
        student_information b = new student_information(fullName, birthYear, homeTown, identificationCode, comBination, Subject1, Subject2, Subject3, conDuct, Major);
    	DAOstudent_information.getInstance().insert(b);
    	System.out.println("Chuc mung bạn da đang ky thanh công ");
    	useName c =new useName();
    	c.setUseName(identificationCode);
    	DAOuseName v = new DAOuseName();
    	System.out.println(c.getUseName());
    	v.insert(c);
    	
    }
    public static void delete_student(String code) {
    	student_information b = new  student_information(null, null, null, code, null, 0, 0, 0, null, null);
    	DAOstudent_information.getInstance().delete(b);
    }
    public static void updete_student(String code) {
    	String fullName;
        Date birthYear = null;
        String homeTown;
        String identificationCode;
     
    	 String comBination;
        float Subject1;
         float Subject2;
        float Subject3;
         String conDuct;
         String Major;
    	Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Full Name: ");
        fullName = scanner.nextLine();

        System.out.print("Enter Birth Year (YYYY-MM-DD): ");
        // Assume you want to input the birth year as a string and convert it to Date later
       String birthYearString = scanner.nextLine();
       birthYear =  Date.valueOf(birthYearString);
        // You need to handle the conversion from String to Date based on your requirements

        System.out.print("Enter Home Town: ");
        homeTown = scanner.nextLine();
        System.out.print("Enter Identification Code: ");
      do {
	
         identificationCode = scanner.nextLine();
     if( !identificationCode.equals(code) ) {
    	 System.out.println("vui long nhap chinh xac code : ");
     }
       }while( !identificationCode.equals(code));
       

        System.out.print("Enter Combination: ");
        comBination = scanner.nextLine();

        System.out.print("Enter Subject 1 score: ");
        Subject1 = scanner.nextFloat();

        System.out.print("Enter Subject 2 score: ");
        Subject2 = scanner.nextFloat();

        System.out.print("Enter Subject 3 score: ");
        Subject3 = scanner.nextFloat();
        scanner.nextLine(); // consume the newline character

        System.out.print("Enter Conduct: ");
        conDuct= scanner.nextLine();

        System.out.print("Enter Major: ");
        Major= scanner.nextLine();

        // Close the scanner to avoid resource leak
        scanner.close();
     student_information   b=new student_information(fullName, birthYear, homeTown, identificationCode, comBination, Subject1, Subject2, Subject3, conDuct, Major);
        DAOstudent_information.getInstance().updete(b);
    }
    public static void sort() {
    	DAOmatriculated_students.getmatriculted_students().sort_student();
    	System.out.println("sinh vien sap sep theo ddiem la ");
    	show_list_student();
    }
    public static void find(String code) {
    	matriculated_students b = new matriculated_students(null, null, null, code, null, null, 0, 0, 0, 0, null, null);
         b= 	DAOmatriculated_students.getmatriculted_students().selectbyid(b);
    	System.out.println( b.toString()); 
    	
    }
    
}
