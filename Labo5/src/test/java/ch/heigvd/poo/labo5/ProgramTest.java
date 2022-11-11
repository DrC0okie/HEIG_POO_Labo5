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

public class ProgramTest {
    @Test
    //Note: We cannot assert anything in those tests because the main function
    // does not return anything and all the exceptions are catch inside it;
    //We can only verify that the program runs correctly by looking at the console
    public void testTheMainProgram() {

        //The program should not display any errors
        Program.main(new String[]{"4", "5", "2", "7", "1000"});

        // The program should display an error about the illegal character in the
        // argument array
        Program.main(new String[]{"4", "5", "2", "7", "test"});

        // The program should display an error about the illegal character in the
        // argument array
        Program.main(new String[]{"4", "5", "2", "7", "0.42"});

        //The program should display an error about the wrong number of arguments
        // given
        Program.main(new String[]{"4", "5", "2", "7"});
    }
}
