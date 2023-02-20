default:class

class:
	javac -cp exe/exe.jar -d prop23/bin prop23/src/domini/*.java prop23/src/presencia/*.java prop23/src/controladors/*.java

jar:
	jar cvf exe.jar -C prop23/bin/domini .

runjar:
	java -jar exe.jar

run:
	java -cp exe.jar:prop23/bin domini.main
	
