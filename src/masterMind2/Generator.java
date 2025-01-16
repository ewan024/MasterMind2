package masterMind2;

import java.util.Random;

public class Generator {
    Random r = new Random();
    public final String[] colors = {"R", "G", "B", "Y", "P", "O", "C"};
    public final byte codeLength = 4;


    public String getCode() {

        String code = "";

        for (int i = 0; i < codeLength; i++) {
            int random = r.nextInt(colors.length); // Pick a random index
            code += colors[random];
        }

        try {
            // Pause for 10 milliseconds
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return code;
    }
}
