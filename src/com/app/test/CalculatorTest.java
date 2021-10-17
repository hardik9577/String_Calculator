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
	    
	}



