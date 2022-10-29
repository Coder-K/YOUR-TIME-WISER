package com.example.ytw;

public class TimeTable {

    private String Course , Venue;
    private int Time;

    public TimeTable(String course, String venue, int time) {
        Course = course;
        Venue = venue;
        Time = time;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        Time = time;
    }
}
