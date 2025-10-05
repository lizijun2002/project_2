JAVAC=javac
JAVA=java

SRC_DIR=src
BIN_DIR=bin

SOURCES=$(wildcard $(SRC_DIR)/*.java)

compile: $(SOURCES)
	mkdir -p $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) $(SOURCES)

run: compile
	$(JAVA) -cp $(BIN_DIR) src.Main

clean:
	rm -rf $(BIN_DIR)
