#include "org_libucr_course_CourseException.h"

#include "ucrcourse.h"

#define UNUSED(x)		((void)(x))

/*
 * Class:     org_libucr_course_CourseException
 * Method:    getErrorString
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_libucr_course_CourseException_getErrorString(
	JNIEnv *env, jclass klass, jint error)
{
	UNUSED(klass);
	return (*env)->NewStringUTF(env, ucrcourse_strerror(error));
}

