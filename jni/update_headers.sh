#!/bin/sh
set -eu

cd "$(dirname "$0")"

JAVA_SOURCE_DIR=../src/main/java
HEADER_OUTPUT_DIR="$(pwd)"
CLASS_NAMES=(
	'org.libucr.course.CourseException'
	'org.libucr.course.CourseQuery'
)

cd "$JAVA_SOURCE_DIR"
exec javah -v -d "$HEADER_OUTPUT_DIR" "${CLASS_NAMES[@]}"

