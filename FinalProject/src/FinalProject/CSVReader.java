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
    
    
//    String csvFile = "E:\\PSA\\PSAFinalProject\\FinalProject_INFO6205Summer\\FinalProject\\src\\FinalProject\\"train.csv";
    
//    String csvTestFile = "E:\\PSA\\PSAFinalProject\\FinalProject_INFO6205Summer\\FinalProject\\src\\FinalProject\\train.csv";
    
    
    String line = "";
    String cvsSplitBy = ",";
    
    public InputData readFile(String type){
    	InputData inputdata = new InputData(null,null);
    	//List<String[]> lines = new ArrayList<String[]>();
        String csvFile = "E:\\PSA\\PSAFinalProject\\FinalProject_INFO6205Summer\\FinalProject\\src\\FinalProject\\"+type+".csv";
    	int rowSize=10001;
        if(type.equalsIgnoreCase("test"))
            rowSize=101;
        double [][] first = new double[rowSize][785];
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
         	String line = br.readLine();
                 int count = 0;
            while ((line = br.readLine()) != null) {

                    String [] a =line.split(",");
            	 for(int i=0;i<a.length;i++) {
            		 first[count][i]=Double.parseDouble(a[i]);
            	 }
                 count++;

            }

            double[][] b = new double[rowSize][1];
            double [][] c = new double[rowSize][785];
          
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
//        return null;
return inputdata;
    }
}
