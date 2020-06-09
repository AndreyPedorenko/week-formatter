package com.pedorenko.formatter;

public class WeekFormatterStateMachine {

    private WeekFormatterStateMachineStatus status;

    public WeekFormatterStateMachine() {
        status = WeekFormatterStateMachineStatus.START;
    }

    public void noStreakDayAdded() {
        status = WeekFormatterStateMachineStatus.NO_STREAK;
    }

    public void streakDayAdded() {
        status = WeekFormatterStateMachineStatus.STREAK;
    }

    public boolean isStart() {
        return status.equals(WeekFormatterStateMachineStatus.START);
    }

    public boolean isStreak() {
        return status.equals(WeekFormatterStateMachineStatus.STREAK);
    }

    public boolean isNoStreak() {
        return status.equals(WeekFormatterStateMachineStatus.NO_STREAK);
    }
}
