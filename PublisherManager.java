import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class PublisherManager {
    String path;

    public PublisherManager() {
        path = "./publisher.txt";
    }

    public void writePublisher(Publisher pub) {
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(pub.toString());
            writer.flush();
            writer.close();
        } catch (Exception ex) {}
    }

    public Publisher[] getAllPublishers() {
        File file = new File(path);
        int count = 0;
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                sc.nextLine();
                count++;
            }
        } catch (Exception ex) {}

        Publisher[] publishers = new Publisher[count];
        try {
            Scanner sc = new Scanner(file);
            for (int i = 0; i < count; i++) {
                String line = sc.nextLine();
                Publisher pub = new Publisher(line);
                publishers[i] = pub;
            }
        } catch (Exception ex) {}
        return publishers;
    }
}