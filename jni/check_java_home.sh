#!/bin/bash

RED_BOLD="\033[31;1m"
COLOR_RESET="\033[0m"

if [[ -z $JAVA_HOME ]]; then
    printf >&2 "${RED_BOLD}JAVA_HOME is not set!${COLOR_RESET} Compilation cannot continue.\n"
    exit 1
fi

if [[ ! -d $JAVA_HOME ]]; then
    printf >&2 "${RED_BOLD}JAVA_HOME doesn't exist!${COLOR_RESET} It's set to \"%s\".\n" "$JAVA_HOME"
    exit 1
fi

if [[ ! -d $JAVA_HOME/include ]]; then
    printf >&2 "${RED_BOLD}JAVA_HOME doesn't have an include dir!${COLOR_RESET}.\n"
    printf >&2 "The contents of \"%s\" are listed below:\n" "$JAVA_HOME"
    ls >&2 "$JAVA_HOME"
fi

