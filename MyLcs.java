package main;

import java.io.*;
import java.util.*;


public class MyLcs {


	public static int fileStream(String inputFile, ArrayList<String> inputData)
	{
		
	
		String thisLine = null;
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
	         
	         while ((thisLine = br.readLine()) != null) {
	        	 inputData.add(thisLine);
	         }    
	         
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		int strandCounter = inputData.size();
        
		if(strandCounter == 0) //Return -1 code if file is empty
            return -1;
        else if((strandCounter % 2) == 0)  //Return 0 if there is an even number of DNA Strands
            return 0;
        else  //Return 1 if there is an odd number of DNA Strands
            return 1;
	}
	
	
	
	private static void Compute_LCS(String DNA1, String DNA2)
    {
        int DNA1_Length = DNA1.length();
        int DNA2_Length = DNA2.length();
        int[][] C = new int[DNA1_Length + 1][DNA2_Length + 1];

        for(int a = 0; a <= DNA1_Length; ++a)  //Build LCS table bottom-up
        {
            for(int b = 0; b <= DNA2_Length; ++b)
            {
                if(a == 0 || b == 0)
                    C[a][b] = 0;
                else if(DNA1.charAt(a - 1) == DNA2.charAt(b - 1))
                    C[a][b] = C[a - 1][b - 1] + 1;
                else
                    C[a][b] = Math.max(C[a - 1][b], C[a][b - 1]);
            }
        }


        int LCS_Value = C[DNA1_Length][DNA2_Length];  //Actual length value of resulting LCS
               
        StringBuffer sb = new StringBuffer();  //string buffer object

        int d = DNA1_Length;
        int e = DNA2_Length;
        while(d > 0 && e > 0)  //Derive the String output using the finished LCS table
        {
        	if (C[d][e] == C[d-1][e])	//can still go up in table without crossing bridge
        	{
        		d--;
        	}
        	else if (C[d][e] == C[d][e-1])	//can still go left in table without crossing bridge
        	{
        		e--;
        	}
        	else {		//cannot go up or left without using bridge
        		sb.append(DNA1.charAt(d-1)); //character at DNA1(d-l) == DNA2(e-1)
        		d--;
        		e--;
        	}
        		
        }
       
        //Output LCS info section
        System.out.println("-----------------------------------------------------");
        System.out.println("Original, Read-in DNA Strands:\n \t" + DNA1 + "\n \t" + DNA2 + "\nLCS is: " + sb.reverse().toString() + "\nLCS Length: " + LCS_Value);
    }
	
	
	
	public static void main(String[] args) throws IOException
	{
		try {
				
			  ArrayList<String> inputData = new ArrayList<>();  //create new array list
			  String inputFile = args[0];  //grab file name from command-line argument
	          
	          int fileStatus = fileStream(inputFile, inputData);  //Read from text file

	        
	          long start_time = System.nanoTime();  //Begin timing
	          if(fileStatus == -1)  //Case for empty file 
	          {
	              System.out.println("ERROR: Input File in Empty! Please add data and try again.");
	              System.exit(-1);
	          }
	          else if(fileStatus == 0)  //Case for even number of DNA Strands
	          {
	              for(int i = 0; i < inputData.size(); i += 2)
	              {
	                  Compute_LCS(inputData.get(i), inputData.get(i + 1));
	              }
	          }
	          else  //Case for odd number of DNA Strands (the last line will not be matched)
	          {
	              for(int i = 0; i < inputData.size() - 1; i += 2)
	              {
	                  Compute_LCS(inputData.get(i), inputData.get(i + 1));
	              }
	          }
	          long end_time = System.nanoTime();  //End timing

	          long elapsed_time = end_time - start_time;  //Compute timing

	          //Output timing section
	          System.out.print("-----------------------------------------------------");
	          System.out.println("\nRunning time: " + elapsed_time + "ns (" + (elapsed_time / 1000000) + "ms)");
	          System.out.print("-----------------------------------------------------");
	          
	          
	        
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.print("Error: Please enter a filename.");
		}
	
	
	}

}
