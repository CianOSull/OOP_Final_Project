/*
 * Author: Cian O'Sullivan
 * Student number: R00160696
 * Objective: Database Project
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import controller.Name;

public class insertData {
	Statement myStmt;
	
	/**
	 * Inserts data in to the db
	 * @param myStmt
	 */
	public insertData(Statement myStmt) {
		this.myStmt = myStmt;
	}
	
	/**
	 * inserts student
	 * @param Fname
	 * @param Mname
	 * @param Lname
	 * @param e
	 * @param p
	 * @param date
	 * @param id
	 */
	public void insertStudent(String Fname, String Mname, String Lname, String e, int p, String date, int id) {
		String sql = ""; 
		// Sql statment code
		sql = "insert into student (studentID, Fname, Mname, Lname, email, phone, DOB)" 
				+ " values ("+ id + ", '"+Fname+"', '"+Mname+"', '"+Lname+"', '"+e+"', " + p +", '" + date + "')";
		try {
			myStmt.executeUpdate(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Insert complete");
	}
	
	/**
	 * inserets class group
	 * @param n
	 */
	public void insertClassGroup(int n) {
		String sql = ""; 
		// Sql statment code
		sql = "insert into classgrouptable (classGroupID)" + " values ('"+n+"')";
		try {
			myStmt.executeUpdate(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Insert complete");
	}
	
	/**
	 * inserts relation ship between student and class
	 * @param sid
	 * @param cid
	 */
	public void insertStudentInClass(int sid, int cid) {
		String sql = ""; 
		// Sql statment code
		sql = "insert into studentgroup (studentID, classGroupID)" + " values ("+sid+", "+cid+")";
		try {
			myStmt.executeUpdate(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Insert complete");
	}
}
