package com.app.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.app.string.StringCalculator;

import static org.junit.Assert.assertEquals;



public class CalculatorTest {
	
	

	    private StringCalculator calculator;

	    @Rule
	    public ExpectedException thrown = ExpectedException.none();

	    @Before
	    public void initialize() {
	        calculator = new StringCalculator();
	    }

	    //Empty String Should Return 0
	    @Test
	    public void test1_1() {
	        assertEquals(calculator.add(""), 0);
	    }
	    
	    //String Should Return Same Number
	    @Test
	    public void test1_2() {
	        assertEquals(calculator.add("1"), 1);
	        assertEquals(calculator.add("2"), 2);
	    }
	    
	    // , Delimited Should Be Added and 
	    @Test
	    public void test1_3() {
	        assertEquals(calculator.add("1,2"), 3);
	    }
	    
	    // Add method to handle an unknown amount of numbers
	    @Test
	    public void test2() {
	        assertEquals(calculator.add("1,2"), 3);
	        assertEquals(calculator.add("1,2,3"), 6);
	        assertEquals(calculator.add("1,2,3,4"), 10);
	    }
	    
	    //Add method to handle new lines between numbers (instead of commas)
	    @Test
	    public void test3() {
	        assertEquals(calculator.add("1\n2"), 3);
	        assertEquals(calculator.add("1\n2\n3"), 6);
	    }
	    
	    //Support different delimiters
	    @Test
	    public void test4() {
	        assertEquals(calculator.add("1,2,3"), 6);
	        assertEquals(calculator.add("1\n2\n3\n4"), 10);
	        assertEquals(calculator.add("1;2;3;4"), 10);
	    }
	    
	    //Add with a negative number will throw an exception “negatives not allowed” -
	    //and the negative that was passed. 
	    @Test
	    public void test5() {
	        thrown.expect(IllegalArgumentException.class);
	        thrown.expectMessage("Negative Not Allowed!");
	        calculator.add("-1");
	    }
	    
	    //If there are multiple negatives, show all of them in the exception message
	    @Test
	    public void test6() {
	        thrown.expect(IllegalArgumentException.class);
	        thrown.expectMessage("Negative Not Allowed!");
	        calculator.add("1\n-2,-3");
	    }
	    
	    //Numbers bigger than 1000 should be ignored
	    @Test
	    public void test9() {
	        assertEquals(calculator.add("2,1001"), 2);
	    }
	    
	    //. Allow multiple delimiters like this: 
	    //“//[delim1][delim2]\n” 
	   // for example 
	   // “//[*][%]\n1*2%3” == 6
	    @Test
	    public void test11() {
	        assertEquals(calculator.add("1;2\n3*4%5"), 15);
	    }
	}



