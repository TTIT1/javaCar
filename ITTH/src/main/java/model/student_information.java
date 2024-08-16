package model;

import java.sql.Date;

public class student_information {
  
    private String fullName;
    private Date birthYear;
    private String homeTown;
    private String identificationCode;
 
	private String comBination;
    private float Subject1;
    private float Subject2;
    private float Subject3;
    private String conDuct;
    private String Major;
    @Override
 	public String toString() {
 		return "student_information [fullName=" + fullName + ", birthYear=" + birthYear + ", homeTown=" + homeTown
 				+ ", identificationCode=" + identificationCode + ", comBination=" + comBination + ", Subject1="
 				+ Subject1 + ", Subject2=" + Subject2 + ", Subject3=" + Subject3 + ", conDuct=" + conDuct + ", Major="
 				+ Major + "]";
 	}
    public student_information(String fullName, Date birthYear, String homeTown, String identificationCode,
                               String comBination, float subject1, float subject2, float subject3, String conDuct, String major) {
        super();
        this.fullName = fullName;
        this.birthYear = birthYear;
        this.homeTown = homeTown;
        this.identificationCode = identificationCode;
        this.comBination = comBination;
        Subject1 = subject1;
        Subject2 = subject2;
        Subject3 = subject3;
        this.conDuct = conDuct;
        Major = major;
    }

public student_information() {
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
public String getConDuct() {
	return conDuct;
}
public void setConDuct(String conDuct) {
	this.conDuct = conDuct;
}
public String getMajor() {
	return Major;
}
public void setMajor(String major) {
	Major = major;
}
  


  
}

