package com.pedorenko;

import com.pedorenko.formatter.WeekFormatter;

public class App {

    public static void main(String[] args) {

        String numberStr = args[0];
        //convert it to Integer to match task requirements
        int number = Integer.parseInt(numberStr);

        String formattedNumber = WeekFormatter.formatWeek(number);

        System.out.println(formattedNumber);
    }
}
