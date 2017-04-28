package com.mb.brc.common;

import java.math.BigInteger;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.Reporter;

import com.mb.brc.common.*;


public class DatabaseAccessObject {
	
	
	public String getOtp(String mobileNumber) throws SQLException{
		
		 Connection connection = null;
		    PreparedStatement statement = null;
		    ResultSet resultSet = null;
		    String otp=null;

		    try {
		        try {
					connection = DatabaseConnection.startConnection();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       // statement = connection.prepareStatement("Select SBMISACTIVE from TPSBM where SBMEMAILID='"+email + "'");
		        statement = connection.prepareStatement("select EXFIELD2 from tpmvt where MVTMOBILE="+mobileNumber);
		        resultSet = statement.executeQuery();
		       
		        while (resultSet.next())
		        {
		        	otp= resultSet.getString("EXFIELD2");
		        }
		        
		        
		  
		        	
		        
		    } 
		    catch(SQLException e){
		    	e.printStackTrace();
		    	
		    }
		    catch(Exception e){
		    	e.printStackTrace();
		    }
		    	finally {
		    
		    	DatabaseConnection.closeConnection(connection);
		        if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
		        if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
		        if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
		    }

		    return otp;
		
	}
	
	public boolean verifyPropertyDetails(int propertyId, String sellOrRent, String scenario) throws SQLException{
		
		    Connection connection = null;
		    PreparedStatement statement = null;
		    ResultSet resultSet = null;
		    
		    UtilFunctions util = new UtilFunctions();
		    Properties prop = new Properties();
			prop = util.loadPropertiesFile(); 
			
			int sellPrice = Integer.parseInt(prop.getProperty("totalPrice"));
			int rentPrice = Integer.parseInt(prop.getProperty("rent"));
			int sellPrice_Edit = Integer.parseInt(prop.getProperty("editPrice"));
			int rentPrice_Edit = Integer.parseInt(prop.getProperty("editRent"));
			//String sellOrRent = prop.getProperty("sellOrRent");
			
			String sellOrRentDb=null;
			String postSourceDb=null;
			String activeOrNotDb=null;
			int salePriceInDb=0;
			int rentPriceInDb=0;
			
			boolean priceCheck = false;
			boolean pass=false;
		    String listType =null;
		   
		    
		   

		    try {
		        try {
					connection = DatabaseConnection.startConnection();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        statement = connection.prepareStatement("select PMTSOURCE,PMTLISTTYPE,PMTCNDPROPTYPE,PMTSALEPRICE,PMTRENTPRICE,PMTISACTIVE from TPPMT where PMTRFNUM="+propertyId);
		        resultSet = statement.executeQuery();
		       
		        if (resultSet.next()) {
		        	sellOrRentDb = resultSet.getString("PMTLISTTYPE");
		        	System.out.println(sellOrRentDb);
		        	Reporter.log("Posted property Type: "+sellOrRentDb);
		        	postSourceDb = resultSet.getString("PMTSOURCE");
			        System.out.println(postSourceDb);
			        Reporter.log("Posted property source: "+postSourceDb);
			        salePriceInDb  = resultSet.getInt("PMTSALEPRICE");
			        System.out.println(salePriceInDb);
			        rentPriceInDb  = resultSet.getInt("PMTRENTPRICE");
			        System.out.println(rentPriceInDb);
			        activeOrNotDb= resultSet.getString("PMTISACTIVE");
			        System.out.println(activeOrNotDb);
			        Reporter.log("Posted property ActiveOrNot: "+activeOrNotDb);
			        
		        }
		        
		      if(scenario.equalsIgnoreCase("Post Property"))  {
		       
		        if(sellOrRent.equalsIgnoreCase("Sell")){
			    	listType="S";
			    	if(salePriceInDb==sellPrice){
			    		priceCheck=true;
			    		System.out.println("type sell");
			    		Reporter.log("Posted property price: "+salePriceInDb);
			    	}
			    	
			    }else{
			    	listType="R";
			    	if(rentPriceInDb==rentPrice){
			    		priceCheck=true;
			    		Reporter.log("Posted property rent: "+rentPriceInDb);
			    	}
			    } 
		        
		      }else{
		    	  if(sellOrRent.equalsIgnoreCase("Sell")){
				    	listType="S";
				    	if(salePriceInDb==sellPrice_Edit){
				    		priceCheck=true;
				    		System.out.println("type sell");
				    		Reporter.log("Posted property price: "+salePriceInDb);
				    	}
				    	
				    }else{
				    	listType="R";
				    	if(rentPriceInDb==rentPrice_Edit){
				    		priceCheck=true;
				    		Reporter.log("Posted property rent: "+rentPriceInDb);
				    	}
				    } 
		    	  
		      }
		    	  
		        
		       if(sellOrRentDb.equalsIgnoreCase(listType) && postSourceDb.equalsIgnoreCase(prop.getProperty("postingSource"))
		    	  && activeOrNotDb.equalsIgnoreCase("Y") && priceCheck==true){
		    	  
		    	   pass=true;
		       } 
		       else{
		    	   System.out.println("fail");
		       }
    	
		        
		    } 
		    catch(SQLException e){
		    	e.printStackTrace();
		    	
		    }
		    catch(Exception e){
		    	e.printStackTrace();
		    }
		    	finally {
		    
		    	DatabaseConnection.closeConnection(connection);
		        if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
		        if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
		        if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
		    }

		    return pass;
		
	}
	
}
