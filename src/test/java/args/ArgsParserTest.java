package args;

import org.junit.Test;
import pl.witomir.ceneov2.args.ArgsParser;

import static org.junit.Assert.assertEquals;


public class ArgsParserTest {

    @Test
    public void testArgumentsParsing() {
        ArgsParser argsParser = new ArgsParser();
        String[] args = {"C++ sdasdad", "adasd"};
        assertEquals("C++ sdasdad", argsParser.parseArgs(args));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParserWillThrowExceptionWithNoArguments(){
        ArgsParser argsParser = new ArgsParser();
        argsParser.parseArgs(new String[]{});
    }
}
