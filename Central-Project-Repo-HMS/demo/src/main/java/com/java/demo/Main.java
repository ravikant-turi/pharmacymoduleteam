package com.java.demo;



public class Main {
	public static void main(String[] args) {
		  try {
	            int a=5;
	            int b=4;
	            int c=a/b;
	            System.out.println("Hi");
	        }
		  catch (Exception e) {
			  System.out.println("Error");
		  }
		  catch(ArithmeticException e) {
			  System.out.println("Divex");}
		   finally {
	            System.out.println("Program End...");
	        }
	}    
}