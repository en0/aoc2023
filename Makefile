.PHONY: test test-watch run

test:
	@mvn clean test

test-watch:
	@find src -name "*.java" | entr -r mvn clean test

run:
	@mvn clean --quiet spring-boot:run -Dspring-boot.run.arguments="$(ARGS)"
