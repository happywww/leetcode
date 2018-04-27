import java.util.HashSet;
import java.util.Set;

import com.sun.tools.javac.util.Assert;

public class UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        String[] alphabet = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
            ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
            "--.." };
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            char[] array = word.toCharArray();
            for (char c : array) {
                sb.append(alphabet[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] words = new String[] { "gin", "zen", "gig", "msg" };
        Assert.check(new UniqueMorseCodeWords().uniqueMorseRepresentations(words) == 2);
    }
}
