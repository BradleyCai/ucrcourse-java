.PHONY: all debug check_java_home clean

INCLUDE := -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/$(shell uname | awk '{print tolower($$0)}')

ifeq ($(shell uname),Darwin)
LIB_EXT := dylib
else
LIB_EXT := so
endif

V          ?= 0
ECHO_CC_0   = @echo '[CC] $@'; $(CC)
ECHO_CC_1   = $(CC)
ECHO_CC     = $(ECHO_CC_$(V))

ECHO_LD_0   = @echo '[LD] $@'; $(CC)
ECHO_LD_1   = $(CC)
ECHO_LD     = $(ECHO_LD_$(V))

FLAGS   += -ansi -pipe -fPIC
WFLAGS  += -Wall -Wextra -Wshadow -pedantic
INCLUDE += -I. -Ilibucrcourse/include
LINKING += -shared -lc -lcurl -lucrcourse

SOURCES := $(wildcard *.c)
OBJECTS := $(SOURCES:.c=.o)
HEADERS := $(SOURCES:.c=.h)
LIBRARY := libucrcoursejni.$(LIB_EXT)

all: CFLAGS += -O3
all: check_java_home $(HEADERS) $(LIBRARY)

debug: CFLAGS += -g
debug: check_java_home $(HEADERS) $(LIBRARY)

check_java_home:
	@./check_java_home.sh

$(LIBRARY): $(OBJECTS)
	$(ECHO_LD) $(FLAGS) $(CFLAGS) $(LINKING) -o $@ $^

%.o: %.c %.h
	$(ECHO_CC) $(FLAGS) $(CFLAGS) $(WFLAGS) $(INCLUDE) -c -o $@ $<

%.h:
	@echo '[JAVAH] $(notdir $@)'
	@set -e; \
	classname='$(notdir $(subst _,.,$@))'; \
	cd ../src/main/java; \
	javah -d ../../../jni $${classname%%??}

clean:
	rm -f $(LIBRARY) *.o *.h

