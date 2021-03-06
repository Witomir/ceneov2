package pl.witomir.ceneov2.args;

public class ArgsParser {
    public String parseArgs(String[] args) {
        if (args.length < 1) {
            renderHelp();
            throw new IllegalArgumentException();
        } else {
            return args[0];
        }
    }

    private static void renderHelp() {
        System.out.println("Add book's title as a first argument");
    }
}
