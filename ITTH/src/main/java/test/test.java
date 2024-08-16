package test;

import java.util.Scanner;


import view.dangnhap;

public class test {
	 public static Scanner pi = new Scanner(System.in);
	 public static void main(String[] args) {
	
		   
		
	        System.out.println("1.Nhap tai khoan ");
	        System.out.println("2.Đăng ky tài khoan");
	        System.out.println("0.Quan tri vien dang nhap");
	        int choice = pi.nextInt();
	        pi.nextLine();  // Consume the newline character

	        if (choice == 1) {
	            System.out.print("nhap tài khoan cua ban : ");
	            Boolean kt = null;
	            String code = pi.nextLine();
	            kt = dangnhap.DN(code);
	           
	            if (kt == true) {
	                int lc;

	                do {
	                    System.err.println("1.Sua thong tin ca nhan ");
	                    System.err.println("2.xoa tai khoan dk ");
	                    System.err.println("3.kiem tra ");
	                    System.err.println("0.thoat");
	                    lc = pi.nextInt();
	                    pi.nextLine();  // Consume the newline character
	                    if (lc == 1) {
	                        dangnhap.updete_student(code);
	                    } else if (lc == 2) {
	                        dangnhap.delete_student(code);
	                    } else if (lc == 3) {
	                    	dangnhap.kt_trung_tuyen(code);
	                    }
	                   
	                } while (lc == 0);
	            }else if(kt == false) {
	            	System.out.println("bạn chua co tai khoan vui long đk tk hoặc kiểm tra lại !");
	            	
	            }
	        }else if(choice == 2) {
	        	dangnhap.DK_TK();
	        }else if(choice == 0) {
	        	int i = 0;
	        	String tk;
	        	String mk ;
	        	do {
	        		i++;
	        		System.out.print("Nhap tai khoan :");  tk = pi.nextLine();
		        	System.out.print("Nhap mat khau :"); mk = pi.nextLine();
		        	if(!tk.equals("root") && !mk.equals("KINH CONG")) {
		        		System.out.println(" luy ý bạn dã nhập sai "+i+" lần nếu sai 3 lần liên tiếp sẽ bị khoa máy !");
		        	}
		        	
	        	}while(!tk.equals("root") && !mk.equals("KINH CONG")&&i<3);
	       
	        	  boolean ktt = dangnhap.quan_tri(tk, mk);
	        	  if(ktt == true) {
	        		    System.out.println("1.Them cac sinh vien trúng tuyên ");
		        		System.out.println("2.Xem danh sach sinh vien trúng tuyển");
		        		System.out.println("3.Sắp xếp sinh viên trúng tuyển có điểm cao nhất");
		        		System.out.println("4.thoát");
		        		System.out.println("̀.tim kiem sinh vien ");
		        		System.out.println("Nhập lụa chon ");
		        		int lc = pi.nextInt() ;
		        		pi.nextLine();
		        		if(lc == 1 ) {
		        			 String nganh;
		        		        float tong;
		        			 System.out.println("Nhap nganh: ");
		        		        nganh = pi.nextLine();

		        		        System.out.println("Nhap tong diem: ");
		        		        tong = pi.nextFloat();
		        			   dangnhap.them(nganh,tong);
		        			  
		        		}else if(lc == 2 ) {
		        	
		        			dangnhap.show_list_student();
		        		}else if(lc == 3 ) {
		        			dangnhap.sort();
		        		}
		        		else if(lc==4) {
		        			dangnhap.find("1234");
		        		}
	        	  }
	        	
	        }
	        
	        
	        
	        
	    }  
	   
	   
	 
	   
	   
	   
	   
	   
	   
	   
}

