package com.pedorenko.validator;

import com.pedorenko.exception.ValidationException;

public class WeekValidator {

    public static void validateDaysString(String daysString) {
        for (int i = 0; i < daysString.length(); ++i) {
            char day = daysString.charAt(i);
            validateDay(day);
        }
    }

    public static void validateDay(char day) {
        if (day < '1' || day > '7') {
            throw new ValidationException("Unexpected value of day \'" + day + "\'. Should be a number between 1 and 7");
        }
    }
}
