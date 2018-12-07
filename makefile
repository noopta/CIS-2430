JFLAGS = -g
JC = javac
JVM = java

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
  Planner.java \
  ConnectionDemo.java \
  PrepStudentScript.java \
  DBDetails.java \
  DBStudent.java \
  BCG.java \
  PlanOfStudy.java \
  CourseCatalog.java \
  Attempt.java \
  Course.java \
	Student.java \
	CS.java \
	SENG.java \
	GeneralDegree.java \
	Degree.java \
	./univ/Course.java \
	./univ/Degree.java \
	./univ/CS.java \
	./univ/PlanOfStudy.java \
	./univ/Student.java \
	./univ/CourseCatalog.java \
	./univ/GeneralDegree.java \
	./univ/SENG.java \

MAIN = Planner
default: classes
classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN)

clean:
	$(RM) *.class
