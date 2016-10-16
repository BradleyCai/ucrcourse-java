package org.libucr.course;

public class Course {
    private final String courseNumber;
    private final short section;
    private final int callNumber;
    private final String courseTitle;
    private final String instructor;
    private final ClassType type;
    private final boolean[] days;
    private final CourseDate finalExam;
    private final String coreqs;
    private final String prereqs;
    private final String scheduleNotes;
    private final String gradeType;
    private final String catalogDescription;

    protected Course(String courseNumber, short section, int callNumber, String courseTitle,
            String instructor, ClassType type, boolean[] days, CourseDate finalExam,
            String coreqs, String prereqs, String scheduleNotes, String gradeType,
            String catalogDescription) {
        this.courseNumber = courseNumber;
        this.section = section;
        this.callNumber = callNumber;
        this.courseTitle = courseTitle;
        this.instructor = instructor;
        this.type = type;
        this.days = days;
        this.finalExam = finalExam;
        this.coreqs = coreqs;
        this.prereqs = prereqs;
        this.scheduleNotes = scheduleNotes;
        this.gradeType = gradeType;
        this.catalogDescription = catalogDescription;
    }

    public static class Builder {
        private String courseNumber;
        private short section;
        private short callNumber;
        private String courseTitle;
        private String instructor;
        private ClassType type;
        private boolean[] days;
        private CourseDate finalExam;
        private String coreqs;
        private String prereqs;
        private String scheduleNotes;
        private String gradeType;
        private String catalogDescription;

        public Builder() {
            courseTitle = "";
            instructor = "";
            days = new boolean[Day.values().length];
            coreqs = "";
            prereqs = "";
            scheduleNotes = "";
            gradeType = "";
            catalogDescription = "";
        }

        public Course build() {
            return new Course(courseNumber, section, callNumber, courseTitle,
                    instructor, type, days, finalExam, coreqs, prereqs,
                    scheduleNotes, gradeType, catalogDescription);
        }

        public Builder setCourseNumber(String courseNumber) {
            if (courseNumber == null) {
                throw new IllegalArgumentException("Course number may not be null.");
            }

            this.courseNumber = courseNumber;
            return this;
        }

        public Builder setSection(short section) {
            if (section < 0) {
                throw new IllegalArgumentException("The section number may not be negative.");
            }

            this.section = section;
            return this;
        }

        public Builder setCourseTitle(String courseTitle) {
            if (courseTitle == null) {
                throw new IllegalArgumentException("Course title may not be null.");
            }

            this.courseTitle = courseTitle;
            return this;
        }

        public Builder setInstructor(String instructor) {
            if (instructor == null) {
                throw new IllegalArgumentException("Instructor may not be null.");
            }

            this.instructor = instructor;
            return this;
        }

        public Builder setClassType(ClassType type) {
            if (type == null) {
                throw new IllegalArgumentException("Class type may not be null.");
            }

            this.type = type;
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

        public Builder setFinalExam(CourseDate finalExam) {
            if (finalExam == null) {
                throw new IllegalArgumentException("Date may not be null.");
            }

            this.finalExam = finalExam;
            return this;
        }

        public Builder setCorequisiteString(String coreqs) {
            if (coreqs == null) {
                throw new IllegalArgumentException("String may not be null.");
            }

            this.coreqs = coreqs;
            return this;
        }

        public Builder setPrerequisiteString(String prereqs) {
            if (prereqs == null) {
                throw new IllegalArgumentException("String may not be null.");
            }

            this.prereqs = prereqs;
            return this;
        }

        public Builder setScheduleNotes(String notes) {
            if (notes == null) {
                throw new IllegalArgumentException("String may not be null.");
            }

            this.scheduleNotes = notes;
            return this;
        }

        public Builder setGradeType(String gradeType) {
            if (gradeType == null) {
                throw new IllegalArgumentException("String may not be null.");
            }

            this.gradeType = gradeType;
            return this;
        }

        public Builder setCatalogDescription(String description) {
            if (description == null) {
                throw new IllegalArgumentException("String may not be null.");
            }

            this.catalogDescription = description;
            return this;
        }
    }
}

