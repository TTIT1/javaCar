package model;

import java.sql.Date;

//import javax.xml.crypto.Data;

public class matriculated_students {


	@Override
	public String toString() {
		return "matriculated_students [fullName=" + fullName + ", birthYear=" + birthYear + ", homeTown=" + homeTown
				+ ", identificationCode=" + identificationCode + ", Studentcode=" + Studentcode + ", comBination="
				+ comBination + ", Subject1=" + Subject1 + ", Subject2=" + Subject2 + ", Subject3=" + Subject3
				+ ", Sumsubject=" + Sumsubject + ", conDuct=" + conDuct + ", maJor=" + maJor + "]";
	}
	private String fullName;
	 
	
	private Date  birthYear;
	  private String homeTown;
	  private String identificationCode;
	  private String Studentcode;
	  private String comBination;
	  private float Subject1;
	  private float Subject2;
	  private float Subject3;
	  private float Sumsubject;
	  private String conDuct;
	  private String maJor;
	public matriculated_students( String fullName, Date birthYear, String homeTown,
			String identificationCode, String studentcode, String comBination, float subject1, float subject2,
			float subject3, float sumsubject, String conDuct, String maJor) {
		super();
	
		this.fullName = fullName;
		this.birthYear = birthYear;
		this.homeTown = homeTown;
		this.identificationCode = identificationCode;
		Studentcode = studentcode;
		this.comBination = comBination;
		Subject1 = subject1;
		Subject2 = subject2;
		Subject3 = subject3;
		Sumsubject = sumsubject;
		this.conDuct = conDuct;
		this.maJor = maJor;
	}
	public matriculated_students() {
		super();
	}

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(Date birthYear) {
		this.birthYear = birthYear;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	public String getIdentificationCode() {
		return identificationCode;
	}
	public void setIdentificationCode(String identificationCode) {
		this.identificationCode = identificationCode;
	}
	public String getStudentcode() {
		return Studentcode;
	}
	public void setStudentcode(String studentcode) {
		Studentcode = studentcode;
	}
	public String getComBination() {
		return comBination;
	}
	public void setComBination(String comBination) {
		this.comBination = comBination;
	}
	public float getSubject1() {
		return Subject1;
	}
	public void setSubject1(float subject1) {
		Subject1 = subject1;
	}
	public float getSubject2() {
		return Subject2;
	}
	public void setSubject2(float subject2) {
		Subject2 = subject2;
	}
	public float getSubject3() {
		return Subject3;
	}
	public void setSubject3(float subject3) {
		Subject3 = subject3;
	}
	public float getSumsubject() {
		return Sumsubject;
	}
	public void setSumsubject(float sumsubject) {
		Sumsubject = sumsubject;
	}
	public String getConDuct() {
		return conDuct;
	}
	public void setConDuct(String conDuct) {
		this.conDuct = conDuct;
	}
	public String getMaJor() {
		return maJor;
	}
	public void setMaJor(String maJor) {
		this.maJor = maJor;
	}
	  
	  
}
