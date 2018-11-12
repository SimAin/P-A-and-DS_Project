import java.io.*;
import java.util.Scanner;

public class mediaManager {

    private static final String m_file = "C:/Users/srain/IdeaProjects/practicalCoursework_Problem_1/src/media_library.txt";

    public static void main (String[] args) throws IOException {

        int counter = 0;
        String[] details = new String[5000];

        Scanner scanner = new Scanner(new File("C:/Users/srain/IdeaProjects/practicalCoursework_Problem_1/src/media_library.txt"));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            counter++;
            details[counter] = scanner.next();
        }

        scanner.close();
        int artistCount =1;
        int addedCount = 0;
        artists artistList = new artists(50);
        String NewFromFile = "";
        for (int i = 1; i <= counter; i++) {
            if(artistCount == 1) {
                NewFromFile = details[i];
            }
            if(artistCount == 4){
                //NewFromFile.numberOfTracks = details[i];
                if(addedCount < (counter/4)) {
                    artistList.push(NewFromFile);
                }
                artistCount = 0;
                addedCount++;
                NewFromFile = "";
            }
            artistCount++;
        }

        for (int i = 0; i < artistList.currentSize; i++) {
            System.out.println(artistList.array[i] + i);
        }
    }
}
