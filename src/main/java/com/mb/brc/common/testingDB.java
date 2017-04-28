package com.mb.brc.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class testingDB {
	
	public int getSBMRFNUM() throws Exception    {
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    int rfNUM = 0;
	    
	    connection = DatabaseConnection.startConnection();
	    statement = connection.prepareStatement("select SBMRFNUM from tpsbm where sbmemailid = 'wapsanity12aug@mailinator.com'");
	    resultSet = statement.executeQuery();
	    
	    while(resultSet.next())
	    {
	    	rfNUM = resultSet.getInt("SBMRFNUM");
	    }
	    
	    
	    return rfNUM;

	}
	
	public static void main(String args[]){
		testingDB dbObj = new testingDB();
		try {
			int num = dbObj.getSBMRFNUM();
			System.out.println("RFNUM is: "+ num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
