/*−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------
File name       : ProgramTest.java
Author(s)       : Kevin Farine, Timothée Van Hove
Created         : 3 nov. 2022
Description     : Tests for the main program
Remark(s)       : Use "mvn clean test" command to launch the test
JDK             : OpenJDK Runtime Environment Temurin-17.0.5+8 (build 17.0.5+8)
−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------*/
package ch.heigvd.poo.labo5;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class ProgramTest {
    @Test
    //Note: We cannot assert anything in those tests because the main function
    // does not return anything and all the exceptions are catch inside it;
    //We can only verify that the program runs as expected by looking at the console
    public void testTheMainProgram() {

        //The program should not display any errors
        String[][] argList = {
                //The program should show correct matrices (nominal case)
                {"4", "5", "2", "7", "100"},

                // The program should display an exception about the illegal
                // character in the argument array
                {"4", "5", "2", "7", "test"},

                // The program should display an error exception the non-integer
                // value in the argument array
                {"4", "5", "2", "7", "0.42"},

                //The program should display an exception about the wrong number of
                // arguments given
                {"4", "5", "2", "7"}};

        for(String[] args : argList){
            System.out.println("Running the program with " + Arrays.toString(args) +
                    "as arguments");
            Program.main(args);
        }
    }
}
