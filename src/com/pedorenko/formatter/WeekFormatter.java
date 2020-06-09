package com.pedorenko.formatter;

import com.pedorenko.validator.WeekValidator;
import java.util.TreeSet;

public class WeekFormatter {

    public static String formatWeek(int number) {

        String daysString = String.valueOf(number);

        WeekValidator.validateDaysString(daysString);

        TreeSet<Character> treeSet = new TreeSet<>();
        for (int i = 0; i < daysString.length(); ++i) {
            char day = daysString.charAt(i);
            treeSet.add(day);
        }

        WeekFormatterStateMachine stateMachine = new WeekFormatterStateMachine();
        char prevDay = '1' - 2;
        StringBuilder result = new StringBuilder();
        for (Character day : treeSet) {

            if (stateMachine.isStart()) {

                result.append(day);
                stateMachine.noStreakDayAdded();

            } else if (day - prevDay == 1) {

                stateMachine.streakDayAdded();

            } else if (day - prevDay > 1) {

                if (stateMachine.isStreak()) {

                    result.append('-').append(prevDay);
                }

                result.append(',').append(day);
                stateMachine.noStreakDayAdded();
            }

            prevDay = day;
        }

        if (stateMachine.isStreak()) {
            result.append('-').append(prevDay);
        }

        return result.toString();
    }
}
