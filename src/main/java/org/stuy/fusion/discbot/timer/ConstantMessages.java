package org.stuy.fusion.discbot.timer;

class ConstantMessages {
    private int targetDayPerm, targetHourPerm, targetMinutesPerm;
    private String userName = "";

    public ConstantMessages(String user, int day, int hour, int minutes) {
        userName = user;
        targetDayPerm = day % 7;
        targetHourPerm = hour % 24;
        targetMinutesPerm = minutes % 60;
    }

    public int getDay() {
        return targetDayPerm;
    }

    public int getHour() {
        return targetHourPerm;
    }

    public int getMinutes() {
        return targetMinutesPerm;
    }

    public String getTargetTime() {
        String dayString = "";
        if (targetDayPerm % 7 == 0) {
            dayString = "Sunday";
        } else if (targetDayPerm % 7 == 1) {
            dayString = "Monday";
        } else if (targetDayPerm % 7 == 2) {
            dayString = "Tuesday";
        } else if (targetDayPerm % 7 == 3) {
            dayString = "Wednesday";
        } else if (targetDayPerm % 7 == 4) {
            dayString = "Thursday";
        } else if (targetDayPerm % 7 == 5) {
            dayString = "Friday";
        } else if (targetDayPerm % 7 == 6) {
            dayString = "Saturday";
        }
        String zero = "";
        if (targetHourPerm < 10) {
            zero = "0";
        }
        return (dayString + ", " + targetHourPerm + ":" + zero + targetMinutesPerm);
    }

    public String getUserName() {
        return userName;
    }

}