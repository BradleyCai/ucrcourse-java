package org.libucr.course;

public class CourseQuery {
    private final Quarter quarter;
    private final short year;
    private final SubjectArea subjectArea;
    private final String courseTitle;
    private final String instructor;
    private final String courseNumber;
    private final short startHour;
    private final CourseStatus status;
    private final CourseRange range;
    private final ClassType type;
    private final CourseLocation location;
    private final BreadthCourse breadth;
    private final boolean graduateQuantitative;
    private final boolean[] days;

    protected CourseQuery(Quarter quarter, short year, SubjectArea subjectArea, String courseTitle,
            String instructor, String courseNumber, short startHour, CourseStatus status,
            CourseRange range, ClassType type, CourseLocation location, BreadthCourse breadth,
            boolean graduateQuantitative, boolean[] days) {
        this.quarter = quarter;
        this.year = year;
        this.subjectArea = subjectArea;
        this.courseTitle = courseTitle;
        this.instructor = instructor;
        this.courseNumber = courseNumber;
        this.startHour = startHour;
        this.status = status;
        this.range = range;
        this.type = type;
        this.location = location;
        this.breadth = breadth;
        this.graduateQuantitative = graduateQuantitative;
        this.days = days;
    }

    public Quarter getQuarter() {
        return quarter;
    }

    public short getYear() {
        return year;
    }

    public SubjectArea getSubjectArea() {
        return subjectArea;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public short getStartHour() {
        return startHour;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public CourseRange getRange() {
        return range;
    }

    public ClassType getType() {
        return type;
    }

    public CourseLocation getLocation() {
        return location;
    }

    public BreadthCourse getBreadth() {
        return breadth;
    }

    public boolean getGraduateQuantitative() {
        return graduateQuantitative;
    }

    public boolean hasDay(Day day) {
        return days[day.ordinal()];
    }

    public Course[] run() {
        return runQueryInternal(
                quarter.ordinal(),
                year,
                subjectArea.ordinal(),
                courseTitle,
                instructor,
                courseNumber,
                startHour,
                status.ordinal(),
                range.ordinal(),
                type.ordinal(),
                location.ordinal(),
                breadth.ordinal(),
                graduateQuantitative,
                days);
    }

    private native Course[] runQueryInternal(int quarter, short year, int subjectArea,
            String courseTitle, String instructor, String courseNumber, short startHour,
            int courseStatus, int courseRange, int classType, int courseLocation,
            int breadthCourse, boolean graduateQuantitative, boolean[] days);

    public static class Builder {
        private Quarter quarter;
        private short year;
        private SubjectArea subjectArea;
        private String courseTitle;
        private String instructor;
        private String courseNumber;
        private short startHour;
        private CourseStatus status;
        private CourseRange range;
        private ClassType type;
        private CourseLocation location;
        private BreadthCourse breadth;
        private boolean graduateQuantitative;
        private boolean[] days;

        public Builder() {
            setDefaultTerm();
            subjectArea = SubjectArea.NONE;
            courseTitle = "";
            instructor = "";
            courseNumber = "";
            status = CourseStatus.OPEN;
            range = CourseRange.NONE;
            type = ClassType.NONE;
            location = CourseLocation.NONE;
            breadth = BreadthCourse.NONE;
            days = new boolean[Day.values().length];
        }

        public CourseQuery build() {
            return new CourseQuery(quarter, year, subjectArea, courseTitle, instructor,
                    courseNumber, startHour, status, range, type, location, breadth,
                    graduateQuantitative, days);
        }

        public Builder setQuarter(Quarter quarter) {
            if (quarter == null) {
                throw new IllegalArgumentException("Quarter cannot be null.");
            }

            this.quarter = quarter;
            return this;
        }

        public Builder setYear(int year) {
            if (year < 1999) {
                throw new IllegalArgumentException("Year must be 1999 or later.");
            }

            this.year = (short)year;
            return this;
        }

        public Builder setSubjectArea(SubjectArea subjectArea) {
            if (subjectArea == null) {
                throw new IllegalArgumentException("Subject area cannot be null.");
            }

            this.subjectArea = subjectArea;
            return this;
        }

        public Builder setCourseTitle(String courseTitle) {
            if (courseTitle == null) {
                throw new IllegalArgumentException("Course title cannot be null.");
            }

            this.courseTitle = courseTitle;
            return this;
        }

        public Builder setInstructor(String instructor) {
            if (instructor == null) {
                throw new IllegalArgumentException("Instructor cannot be null.");
            }

            this.instructor = instructor;
            return this;
        }

        public Builder setCourseNumber(String courseNumber) {
            if (courseNumber == null) {
                throw new IllegalArgumentException("Course number string cannot be null.");
            }

            this.courseNumber = courseNumber;
            return this;
        }

        public Builder setStartHour(short startHour) {
            if (0 > startHour || startHour > 23) {
                throw new IllegalArgumentException("Start hour must be between 0 and 23 inclusive.");
            }

            this.startHour = startHour;
            return this;
        }

        public Builder setCourseStatus(CourseStatus status) {
            if (status == null) {
                throw new IllegalArgumentException("Course status cannot be null.");
            }

            this.status = status;
            return this;
        }

        public Builder setCourseRange(CourseRange range) {
            if (range == null) {
                throw new IllegalArgumentException("Course range cannot be null.");
            }

            this.range = range;
            return this;
        }

        public Builder setClassType(ClassType type) {
            if (type == null) {
                throw new IllegalArgumentException("Class type cannot be null.");
            }

            this.type = type;
            return this;
        }

        public Builder setLocation(CourseLocation location) {
            if (type == null) {
                throw new IllegalArgumentException("Course location cannot be null.");
            }

            this.location = location;
            return this;
        }

        public Builder setBreadth(BreadthCourse breadth) {
            if (breadth == null) {
                throw new IllegalArgumentException("Breadth course value cannot be null.");
            }

            this.breadth = breadth;
            return this;
        }

        public Builder setGraduateQuantitative(boolean value) {
            graduateQuantitative = value;
            return this;
        }

        public Builder setDay(Day day, boolean value) {
            days[day.ordinal()] = value;
            return this;
        }

        public Builder setDay(Day day) {
            days[day.ordinal()] = true;
            return this;
        }

        private native void setDefaultTerm();
    };
}

