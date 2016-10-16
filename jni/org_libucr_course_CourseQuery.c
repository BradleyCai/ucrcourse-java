#include <stdlib.h>

#include "org_libucr_course_CourseQuery.h"

#include "ucrcourse.h"

#define UNUSED(x)			((void)(x))

static jobject get_quarter_enum(JNIEnv *env, enum quarter quarter)
{
	const char *field_name;
	jclass klass;
	jfieldID fid;

	switch (quarter) {
	case FALL_QUARTER:
		field_name = "FALL";
		break;
	case WINTER_QUARTER:
		field_name = "WINTER";
		break;
	case SPRING_QUARTER:
		field_name = "SPRING";
		break;
	case SUMMER_QUARTER:
		field_name = "SUMMER";
		break;
	default:
		return NULL;
	}

	klass = (*env)->FindClass(env, "Lorg/libucr/course/Quarter;");
	fid = (*env)->GetFieldID(env, klass, field_name, "Lorg/libucr/course/Quarter;");
	return (*env)->GetObjectField(env, klass, fid);
}

/*
 * Class:     org_libucr_course_CourseQuery_Builder
 * Method:    setDefaultTerm
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_libucr_course_CourseQuery_00024Builder_setDefaultTerm(
	JNIEnv *env, jobject self)
{
	struct course_query query;
	jclass klass;
	jfieldID fid;

	ucrcourse_query_init(&query);

	klass = (*env)->GetObjectClass(env, self);

	fid = (*env)->GetFieldID(env, klass, "quarter", "Lorg/libucr/course/Quarter;");
	if (!fid) return;
	(*env)->SetObjectField(env, self, fid, get_quarter_enum(env, query.quarter));

	fid = (*env)->GetFieldID(env, klass, "year", "S");
	if (!fid) return;
	(*env)->SetShortField(env, self, fid, query.year);

}

/*
 * Class:     org_libucr_course_CourseQuery
 * Method:    runQueryInternal
 * Signature: (ISILjava/lang/String;Ljava/lang/String;Ljava/lang/String;SIIIIIZ[Z)[Lorg/libucr/course/Course;
 */
JNIEXPORT jobjectArray JNICALL Java_org_libucr_course_CourseQuery_runQueryInternal(
	JNIEnv *env, jobject self, jint quarter, jshort year, jint subject_area, jstring course_title,
	jstring instructor, jstring course_number, jshort start_hour, jint course_status,
	jint course_range, jint class_type, jint course_location, jint breadth_course,
	jboolean graduate_quantification, jbooleanArray days)
{
	struct course_query query;
	struct course_results *results;

	const char *course_title_c;
	const char *instructor_c;
	const char *course_number_c;
	jboolean *jb_array;

	UNUSED(self);

	query.quarter = quarter,
	query.year = year,
	query.subject_area = subject_area,
	query.start_hour = start_hour,
	query.course_status = course_status,
	query.course_range = course_range,
	query.class_type = class_type,
	query.course_location = course_location,
	query.breadth = breadth_course,
	query.graduate_quantitative = graduate_quantification,

	jb_array = (*env)->GetBooleanArrayElements(env, days, NULL);
	query.days[0] = jb_array[0];
	query.days[1] = jb_array[1];
	query.days[2] = jb_array[2];
	query.days[3] = jb_array[3];
	query.days[4] = jb_array[4];
	query.days[5] = jb_array[5];
	(*env)->ReleaseBooleanArrayElements(env, days, jb_array, 0);

	course_title_c = (*env)->GetStringUTFChars(env, course_title, NULL);
	instructor_c = (*env)->GetStringUTFChars(env, instructor, NULL);
	course_number_c = (*env)->GetStringUTFChars(env, course_number, NULL);

	results = ucrcourse_get_courses(&query);

	(*env)->ReleaseStringUTFChars(env, course_title, course_title_c);
	(*env)->ReleaseStringUTFChars(env, instructor, instructor_c);
	(*env)->ReleaseStringUTFChars(env, course_number, course_number_c);

	/* TODO */

	free(results);
	return NULL;
}

