import java.util.*;

public class ValidAnagram {
    public static boolean isAnagram (String a, String b) {
        if (a.length() != b.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : a.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            }
            else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (char c : b.toCharArray()) {
            if (!map.containsKey(c)){
                return false;
            }
            else {
                map.put(c, map.get(c) - 1);
                if (map.get(c) < 0){
                    return false;
                }
            }
        }

        for (int value : map.values()) {
            if (value != 0 ) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "naagram")); // ✅ true
        System.out.println(isAnagram("rat", "car"));          // ❌ false
    }
}
