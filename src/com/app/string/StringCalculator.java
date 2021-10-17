package com.app.string;

public class StringCalculator {
	
    public int add(String input) {
        String[] numbers = input.split(",|\n|;");

        if (input.isEmpty()) {
            return 0;
        } else if (numbers.length > 1) {
            return getSum(numbers);
        }
        return stringToInt(input);
    }

    private int getSum(String[] numbers) {
        int sum = 0;
        for (String currentNumber:numbers) {
            if (stringToInt(currentNumber) > 1000) {
                continue;
            }
            sum += stringToInt(currentNumber);
        }
        System.out.println("Sum = "+sum);
        return sum;
    }

    private int stringToInt(String number) {
        int num = Integer.parseInt(number);
        if (num < 0) {
        	System.out.println(num);
            throw new IllegalArgumentException("Negative Not Allowed! ");
        } else {
            return num;
        }
    }

}
