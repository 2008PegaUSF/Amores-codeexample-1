package test.java;


import static question8.PalindromeArray.hasPalindrome;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import question1.*;
import question2.*;
import question3.*;
import question4.*;
import question5.*;
import question6.*;
import question7.*;
import question8.*;
import question9.*;
import question_10.*;
import question_11.*;
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
		Assertions.assertTrue(Arrays.equals(expected, test));
	}
	
	@Test
	public void QuestTwo() {
		FiboNumbers fn = new FiboNumbers();
		int e = 46368;
		int fib = fn.printFiboNumbers(25);
		Assertions.assertTrue(fib == e);
	}
	
	@Test
	public void QuestThree() {
		RevString rs = new RevString();
		Scanner sc = new Scanner(System.in);
		char[] s = sc.nextLine().toCharArray();
		String x = new String(s);
		Assertions.assertTrue(rs.equals(x));
	}
	
	@Test
	public void QuestFour() {
			int q = 120;
			int w = Nfactorial.Nfactorial(5);
			Assertions.assertTrue(q == w);
	}
	
	@Test
	public void QuestFive() {
		String ss = SubString.SubString(7, "Successful");
		String o = "Success";
		Assertions.assertTrue(o.equals(ss));
	}
	
	@Test
	public void QuestSix(){
		EvenNum e = new EvenNum();
		Assertions.assertTrue(e.canEven(4) == true);
	}
	
	@Test
	public void QuestSeven() {
		ArrayList<Employee> Employee = new ArrayList<Employee>();
		Employee.add(new Employee("Han", "Chewie",23));
		ArrayList<Employee> newEmployee = new ArrayList<Employee>();
		newEmployee.add(new Employee("Obi-Wan","Anakin", 22));
		Assertions.assertFalse(Employee.equals(newEmployee));
	}
	
	@Test
	public void QuestEight() {
		ArrayList<String> c = hasPalindrome;
		ArrayList<String> t = new ArrayList<String>(Arrays.asList("madam","civic", "radar", "kayak","refer","did"));
		System.out.println(c);
		System.out.println(t);
		Assertions.assertTrue(t.equals(c));
	}
	
	@Test
	public void QuestNine() {
		ArrayList<Integer> c = ArrayPrimus.Primes;
		ArrayList<Integer> i = new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
		
		System.out.println(c);
		System.out.println(i);
		Assertions.assertTrue(c.equals(i));
	}
	
	@Test
	public void QuestTen() {
		MinNum mn = new MinNum();
		int a = mn.MinNum(5,10);
		int s = 5;
		Assertions.assertEquals(a,s);	
	}
	
	@Test
	public void QuestEleven() {
		float varT = 10.50f;
		theCalling tC = new theCalling();
		Class<? extends theCalling> varC = tC.getClass();
		Assertions.assertEquals(varT,varC);
	}
	
	@Test
	public void QuestTwleve() {
		EvenArray EA = new EvenArray();
		ArrayList<Integer> k = EA.evenArray();
		ArrayList<Integer> o = new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100));
		Assertions.assertTrue(k.equals(o));
	}
	
	@Test
	public void QuestThirteen(){
		halfTriangle ht = new halfTriangle();
		int q = ht.halfTriangle();
		int w = 0;
		Assertions.assertTrue(w == q);
	}
	
	@Test
	public void QuestFourteen() {
		caseSwitch cs = new caseSwitch();
		double s = cs.caseSwitch(1) ;
		double h = 8;
		Assertions.assertEquals(s,h);
	}
	
	@Test
	public void QuestFifteen() {
		InterfaceCalculator  iC = new InterfaceCalculator();
		double a = iC.add(2, 2);
		double w = 4;
		Assertions.assertEquals(a,w);
	}
	@Test
	public void QuestSixteen() {
		int u = Cmd.Cmd("Yo");
		int y = 2;
		Assertions.assertEquals(u,y);
	}
	@Test
	public void QuestSeventeen() {
		float a = 12;
		float principle = 100;
		float rate = (float) 1.2;
		float years = 10;
		float tot = InterestCalculator.Interest(principle, rate, years);
		Assertions.assertEquals(a, tot); 
	}
	@Test
	public void QuestEighteen() {
		AbstractSubClass sub = new AbstractSubClass();
		boolean str = sub.isUpperCase();
		Assertions.assertTrue(str);;
	}
	@Test
	public void QuestNinteen() {
		Assertions.assertTrue(EvenOdd.isPrime(2));
	}
	
	@Test
	public void QuestTwenty() throws IOException {
		ReadFile rf = new ReadFile();
		File file = null;
		Assertions.assertEquals(false, rf.ReadFile(file));
	}
	
	  
}
