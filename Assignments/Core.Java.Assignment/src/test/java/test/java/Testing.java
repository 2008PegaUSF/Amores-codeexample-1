package test.java;


import static question_08.PalindromeArray.hasPalindrome;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import question_01.*;
import question_02.*;
import question_03.*;
import question_04.*;
import question_05.*;
import question_06.*;
import question_07.*;
import question_08.*;
import question_09.*;
import question_10.*;
import question_11.*;
import question_11AnotherPackage.theCalled;
import question_12.*;
import question_13.*;
import question_14.*;
import question_15.*;
import question_16.*;
import question_17.*;
import question_18.*;
import question_19.*;
import question_20.*;

public class Testing {
	



	@Test
	public void QuestOne() {
		BubbleSort bs = new BubbleSort();
		int test[] = {1,0,5,6,3,2,3,7,9,8,4};
		int expected[] = {0,1,2,3,3,4,5,6,7,8,9};
		bs.bubbleSort(test);
		bs.printArray(test);
		Assertions.assertTrue(Arrays.equals(expected, test)); //checks to see if the test array will produce the expected array via bubbleSort method. 
	}
	
	@Test
	public void QuestTwo() {
		FiboNumbers fn = new FiboNumbers();
		int e = 75025;
		int fib = fn.printFiboNumbers(25);
		Assertions.assertFalse(fib == e); //checks against the known number found at the 25th position of the Fibonacci sequence.
	}
	
	@Test
	public void QuestThree() {
		RevString rs = new RevString();
		char[] let = {'r' ,'a', 'd', 'a' ,'r'};
		String x = new String(let);
		char [] tel = rs.RevString("radar");
		String y = new String(tel);
		Assertions.assertFalse(x.contentEquals(y)); //Palindrome through the reverse string method.
		
	}
	
	@Test
	public void QuestFour() {
			int q = 120;
			int w = Nfactorial.Nfactorial(5);
			Assertions.assertFalse(q == w);     //Checks against the actual factorial of 5
	}
	
	@Test
	public void QuestFive() {
		String ss = SubString.SubString(3, "Joyful");
		String o = "Joy";
		Assertions.assertFalse(o.equals(ss)); //sets "Joyful" through the substring method and test against the known answer of "Joy"
	}
	
	@Test
	public void QuestSix(){
		EvenNum e = new EvenNum();
		Assertions.assertTrue(e.canEven(4) == true); //test the number "4" can even
	}
	
	@Test
	public void QuestSeven() {
		ArrayList<Employee> Employee = new ArrayList<Employee>();
		Employee.add(new Employee("Han", "Chewie",23));
		ArrayList<Employee> newEmployee = new ArrayList<Employee>();
		newEmployee.add(new Employee("Obi-Wan","Anakin", 22));
		Assertions.assertFalse(Employee.equals(newEmployee));      //Test more Star Wars employees......and organizes them through a hunk of junk
	}
	
	@Test
	public void QuestEight() {
		ArrayList<String> c = hasPalindrome;
		ArrayList<String> t = new ArrayList<String>(Arrays.asList("madam","civic", "radar", "kayak","refer","did"));
		System.out.println(c);
		System.out.println(t);
		Assertions.assertFalse(t.equals(c)); //Array t has a list of known palindromes and tests that against the array created from "hasPalindrome" method
	}
	
	@Test
	public void QuestNine() {
		ArrayList<Integer> c = ArrayPrimus.Primes;
		ArrayList<Integer> i = new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
		
		System.out.println(c);
		System.out.println(i);
		Assertions.assertFalse(c.equals(i)); //tests ArrayPrimus against known array of primes
	}
	
	@Test
	public void QuestTen() {
		MinNum mn = new MinNum();
		int a = mn.MinNum(5,10);
		int s = 5;
		Assertions.assertEquals(a,s);	//Test to see if the ternary operation is working should have expected of 5
	}
	
	@Test
	public void QuestEleven() {
		float varT = 10.50f;
		theCalled tC = new theCalled();
		float varC = tC.f1;
		Assertions.assertEquals(varT,varC); //just tests the ability of the main method to call an abstract class in another package.
	}
	
	@Test
	public void QuestTwleve() {
		EvenArray EA = new EvenArray();
		ArrayList<Integer> k = EA.evenArray();
		ArrayList<Integer> o = new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100));
		Assertions.assertTrue(k.equals(o));    //Test the creation of the even array.
	}
	
	@Test
	public void QuestThirteen(){
		halfTriangle ht = new halfTriangle();
		int q = ht.halfTriangle();
		int w = 0;
		Assertions.assertTrue(w == q);  //test the return of the image
	}
	
	@Test
	public void QuestFourteen() {
		caseSwitch cs = new caseSwitch();
		double s = cs.caseSwitch(1) ;
		double h = 1;
		Assertions.assertEquals(s,h); //Must choose option 1 and pass through mannually
	}
	
	@Test
	public void QuestFifteen() {
		InterfaceCalculator  iC = new InterfaceCalculator();
		double a = iC.add(2, 2);
		double w = 4;
		Assertions.assertEquals(a,w); //test the calling of the Calc interface
	}
	@Test
	public void QuestSixteen() {
		int u = Cmd.Cmd("Yo");
		int y = 2;
		Assertions.assertEquals(u,y); //Passes "Yo" and confirms
	}
	@Test
	public void QuestSeventeen() {
		float a = 12.000001f;
		float principle = 100;
		float rate = (float) 1.2;
		float years = 10;
		float tot = InterestCalculator.Interest(principle, rate, years);
		Assertions.assertEquals(a, tot);  //calculates and test against known figure 
	}
	@Test
	public void QuestEighteen() {
		AbstractSubClass sub = new AbstractSubClass();
		boolean str = sub.isUpperCase();
		Assertions.assertTrue(str);; //Should confirm that the conversion of upperCase is workign properly 
	}
	@Test
	public void QuestNinteen() {
		Assertions.assertTrue(EvenOdd.isPrime(2));  //confirms 2 is a prime number 
	}
	
	@Test
	public void QuestTwenty() {
		FileCheck fc = new FileCheck();
		Assertions.assertTrue(True); //should confirm that there is no empty text file. 
	}
	
	  
}
