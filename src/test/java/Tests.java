import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.lang.NullPointerException;


import oracle.interview.metrics.Main;

public class Tests {
    @Test
    void xmlFileOneTestMain() throws IOException, ParserConfigurationException, SAXException{
        PrintStream stdout = System.out;
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        final ByteArrayOutputStream errorOut = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(errorOut));

        Main.main(new String[] {"metrics_data.xml"});

        final String standardOutput = myOut.toString();
       

        Boolean blueWrote = standardOutput.contains("blue.oracle.com");
        Boolean greenWrote = standardOutput.contains("green.oracle.com");
        Boolean redWrote = standardOutput.contains("red.oracle.com");
        Boolean successfulWrite = false;
        if(blueWrote && greenWrote && redWrote){
            successfulWrite = true;
        }

        assertEquals(true, successfulWrite);
    }

    @Test
    void xmlFileTwoTestMain() throws IOException, ParserConfigurationException, SAXException{
        PrintStream stdout = System.out;
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        final ByteArrayOutputStream errorOut = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(errorOut));

        Main.main(new String[] {"metrics_data_two.xml"});

        final String standardOutput = myOut.toString();
       

        Boolean blueWrote = standardOutput.contains("blue.oracle.com");
        Boolean redWrote = standardOutput.contains("red.oracle.com");
        Boolean successfulWrite = false;
        if(blueWrote && redWrote){
            successfulWrite = true;
        }

        assertEquals(true, successfulWrite);
    }

    @Test
    void oneLessTargetinXMLFile() throws IOException, ParserConfigurationException, SAXException{
        PrintStream stdout = System.out;
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        final ByteArrayOutputStream errorOut = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(errorOut));

        Main.main(new String[] {"metrics_data_two.xml"});

        final String standardOutput = myOut.toString();
       

        Boolean blueWrote = standardOutput.contains("blue.oracle.com");
        Boolean greenWrote = standardOutput.contains("green.oracle.com");
        Boolean redWrote = standardOutput.contains("red.oracle.com");
        Boolean successfulWrite = false;
        if(blueWrote && greenWrote && redWrote){
            successfulWrite = true;
        }

        assertEquals(false, successfulWrite);
    }

    @Test
    void noMetricsinXMLFile() throws IOException, ParserConfigurationException, SAXException{
        PrintStream stdout = System.out;
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        final ByteArrayOutputStream errorOut = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(errorOut));

        Main.main(new String[] {"metrics_data_3.xml"});

        final String standardOutput = myOut.toString();
       

        Boolean blueWrote = standardOutput.contains("blue.oracle.com");
        Boolean greenWrote = standardOutput.contains("green.oracle.com");
        Boolean redWrote = standardOutput.contains("red.oracle.com");
        Boolean successfulWrite = false;
        if(blueWrote && greenWrote && redWrote){
            successfulWrite = true;
        }

        assertEquals(true, successfulWrite);
    }

    @Test
    void noTargetsinXMLFile() throws IOException, ParserConfigurationException, SAXException{
        PrintStream stdout = System.out;
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        final ByteArrayOutputStream errorOut = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(errorOut));

        Main.main(new String[] {"metrics_data_4.xml"});

        final String standardOutput = myOut.toString();
       

        Boolean blueWrote = standardOutput.contains("blue.oracle.com");
        Boolean greenWrote = standardOutput.contains("green.oracle.com");
        Boolean redWrote = standardOutput.contains("red.oracle.com");
        Boolean successfulWrite = false;
        if(blueWrote && greenWrote && redWrote){
            successfulWrite = true;
        }

        assertEquals(false, successfulWrite);
    }

    @Test
    void missingTypeAtrributeInTargetsinXMLFile() throws IOException, ParserConfigurationException, SAXException{
        PrintStream stdout = System.out;
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        final ByteArrayOutputStream errorOut = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(errorOut));

        Main.main(new String[] {"metrics_data_5.xml"});

        final String standardOutput = myOut.toString();
       

        Boolean blueWrote = standardOutput.contains("blue.oracle.com");
        Boolean greenWrote = standardOutput.contains("green.oracle.com");
        Boolean redWrote = standardOutput.contains("red.oracle.com");
        Boolean successfulWrite = false;
        if(blueWrote && greenWrote && redWrote){
            successfulWrite = true;
        }

        assertEquals(true, successfulWrite);
    }
    @Test
    void missingHostAtrributeInTargetsinXMLFile() throws IOException, ParserConfigurationException, SAXException{
        PrintStream stdout = System.out;
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        final ByteArrayOutputStream errorOut = new ByteArrayOutputStream();

        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(errorOut));

        Main.main(new String[] {"metrics_data_6.xml"});

        final String standardOutput = myOut.toString();
       

        Boolean blueWrote = standardOutput.contains("blue.oracle.com");
        Boolean greenWrote = standardOutput.contains("green.oracle.com");
        Boolean redWrote = standardOutput.contains("red.oracle.com");
        Boolean successfulWrite = false;
        if(blueWrote && greenWrote && redWrote){
            successfulWrite = true;
        }

        assertEquals(false, successfulWrite);
    }
}
