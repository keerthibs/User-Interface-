/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uidesign;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static uidesign.FileOperations.cust;
import static uidesign.FileOperations.index;
import static uidesign.FileOperations.rowset;

/**
 *
 * @author Aastha
 */
//Function to read the contents of the file
public class ReadWrite {
        public void read(String filename) {

        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            try {
                while ((line = br.readLine()) != null) {

                    rowset = line.split("\t");

                    cust[index] = new Customer();

                    cust[index].setCustomer(rowset);

                    index++;

                }
            } catch (IOException ex) {
                Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            BufferedWriter bw1 = null;
            try {
                bw1 = new BufferedWriter(new FileWriter("repository.txt"));
                bw1.close();
            //    Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex1) {
                Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex1);
            } finally {
                try {
                    bw1.close();
                } catch (IOException ex1) {
                    Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
    }
    //Function to write the new or updated contents to the file
    public void Write(int localIndex) {
        try {
            BufferedWriter bw1 = new BufferedWriter(new FileWriter("repository.txt"));
            bw1.close();
            BufferedWriter bw = new BufferedWriter(new FileWriter("repository.txt", true));
            String arr[] = null;
            for (int m = 0; m < index; m++) {
                arr = cust[m].getCustomer();
                for (int k = 0; k < 12; k++) {
                    bw.write(arr[k]);
                    bw.write("\t");
                }
                //   bw.write(new SimpleDateFormat("MM/dd/yyyy").format(arr[11]).toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
