#!/bin/sh

if [ "" = "$CXF_HOME" ]; then 	# -n tests to see if the argument is non empty
	echo You must set environment variable CXF_HOME to run this script.
	exit 0
fi


export BASE_DIR=`dirname $0`

export CXF_JAR=$CXF_HOME/lib/cxf-manifest.jar

if [ ! -e "$CXF_JAR" ]; then 
	# Can't find cxf-manifest.jar; perhaps this is an earlier verion of CXF from when the project was in "incubator" status?
	export CXF_JAR=$CXF_HOME/lib/cxf-manifest-incubator.jar
fi

if [ ! -e "$CXF_JAR" ]; then 
	echo Unable to locate CXF jar files - cannot proceed. 
	exit 
fi

export CLASSPATH=$BASE_DIR/build/classes:$BASE_DIR/etc:$CXF_JAR:$CXF_HOME/etc$CLASSPATH

export JVM_ARGS="-Djava.util.logging.config.file=$BASE_DIR/etc/logging.properties -Dcxf.config.file=cxf-stock-quote.xml"

echo java $JVM_ARGS stockquote.Server
java $JVM_ARGS stockquote.Server
