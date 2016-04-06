/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_group58;

import static assignment5_group58.StartGUI.BalField;
import static assignment5_group58.StartGUI.ExpField;
import static assignment5_group58.StartGUI.IncField;
import static assignment5_group58.StartGUI.netExpenditure;
import static assignment5_group58.StartGUI.netIncome;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author surya
 */
public class WriteTrans 
{
    public WriteTrans(ArrayList<Transaction> cashbook,String file)
    {
        try {
        	FileOutputStream fileOut = new FileOutputStream(file); 
        	ObjectOutputStream Output = new ObjectOutputStream(fileOut);
            
        	Output.writeObject(cashbook);

    		//JOptionPane.showMessageDialog(null, "saved successfully");

           // System.out.println("Stored in database"); 
            fileOut.close(); 
            Output.close();
        }
        catch (FileNotFoundException e) 
        { 
    		JOptionPane.showMessageDialog(null, "save error");

            //System.err.println("File not found");
        }
        catch (IOException e)
        {
    		JOptionPane.showMessageDialog(null, "saved error IO ");
    		throw new RuntimeException(e);

        	//System.err.println("Read or write failed");
        }
    }
}
