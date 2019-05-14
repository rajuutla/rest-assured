package com.uhg.selenium.practice;

/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.util.*;
public class CandidateCode {
    public static void main(String args[] ) throws Exception {
    	//Write code here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int i=0,j=0;
        String inputStr[] = new String[n];
        String sqMatrix[][] = new String[n][n];

        while (i < n){
            inputStr[i] = scan.next();
            i++;
        }

        String searchWord = scan.next();

        //System.out.println(n);
        
        for(String str : inputStr){
             String str1[] = str.split("#");
            for(i=0;i<n;i++){               
                for(j=0;j<n;j++){                    
                    System.out.println("ele = "+str1[j]);
                     sqMatrix[i][j] = str1[j];
                }
            }         
            
        }
        for(i=0;i<n;i++){
                for(j=0;j<n;j++){
                    System.out.print(sqMatrix[i][j]+" ");
                }
                System.out.print("\n");
            }

        //System.out.println(str);

         //System.out.println(searchWord);

   }
}

