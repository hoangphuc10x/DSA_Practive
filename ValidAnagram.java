import java.util.*;

public class ValidAnagram {
    // public static boolean isAnagram (String a, String b) {
    //     if (a.length() != b.length()) return false;
    //     Map<Character, Integer> map = new HashMap<>();
    //     for (char c : a.toCharArray()) {
    //         if (!map.containsKey(c)) {
    //             map.put(c, 1);
    //         }
    //         else {
    //             map.put(c, map.get(c) + 1);
    //         }
    //     }
    //     for (char c : b.toCharArray()) {
    //         if (!map.containsKey(c)){
    //             return false;
    //         }
    //         else {
    //             map.put(c, map.get(c) - 1);
    //             if (map.get(c) < 0){
    //                 return false;
    //             }
    //         }
    //     }

    //     for (int value : map.values()) {
    //         if (value != 0 ) return false;
    //     }

    //     return true;
    // }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (int i = 0; i< t.length(); i++){
            char c = t.charAt(i);
            if (map.containsKey(c)){
                if (map.get(c) - 1 < 0){
                    return false;
                }
                map.put(c, map.get(c) + 1);
            }
        }

        for (int value : map.values()) {
            System.out.println("map: "+map);
            System.out.println("nahyr vào đây");
            if (value != 0 ) return false;
        }

        return true;
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        for (int i = 0 ; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length ; j++){
                if(i == strs[j].length() || c != strs[j].charAt(i))
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int count = 0;
        for (int i = 0 ; i < text1.length(); i++ ){
            int index = 0;
            for (int j = index ; j < text2.length(); j ++){
                if (text1.charAt(i) == text2.charAt(j)){
                    count++;
                    index = j+1;
                    System.out.println("text1.charAt(i): "+ text1.charAt(i));
                    System.out.println("count: "+ count);
                    System.out.println("index: "+ index);
                    System.out.println("================");
                }
            }
        }
        return count;
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for (int i = 1;i <= m;i++){
            for (int j = 1;j <= n;j++){
                if (obstacleGrid[i - 1][j - 1] == 1){
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        // System.out.println(isAnagram("anagram", "naagram"));
        // System.out.println(longestCommonSubsequence("ezupkr", "ubmrapg"));
        // System.out.println(isAnagram("rat", "car"));
        // String[] strs = {"dog","racecar","car"};
        // System.out.println("longestCommonPrefix: "+longestCommonPrefix(strs));
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
