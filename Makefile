setup:
	./gradlew wrapper --gradle-version 8.14

installDist:
	./gradlew clean installDist

run-dist:
	./build/install/diff/bin/diff -f json src/main/resources/json/file1.json src/main/resources/json/file2.json

build:
	./gradlew clean build

test:
	./gradlew test

checkstyleMain:
	./gradlew checkstyleMain

checkstyleTest:
	./gradlew checkstyleTest

sonar:
	./gradlew build sonar --info

.PHONY: build