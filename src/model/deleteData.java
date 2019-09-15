/*
 * Author: Cian O'Sullivan
 * Student number: R00160696
 * Objective: Database Project
 */
package model;

import java.sql.*;

public class deleteData {
	
	Statement myStmt;
	
	/**
	 * deletes data from db
	 * @param myStmt
	 */
	public deleteData(Statement myStmt) {
		this.myStmt = myStmt;
	}
	
	/**
	 * deltes students
	 * @param id
	 */
	public void deleteStudent(int id) {
		try {
			String sql = "delete from student where studentID = '" + id + "'";
			myStmt.executeUpdate(sql);
			System.out.print("Delete complete");
		}
		
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	/**
	 * deletes data from clas groups
	 * @param id
	 */
	public void deleteClassGroup(int id) {
		try {
			String sql = "delete from classgrouptable where classGroupID = '" + id + "'";
			myStmt.executeUpdate(sql);
			System.out.print("Delete complete");
		}
		
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
