package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Path;
import java.util.concurrent.Callable;

@Command(name = "gendiff", version = "gendiff 1.0",mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @Option(names = {"-f", "--format"}, description = "output format [default: ${DEFAULT-VALUE}]")
    String format = "stylish";

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    Path filepath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    Path filepath2;

    @Override
    public Integer call() throws Exception {
        return null;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }


}