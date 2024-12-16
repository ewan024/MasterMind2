package masterMind2;

import java.util.Random;

public class Guesser {
    Random r = new Random();
    public char random;
    public StringBuilder code = new StringBuilder();

    public StringBuilder guess(String[] colors, int repeat) {
        code.setLength(0);

        for (int i = 0; i < repeat; i++) {
            random = (char) r.nextInt(colors.length);
            code.append(colors[random]);
        }
        return code;
    }
}
