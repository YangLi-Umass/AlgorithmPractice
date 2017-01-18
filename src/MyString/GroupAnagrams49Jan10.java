package MyString;
import java.util.*;
/**
 * Created by li on 1/10/2017.
 */
public class GroupAnagrams49Jan10 {
    /**
     * 解法一 key 是用字母出现频率表示 O(k)
     * 解法二 key 是将String排序   O(klogk)
     * */


    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s:strs) {
            String k = computeKey(s);
            if(!map.containsKey(k)) map.put(k, new ArrayList<>());
            map.get(k).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public String computeKey(String s) {
        int[] c = new int[26];
        for(int i = 0; i < s.length(); i++){
            c[s.charAt(i)-'a']++;
        }
        return Arrays.toString(c);
    }

    public String computeKey2(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
