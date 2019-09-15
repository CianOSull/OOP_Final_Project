/*
 * Author: Cian O'Sullivan
 * Student number: R00160696
 * Objective: Database Project
 */
package model;

import java.sql.*;
import java.util.Scanner;

public class updateData {
	Statement myStmt;
	
	/**
	 * Updates information in the table
	 * @param myStmt
	 */
	public updateData(Statement myStmt) {
		this.myStmt = myStmt;
	}
	
	/**
	 * updates module information 
	 * @param value
	 * @param stid
	 * @param subject
	 */
	public void dataUpdate(int value, int stid, String subject) {
		try {			
			String sql = "update module_name set Grade  = " + "'" + value + "'"+ " where studentID  = " + stid + " AND '" + subject +"'";
			myStmt.executeUpdate(sql);
			print("Update complete");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	public static void print(String output) {
		System.out.println(output);
	}
}
