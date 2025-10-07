setup:
	./gradlew wrapper --gradle-version 8.14

run-dist:
	./build/install/diff/bin/diff

build:
	./gradlew clean build

test:
	./gradlew test

checkstyleMain:
	./gradlew checkstyleMain

checkstyleTest:
	./gradlew checkstyleTest

.PHONY: build