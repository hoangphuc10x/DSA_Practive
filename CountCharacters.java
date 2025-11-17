import java.util.*;

public class CountCharacters {
    public static void main(String[] args) {
        String s = "bananacvbnxcvbzcvbvb";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)){
                map.put(c, 1);
            }
            else {
                int current = map.get(c);
                map.put(c, current +1);
            }
        }
        System.out.print(map);
    }
}
