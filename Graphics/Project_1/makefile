JFLAGS = -cp
JLIBRARY = /usr/share/processing/core/library/core.jar
JC = javac
JVM = java
.SUFFIXES: .java .class
.java.class:
	$(JC) -g $(JFLAGS) $(JLIBRARY) $(CLASSES)

CLASSES = \
	ProjectTree.java \
	ProjectView.java \
	ProcessingApplet.java \
	Project.java 

MAIN = \
	Project

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(JFLAGS) "$(JLIBRARY):." $(MAIN)

clean:
	$(RM) *.class
