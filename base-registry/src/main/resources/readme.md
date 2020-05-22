java -jar -Dspring.profiles.active=peer2 base-registry-1.0-SNAPSHOT.jar
java -jar -Dspring.profiles.active=peer3 base-registry-1.0-SNAPSHOT.jar

java -jar base-registry-1.0-SNAPSHOT.jar --spring.profiles.active=peer2
java -jar base-registry-1.0-SNAPSHOT.jar --spring.profiles.active=peer3