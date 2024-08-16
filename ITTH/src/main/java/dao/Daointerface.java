package dao;

import java.util.ArrayList;



public interface Daointerface <T> {

	public int insert (T t);
	public int updete(T t);
	public int delete(T t);
	
	public ArrayList<T> selectAll();
	public T selectbyid(T t);
	public ArrayList<T> selectbyCondition( String Condition);
    

	
}
