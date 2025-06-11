import java.util.Scanner;

public class BruteForcePasswordCracker {
    // Character set for lowercase letters and numbers
    static String characters = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static void main(String[] args) {
        // Change console text color to red for "Brute Force"
        System.out.print("\033[31m"); // Set the text color to red
        
        // Big ASCII Art for "Brute Force"
        System.out.println("  BBBBB   RRRRR   U   U  TTTTT  EEEEE      FFFFF  OOOOO  RRRRR   CCCCC  EEEEE");
        System.out.println("  B    B  R    R  U   U    T    E          F      O   O  R    R  C      E");
        System.out.println("  BBBBB   RRRRR   U   U    T    EEEE       FFFF   O   O  RRRRR   C      EEEE");
        System.out.println("  B    B  R   R   U   U    T    E          F      O   O  R   R   C      E");
        System.out.println("  BBBBB   R    R   UUU     T    EEEEE      F       OOOOO  R    R  CCCCC  EEEEE");

        // Change the text color back to green for the rest of the program
        System.out.print("\033[32m"); // Set the text color to green
        
        // Display the rest of the program info
        System.out.println("##########################");
        System.out.println("# Brute Force Attack #");
        System.out.println("##########################");

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Get the password to crack
        System.out.print("\nEnter the password to crack: ");
        String targetPassword = scanner.nextLine();
        
        // Ask the user if they are sure their password is safe
        System.out.print("\nAre you sure that your password is safe? (yes/no): ");
        String userResponse = scanner.nextLine().toLowerCase();
        
        // If the response is "yes", proceed with the brute force attack
        if ("yes".equals(userResponse)) {
            // Display the message before starting the brute force attack
            System.out.println("\nI'm Gonna Crack the password right in front of you!");
            
            // Adding a 3-second delay before continuing the brute force attack
            try {
                Thread.sleep(3000); // Sleep for 3 seconds
            } catch (InterruptedException e) {
                e.printStackTrace(); // Handle interruption exception
            }
            
            // Begin brute force attack with the combined character set
            bruteForce("", targetPassword, characters);
        } else {
            // If the response is "no", stop the program
            System.out.println("\nPassword cracking will not proceed. Exiting...");
        }
        
        scanner.close();
    }

    public static void bruteForce(String attempt, String target, String characters) {
        // Display progress without escape sequences for debugging
        System.out.print("\rCracking your password: " + attempt + "...");

        if (attempt.equals(target)) {
            // Display success without escape sequences for debugging
            System.out.println("\n\nGOT YOUR PASSWORD !!!  " + attempt + "");

            // Add the message that the password has been leaked
            System.out.println("\nYour password has been leaked to me!");

            // End the program after cracking the password
            System.exit(0);
        }

        if (attempt.length() < target.length()) {
            // Generate combinations for the current length
            for (char c : characters.toCharArray()) {
                bruteForce(attempt + c, target, characters);
            }
        }
    }
}
