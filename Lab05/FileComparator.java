import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileComparator {
    public static void main(String[] args) throws IOException {
        String file1Content = readFileContent("output.txt");
        String file2Content = readFileContent("_output.txt");

        if (file1Content.equals(file2Content)) {
            System.out.println("The contents of the files are the same.");
        } else {
            System.out.println("The contents of the files are different.");
        }
    }

    private static String readFileContent(String filePath) throws IOException {
        byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
        return new String(fileBytes);
    }
}
