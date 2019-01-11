classes:
	javac -cp ../rgs/core/target/core-0.1.0-standalone.jar Game.java

build:
	jar cmvf META-INF/MANIFEST.MF vendor.jar *.class

run:
	java -cp ".:../rgs/core/target/core-0.1.0-standalone.jar" Game && \
	java -cp "../rgs/core/target/core-0.1.0-standalone.jar:vendor.jar" Game

all: classes build run

clean:
	rm *.class vendor.jar
