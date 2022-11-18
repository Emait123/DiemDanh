package com.example.theodoiquatrinhhoc;

import java.util.Date;

public class Subject {
    private int subjectCode;
    private String subjectName;
    private Date startDate;
    private Date endDate;
    private String schedule;

    public Subject(int subjectCode, String subjectName, Date startDate, Date endDate, String schedule) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.schedule = schedule;
    }

    public int getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(int subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
