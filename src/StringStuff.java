import java.util.*;

/**
 * Created by afuller on 10/25/15.
 */
public final class StringStuff {

    private StringStuff() {}

    public static void main(String[] args) {

        System.out.println("aaabbbaccccccaaaddd " + compressString("aaabbbaccccccaaaddd"));
    }


    public static boolean containsDuplicateChars(String s) {
        if (s.isEmpty()) {
            return false;
        } else {
            Set<Character> chars = new HashSet<>();
            char[] charString = s.toCharArray();
            for (int i = 0; i < s.length() -1;i++) {
                if (chars.contains(charString[i])) {
                    return true;
                } else {
                    chars.add(charString[i]);
                }
            }
        }
        return false;
    }

    public static String compressString(String s) {
        char[] chars = s.toCharArray();
        List<Character> compressList = new ArrayList<Character>();
        if (s.length() < 1) {
            return s;
        }
        char prevChar = chars[0];
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char currChar = chars[i];
            if (prevChar == currChar) {
                count++;
            } else {
                compressList.add(prevChar);
                compressList.add(Character.forDigit(count, 10));
                count = 1;
            }
            prevChar = currChar;
        }
        compressList.add(prevChar);
        compressList.add(Character.forDigit(count, 10));
        StringBuilder sb = new StringBuilder();
        for (Character c: compressList) {
            sb.append(c);
        }
        return sb.toString();
    }


    public static boolean isPermutation(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else {
            Hashtable<Character, Integer> charCountsA = new Hashtable<>();
            Hashtable<Character, Integer> charCountsB = new Hashtable<>();
            char[] charsA = a.toCharArray();
            char[] charsB = b.toCharArray();
            for (int i = 0; i < a.length(); i++) {

                if (charCountsA.containsKey(charsA[i])) {
                    int currCount = charCountsA.get(charsA[i]);
                    charCountsA.put(charsA[i], currCount++);
                } else {
                    charCountsA.put(charsA[i], 1);
                }
                if (charCountsB.containsKey(charsB[i])) {
                    int currCount = charCountsB.get(charsB[i]);
                    charCountsB.put(charsB[i], currCount++);
                } else {
                    charCountsB.put(charsB[i], 1);
                }
            }
            Iterator<Character> iterA = charCountsA.keySet().iterator();
            while (iterA.hasNext()) {
                Character c = iterA.next();
                if (charCountsB.containsKey(c)) {
                    if (!charCountsA.get(c).equals(charCountsB.get(c))) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        }
    }



}
