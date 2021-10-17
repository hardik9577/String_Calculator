package com.app.string;

public class StringCalculator {
	
    public int add(String input) {
        String[] numbersArr = input.split(",|\n|;|[*]|[%]");

        if (input.isEmpty()) {
            return 0;
        } else if (numbersArr.length > 1) {
            return sum(numbersArr);
        }
        return stringToInt(input);
    }

    private int sum(String[] numbersArr) {
        int ans = 0;
        for (String currentNumber:numbersArr) {
            if (stringToInt(currentNumber) > 1000) {
                continue;
            }
            ans += stringToInt(currentNumber);
        }
        System.out.println("Sum = "+ans);
        return ans;
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
