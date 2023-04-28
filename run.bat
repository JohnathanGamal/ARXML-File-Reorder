@echo off
javac *.java
javac ./file_reorder/*.java
java Main.java correctCase.arxml
echo File correctCase.arxml has been processed.
echo Press any key to process the second file. 
pause
java Main.java wrongtype.txt
echo File wrongtype.txt has been processed.
echo Press any key to process the third file. 
pause
java Main.java empty.arxml
echo File empty.arxml has been processed.
echo All files have been processed.
pause

