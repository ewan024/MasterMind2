package masterMind2;
import java.util.*;

public class MasterMind2 {
    public static void main(String[] args) {
        //variables

        //strings
        String name;
        String userCode = "";

        //integers
        int i;
        int guesses = 10;

        //booleans
        boolean wrongInput = false;

        //the (string) array for the colors

        //imports
        Scanner sc = new Scanner(System.in);

        //functions
        Generator gen = new Generator();
        Evaluator eval = new Evaluator();

        //code generator
        String secretCode = gen.getCode(eval.colors, eval.codeLength);

        //welcome message
        System.out.println("""
                Welcome To MasterMind!\r
                Please... (drumroll.mp3) Enter Your Name Down Below!\r
                """);

        //player enters name
        name = sc.next();

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
                    "Please Choose Out Of Any Of The Following Colors: \r\n" + Arrays.toString(eval.colors) + "\r\n");

            //player guesses and checks for valid characters
            boolean isValid = false;

            while (!isValid) {
                userCode = sc.next().toUpperCase();

                if (!eval.checkCode(userCode)) {
                    System.out.println("ERROR... Please Enter VALID Numbers");
                } else {
                    isValid = true;
                }
            }



//            //computer guesses
//            userCode = String.valueOf(gen.getCode(colors, codeLength));
//            System.out.println(userCode);

            //validates lowercase input
            userCode = userCode.toUpperCase();

            //checks if code is correct to the secret code
            if (secretCode.toString().equals(userCode)) {
                System.out.println("Wow! You Did It!");
                sc.close();
                return;
            }

            //error if text is not equal to the code length
            if (userCode.length() != eval.codeLength) {
                System.out.println("\r\nERROR\r\n" +
                        "Please Enter A Code With At Least " + eval.codeLength + " Characters Long\r\n");
                i--;
                continue;
            }
            //code evaluation
            String outputCode = eval.evaluate(eval.codeLength, userCode, secretCode, eval.colors);

            //prints evaluation code
            System.out.println("\r\n" + outputCode);
        }

        //lose message
        System.out.println("Womp Womp!");

        //closes scanner
        sc.close();
    }
}