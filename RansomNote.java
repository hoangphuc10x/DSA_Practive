import java.util.*;

public class RansomNote {
  public static boolean ok (String ransomNote, String magazine) {
    Map<Character, Integer>map = new HashMap<>();
    for (char c : magazine.toCharArray()) {
        if (!map.containsKey(c)){
            map.put(c, 1);
        }
        else {
            map.put(c, map.get(c) + 1);
        }
    }

    for (char c : ransomNote.toCharArray()) {
        if (!map.containsKey(c)) {
            return false;
        }
        else {
            map.put(c, map.get(c) -1);
            if (map.get(c) < 0){
                return false;
            }
        }
    }
    return true;
  }
  public static void main(String[] args) {
    System.out.println(ok("a", "b"));      // ❌ false
    System.out.println(ok("aa", "ab"));     // ❌ false
    System.out.println(ok("aa", "aab"));    // ✅ true
    System.out.println(ok("hello", "olhlel")); // ✅ true
  }
}
