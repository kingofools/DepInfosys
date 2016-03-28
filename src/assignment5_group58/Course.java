/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_group58;

/**
 *
 * @author kaustubh
 */
import java.util.ArrayList;
import java.io.Serializable;


public class Course implements Serializable
{
	private String coursename;
	private int credit = -1;
	private int grade = -1;//applicable for students only , not required for courselist
	private String status = "new";
	private String professor = "";
	public  ArrayList<String> StudentsOnRoll;
	        
	public void setname(String topic)
	{
		this.coursename = topic;
	};
	public String getname()
	{
		return coursename;
	};
	
	public void setcredit(int allot_credit)
	{
		this.credit = allot_credit;
	};
	public int getcredit()
	{
		return credit;
	};
	
	public void setgrade(int marks)
	{
		this.grade = marks;
	};
	public int getgrade()
	{
		return grade;
	};
	
        public void setstatus(String update)
	{
		this.status = update;
	};
	public String getstatus()
	{
		return status;
	};
        
	public void setprofessor(String faculty)
	{
		this.professor = faculty;
	};
	
	public String getprofessor()
	{
		return professor;
	};

}
