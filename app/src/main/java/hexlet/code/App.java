package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", version = "gendiff 1.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @Option(names = {"-f", "--format"}, description = "output format [default: ${DEFAULT-VALUE}]")
    private String format = "stylish";

    public final String getFormat() {
        return format;
    }

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filepath1;

    public final String getFilepath1() {
        return filepath1;
    }

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filepath2;

    public final String getFilepath2() {
        return filepath2;
    }

    @Override
    public final Integer call() throws Exception {
        String result = Differ.generate(getFilepath1(), getFilepath2());
        System.out.println(result);
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }


}
