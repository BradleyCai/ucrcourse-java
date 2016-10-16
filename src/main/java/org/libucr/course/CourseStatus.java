package org.libucr.course;

public enum CourseStatus {
    OPEN(1),
    CLOSED(2),
    CANCELLED(3);

    private final int code;

    private CourseStatus(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
};

