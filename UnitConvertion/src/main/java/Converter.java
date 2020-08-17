package main.java;

import java.util.Scanner;

public class Converter {

	public static void main(String[] args) {
		int menuSelection = 0;
		
		Scanner input = new Scanner(System.in);
		
		while(menuSelection !='4') {
			System.out.println("Please choose a conversion"
					+"\n1.Cups to Teaspoons"
					+ "\n2 Miles to Kilometeters"
					+"\n3 US Gallons to Imperial Gallons"
					+"\n4 Quit");
			menuSelection = input.nextInt();
			
			switch (menuSelection) {
	
			case 1: 
				int cup, teaspoons;
				System.out.println("Please give amount in cups.");
				cup = input.nextInt();
				teaspoons = cup*48;
				System.out.println( cup +" cups is equal to " +teaspoons+ " teaspoons. You have chose wisely...");
				return; 
				
			case 2:
				double miles, kilometer;
				System.out.println("Please give distance in miles.");
				miles = input.nextInt();
				kilometer = miles * 1.60934;
				System.out.println("There are " +kilometer+ " kilometers in " +miles+ " miles. Woah I wonder how long it would take if we took a hunk of junk?");
				return;
			
			case 3:
				double USGallon, ImpGallon;
				System.out.println("Please give amount in US gallons.");
				USGallon = input.nextInt();
				ImpGallon = USGallon * 0.832674;
				System.out.println(USGallon + " US gallons is equal to " +ImpGallon+ " Imperial gallons. God save the Queen!");
				return;
				
			case 4:
				System.out.println("You have chosen to quit.");
				return;
				
			default:
				System.out.println("That is the not the choice you are looking for.");
			}
			
			
			
			
		}

	
}
	}
	

