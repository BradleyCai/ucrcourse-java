package org.libucr.course;

public class CourseDate {
    private final byte month, day;
    private final short year;
    private final byte startHour, startMinute;
    private final byte endHour, endMinute;

    public CourseDate(int month, int day, int year,
            int startHour, int startMinute,
            int endHour, int endMinute) {
        this.month = (byte)month;
        this.day = (byte)day;
        this.year = (short)year;
        this.startHour = (byte)startHour;
        this.startMinute = (byte)startMinute;
        this.endHour = (byte)endHour;
        this.endMinute = (byte)endMinute;
    }

    public byte getMonth() {
        return month;
    }

    public byte getDay() {
        return day;
    }

    public short getYear() {
        return year;
    }

    public byte getStartHour() {
        return startHour;
    }

    public byte getStartMinute() {
        return startMinute;
    }

    public byte getEndHour() {
        return endHour;
    }

    public byte getEndMinute() {
        return endMinute;
    }

    public int getDurationMinutes() {
        return (endHour - startHour) * 3600 + (endMinute - startMinute);
    }
}

