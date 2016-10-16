package org.libucr.course;

public class CourseException extends RuntimeException {
    public final ErrorCode code;

    public CourseException(ErrorCode code) {
        super(getErrorString(code.value()));
        this.code = code;
    }

    public enum ErrorCode {
        OK(0),
        INTERNAL(-100),
        CURL(-101),
        INVALID_ARG(-102),
        CONNECT(-103),
        SERVER(-104),
        RESPONSE(-105);

        private final int code;

        private ErrorCode(int code) {
            this.code = code;
        }

        public int value() {
            return code;
        }
    };

    public static String getErrorString(ErrorCode code) {
        return getErrorString(code.value());
    }

    public static native String getErrorString(int code);
}

