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


public class Student 
{
	private String name; 
	private String address;
	private String phone;
	private String mail;
	private int roll;
        private int prevCredits;
        public  ArrayList<Course> subjects = new ArrayList<Course>();
      	public  ArrayList<Double> sgpa = new ArrayList<Double>();
        public  ArrayList<Double> cgpa = new ArrayList<Double>();
        
	public void setname(String naam)
	{
		this.name = naam;
	};
	public String getname()
	{
		return name;
	};
	public void setplace(String location)
	{
		this.address = location;
	};
	public String getplace()
	{
		return address;
	};
	
	public void setnumber(String num)
	{
		this.phone = num;
	};
	public String getnumber()
	{
		return phone;
	};
        
	public void setmail(String mail)
	{
		this.mail = mail;
	};
	public String getmail()
	{
		return mail;
	};
        
	public void setroll(int regnum)
	{
		this.roll = regnum;
	};
	public int getroll()
	{
		return roll;
	};
        
        public void setprevCredits(int totalCredits)
	{
		this.prevCredits = totalCredits;
	};
	public int getprevCredits()
	{
		return prevCredits;
	};
	
        public boolean AllGraded()
        {
            int i;
            for(i = 0; i < subjects.size();i++)
            {
                if(subjects.get(i).getstatus().equals("current"))//check for each current course
                {
                    if(subjects.get(i).getgrade()==-1)//if any current course is not graded
                    {
                        return false;
                    }
                }
            }
            return true;
        };
        
        public boolean isClear(String Subject)
        {
            int i;
            for(i = 0; i < subjects.size();i++)
            {
                if(subjects.get(i).getname().equals(Subject))//check for each course
                {
                    if(subjects.get(i).getgrade()<5)//if course found , has insufficient grade
                    {
                        return false;// assuming grade below 5 is fail
                        //may need to check this at a later stage
                    }
                }
            }
            return true;
        }
  
}
