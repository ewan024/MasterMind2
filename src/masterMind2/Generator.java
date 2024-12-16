package masterMind2;

import java.util.Random;

public class Generator {
    Random r = new Random();
    public char random;
    public StringBuilder code = new StringBuilder();

    public StringBuilder getLetter(String[] colors, int repeat) {
        for (int i = 0; i < repeat; i++) {
            random = (char) r.nextInt(colors.length);
            code.append(colors[random]);
        }
        return code;
    }
}
