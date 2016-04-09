/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_group58;

import static assignment5_group58.StartGUI.viewStudent;
import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kaustubh
 */
@SuppressWarnings("serial")
public class PrintStudentGUI extends javax.swing.JFrame {

    /**
     * Creates new form PrintStudentGUI
     * @param viewStudent
     */
    public PrintStudentGUI(Student viewStudent) {
        newinitComponents(viewStudent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    /*@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NameLabel = new javax.swing.JLabel();
        RollField = new javax.swing.JLabel();
        CGField = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DetailsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Name");

        NameLabel.setText("Name : ");

        RollField.setText("Roll : ");

        CGField.setText("CGPA : ");

        SaveButton.setText("Save as file");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        DetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Semester", "Course", "Grade", "status", "CGPA", "SGPA"
            }
        ));
        jScrollPane1.setViewportView(DetailsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RollField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CGField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RollField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CGField)
                    .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
 */ private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt, Student viewStudent) {     
        JOptionPane.showMessageDialog(null,"Starting up printwriter");
        String filename = "stud_"+viewStudent.getroll()+"_"
                + "semno_"+viewStudent.semSize.size()+".txt";
        //BufferedWriter writer = null;
    try {
        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        writer.println("Student Name: " + viewStudent.getname());
        writer.println("Roll number : "+viewStudent.getroll());
        writer.println("Phone number : "+viewStudent.getnumber());
        writer.println("Email Address : "+viewStudent.getmail());
        writer.println("Address : "+viewStudent.getplace());   
        writer.println("Current CGPA: "+viewStudent.cgpa.get(viewStudent.cgpa.size()-1));
        writer.println("----------------------------------------------------");
        Object[][] Details = new String[viewStudent.subjects.size()][6];
        j = 0;isfirst = false;
        for(int i = 0 ; i < viewStudent.subjects.size() ; i++){  
            if(j >=viewStudent.semSize.size()){
                if(!isfirst){
                    isfirst = true;
                }  
            }else if(i== viewStudent.semSize.get(j)){
                int k = j+1;
                writer.println("Sem no: "+k+"\tSGPA: "+viewStudent.sgpa.get(j+1)+"\tCGPA: "+viewStudent.cgpa.get(j+1));
                isfirst = true;
                j++;
            }else{
            
            }
            
            writer.println("Subject: "+viewStudent.subjects.get(i).getname()+"\tGrade: "+Integer.toString(viewStudent.grades.get(i)) + "\tStatus: " +viewStudent.status.get(i));
            
        }  
        
        writer.close();
        JOptionPane.showMessageDialog(null,"Student no."+viewStudent.getroll() + " data stored in file "+ filename);
    } catch (FileNotFoundException e){
           // System.err.println("File not found");
            try{
                File f = new File(filename);
                JOptionPane.showMessageDialog(null, "student FILE CREATED successfully");
                boolean bool = false;
                bool = f.createNewFile();
                while(bool==false)
                {
                	f.delete();
                	bool = f.createNewFile();
                }
             }catch(HeadlessException | IOException ex){
             }
        } catch (IOException ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }/* finally {
        if (writer != null) {
            writer.close();
        }
    }*/
    }//GEN-LAST:event_SaveButtonActionPerformed

    static int j = 0;
    static boolean isfirst = false;
        private void newinitComponents(Student viewStudent) {
            
        //JOptionPane.showMessageDialog(null,"You chose "+viewStudent.getname());
        NameLabel = new javax.swing.JLabel();
        RollField = new javax.swing.JLabel();
        CGField = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DetailsTable = new javax.swing.JTable();
               
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(viewStudent.getname());

        NameLabel.setText("Name : "+viewStudent.getname());

        
        RollField.setText("Roll : "+viewStudent.getroll());

        CGField.setText("CGPA : "+viewStudent.cg);

        SaveButton.setText("Save as file");

        //JOptionPane.showMessageDialog(null,"Bwahahahah");
        Object[][] Details = new String[viewStudent.subjects.size()][6];
        j = 0;isfirst = false;
        for(int i = 0 ; i < viewStudent.subjects.size() ; i++)
        {  
            if(j >=viewStudent.semSize.size())
            {
                if(!isfirst)
                {
                    isfirst = true;
                    Details[i][0] = Integer.toString(j);
                    Details[i][4] = "";
                    Details[i][5] = "";
                }  
            }
            else if(i== viewStudent.semSize.get(j))
            {
                isfirst = true;
                j++;
                if(j >=viewStudent.semSize.size())
                {
                    Details[i][0] = Integer.toString(j);
                    Details[i][4] = "-";
                    Details[i][5] = Double.toString(viewStudent.cg);  
                }
                else
                {
                    Details[i][0] = Integer.toString(j);
                    Details[i][4] = Double.toString(viewStudent.sgpa.get(j));
                    Details[i][5] = Double.toString(viewStudent.cgpa.get(j));
                }
            }
            else
            {
                Details[i][0] = "";
                Details[i][4] = "";
                Details[i][5] = "";
            }
            
            Details[i][1] = viewStudent.subjects.get(i).getname();
            Details[i][2] = Integer.toString(viewStudent.grades.get(i));
            Details[i][3] = viewStudent.status.get(i);
        }
        
        SaveButton.setText("Save as file");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //viewStudent = viewStudent;
                SaveButtonActionPerformed(evt, viewStudent);
            }
        });

        DetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            Details,
            new String [] {
                "Semester", "Course", "Grade", "Status", "SGPA", "CGPA"
            }
        ));
        jScrollPane1.setViewportView(DetailsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RollField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CGField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RollField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CGField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintStudentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PrintStudentGUI(viewStudent).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CGField;
    private javax.swing.JTable DetailsTable;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel RollField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
