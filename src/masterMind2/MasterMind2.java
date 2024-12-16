package masterMind2;
import java.util.*;

public class MasterMind2 {
    public static void main(String[] args) {
        //variables

        //strings
        String name;
        String bobTheCharacter;
        String userCode;
        String outputCode;

        //integers
        int i;
        int i2;
        int guesses = 999999999;
        int codeLength = 4;
        int x = 0;

        //booleans
        boolean wrongInput = false;

        //the (string) array for the colors
        String[] colors = {"R", "G", "B", "Y", "P", "O", "C"};

        //imports
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        //functions
        Generator gen = new Generator();
        Guesser guesser = new Guesser();

        //code generator
        StringBuilder secretCode = gen.getLetter(colors, codeLength);

        //welcome message
        System.out.println("""
                Welcome To MasterMind!\r
                Please... (drumroll.mp3) Enter Your Name Down Below!\r
                """);

        //player enters name
        name = "e";

        //shows code if name is Admin
        if (name.equals("Admin") || name.equals("admin")) {
            System.out.println(secretCode);
        }

        //start message
        System.out.println("Hello, " + name + "! Lets Start The Game!");

        //beginning game, defines the outside of the loop
        outerLoop: for (i = 0; i < guesses; i++) {

            //the amount of guesses left message
            System.out.println("\r\nGuess: " + (i + 1) + "/" + guesses + "\r\n" +
                    "Please Choose Out Of Any Of The Following Colors: \r\n" + Arrays.toString(colors));
            //userCode = sc.nextLine();

            //computer guesses
            userCode = String.valueOf(guesser.guess(colors, codeLength));
            System.out.println(userCode);

            try {
                // Pause for 10 milliseconds
                Thread.sleep(0);
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.getMessage());
                // Optionally exit the loop if needed
                break;
            }

            //validates lowercase input
            userCode = userCode.toUpperCase();

            //checks if code is correct to the secret code
            if (secretCode.toString().equals(userCode)) {
                System.out.println("Wow! You Did It!");
                sc.close();
                return;
            }

            //error if text is not equal to the code length
            if (userCode.length() != codeLength) {
                System.out.println("\r\nERROR\r\n" +
                        "Please Enter A Code With At Least " + codeLength + " Characters Long\r\n");
                i--;
                continue;
            }

            //makes sure evaluation code does not print multiple times
            outputCode = "";

            //code evaluation
            for (i2 = 0; i2 < codeLength; i2++) {

                //converts a string into a character
                bobTheCharacter = "" + userCode.charAt(i2);

                //checks if code has ONLY valid letter pt. 1
                if (Arrays.asList(colors).contains(bobTheCharacter)) {

                    //checks if user code is in the right place and the right character
                    if (secretCode.charAt(i2) == userCode.charAt(i2)) {
                        outputCode = outputCode + "B";
                    }

                    //checks if user code is the right character but not in the right spot
                    else if(secretCode.toString().contains(bobTheCharacter)) {
                        outputCode = outputCode + "W";
                    }

                    //checks if the user code is not in the right place nor in the right spot
                    else {
                        outputCode = outputCode + "-";
                    }
                }

                //checks if code has ONLY valid letter pt. 2
                else {
                    wrongInput = true;
                    System.out.println("""
                            \r
                            ERROR\r
                            Please Enter Valid Letters!\r
                            """);
                    i--;
                    continue outerLoop;
                }
            }

            //prints evaluation code
            System.out.println("\r\n" + outputCode);
        }

        //lose message
        System.out.println("Womp Womp!");

        //closes scanner
        sc.close();
    }
}