
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("File:");
        String file = scan.nextLine();
        
        System.out.println("Team:");
        String team = scan.nextLine();
        
        int counter = 0;
        
        try (Scanner reader = new Scanner(Paths.get(file))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                
                if (line.contains(team)) {
                    counter++;                    
                }
                String[] parts = line.split(",");
                
            }
        } catch (Exception e) {
            System.out.println("Error: " +e.getMessage());
        }
        
        System.out.println("Games: " +counter);
        System.out.println("Wins: " +wins);
        System.out.println("Losses: " +losses);
    }
}
