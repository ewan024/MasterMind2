package masterMind2;

import java.util.Arrays;

public class Evaluator {
    public String outputCode;
    public String bobTheCharacter;
    public final String[] colors = {"R", "G", "B", "Y", "P", "O", "C"};
    public final byte codeLength = 4;


    public String evaluate(int codeLength, String userCode, String secretCode, String[] colors) {
        //code evaluation
        outputCode = "";

        for (byte i = 0; i < codeLength; i++) {

            //converts a string into a character
            bobTheCharacter = "" + userCode.charAt(i);

            //checks if code has ONLY valid letter pt. 1
            if (Arrays.asList(colors).contains(bobTheCharacter)) {

                //checks if user code is in the right place and the right character
                if (secretCode.charAt(i) == userCode.charAt(i)) {
                    outputCode = outputCode + "B";
                }

                //checks if user code is the right character but not in the right spot
                else if(secretCode.contains(bobTheCharacter)) {
                    outputCode = outputCode + "W";
                }

                //checks if the user code is not in the right place nor in the right spot
                else {
                    outputCode = outputCode + "-";
                }
            }
        }
        return outputCode;
    }

    //Checks for valid code
    public boolean checkCode(String code) {
        if (code.length() != codeLength) return false;
        for (char ch : code.toCharArray()) {
            boolean isValid = false;
            for (String color : colors) {
                if (ch == color.charAt(0)) {
                    isValid = true;
                    break;
                }
            }
            if (!isValid) return false;
        }
        return true;
    }
}
