package masterMind2;

import java.util.Random;

public class Generator {
    Random r = new Random();
    public char random;
    public String code = "";

    boolean firstInput = true;

    public String getCode(String[] colors, int repeat) {

        for (int i = 0; i < repeat; i++) {
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
