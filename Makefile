JFLAGS = -g -Xlint:none -cp
JC = javac
JR = java
F = find
RM = rm -rf

build: find_sources
	@$(JC) $(JFLAGS) . @sources.txt 

run: Main.class
	@$(JR) Main ${arg0} ${arg1}

find_sources:
	@$(F) -name "*.java" > sources.txt 2>/dev/null

clean:
	@$(RM) ./other_outputs/*
	@$(RM) *.class sources.txt Main.class
	@$(F) . -type f -path "./*/*" -name "*.class" -exec $(RM) -f {} \; &> /dev/null 

