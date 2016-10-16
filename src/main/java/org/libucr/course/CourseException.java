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

        public static ErrorCode getError(int code) {
            switch (code) {
                case 0:
                    return OK;
                case -100:
                    return INTERNAL;
                case -101:
                    return CURL;
                case -102:
                    return INVALID_ARG;
                case -103:
                    return CONNECT;
                case -104:
                    return SERVER;
                case -105:
                    return RESPONSE;
                default:
                    return null;
            }
        }

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

