package assignment1;
public class reorganizeString {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new Solution767().reorganizeString(s));
    }
}
class Solution767 {
    public String reorganizeString(String s) {
        int max =Integer.MIN_VALUE;
        int len = s.length();
        int[] cnt = new int[26];
        char[] words = s.toCharArray();
        for (int i = 0; i < len; i++) {
            cnt[words[i] - 'a']++;
        }
        int word =0;
        int mid = (len + 1) /2;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                word = i;
                if (max > mid)
                    return "";
            }
        }
        char[] res = new char[len];
        int index = 0;
        while (cnt[word]-- > 0) {
            res[index] = (char) (word + 'a');
            index += 2;
        }
        for (int i = 0; i < cnt.length; i++) {
            while (cnt[i]-- > 0) {
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
            }
        }
        return new String(res);
    }
}
