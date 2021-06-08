import java.util.LinkedHashSet;
import java.util.Set;

public class Anagram {

    private char[] chars;
    private Set<String> result = new LinkedHashSet<>();

    public Set<String> findAll(String word) {
        result.clear();
        this.chars = word.toCharArray();
        find(chars.length);
        return result;
    }

    private void find(int length) {
        if (length == 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            find(length - 1);
            //System.out.println("length = " + length + "; i = " + i + ";  Анаграма : " + String.valueOf(chars));
            result.add(String.valueOf(chars));
            rotate(length);
        }
    }

    private void rotate(int length) {
        int pos = chars.length - length;
        char temp = chars[pos];

        for (int i = pos + 1; i < chars.length; i++) {
            chars[i - 1] = chars[i];
        }

        chars[chars.length - 1] = temp;
    }
}
