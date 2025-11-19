import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public static void saveToFile(List<Issue> issues) {
        try {
            FileWriter fw = new FileWriter("issues.txt");
            for (Issue issue : issues) {
                fw.write(issue.toString() + "\n");
            }
            fw.close();
            System.out.println("Issues saved to file.");
        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public static void loadFromFile(List<Issue> issueList) {
        try {
            File file = new File("issues.txt");
            if (!file.exists()) return;

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                Issue issue = new Issue(
                    Integer.parseInt(data[0]),
                    data[1],
                    data[2],
                    data[3],
                    data[4]
                );
                issueList.add(issue);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}
