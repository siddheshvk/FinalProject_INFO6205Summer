/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import FinalProject.BaseClasses.InputData;

/**
 *
 * @author Siddhesh
 */
public class CSVReader {
    
    
    String csvFile = "/Users/MACBOOK/Downloads";
    String line = "";
    String cvsSplitBy = ",";
    
    public InputData readFile(String filename){
    	InputData inputdata = new InputData(null,null);
    	//List<String[]> lines = new ArrayList<String[]>();
    	double [][] first = new double[42000][785];
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
         	String line = br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
            //    String[] country = line.split(cvsSplitBy);

             //   System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
            	 String [] a =line.split(",");
            	 //System.out.println("length is "+a]);
            	 int count = 0;
            	 for(int i=0;i<a.length;i++) {
            		 first[count][i]=Double.parseDouble(a[i]);
            	 }
            	 count++;

            }
            
           // double[][] array = new double[lines.size()][0];
           // lines.toArray(array);
            
            
            double[][] b = new double[42000][785];
            double [][] c = new double[42000][785];
          
            for(int i=0;i<first.length;i++) {
            		b[i][0]= first[i][0];
            		
            }
            for(int i=0;i<first.length;i++) {
            	for(int j = 1;j<first[0].length;j++ )
        		c[i][j]= first[i][j];
        		
        }
           inputdata.setOutput(b);
           inputdata.setInputs(c);
            return inputdata;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
