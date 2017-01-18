package Graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by li on 11/14/2016.
 */
public class AlineDictionary269 {
    public String alienOrder(String[] words) {
        //
        if(words.length == 1) return words[0];
        ArrayList<Integer>[] graph = new ArrayList[26];
        for(int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] flag = new int[26];
        Arrays.fill(flag, 3);
        for(int i = 0; i < words.length-1; i++) {
            boolean r = findEdge(graph, words[i], words[i+1], flag);
            if(!r) return "";
        }


        StringBuilder sb = new StringBuilder();
        boolean r = true;
        for(int i = 0; i < 26; i++) {
            r = r & bfs(graph, i, flag, sb);
            if(!r) return "";
        }
        return sb.toString();
    }

    public boolean bfs(ArrayList<Integer>[] g, int vertex, int[] flag, StringBuilder sb) {
        if(flag[vertex] == 1) return false;
        if(flag[vertex] == 2 || flag[vertex] == 3) return true;
        flag[vertex] = 1;
        boolean r = true;
        for(int temp:g[vertex]) {
            r = r & bfs(g, temp-'a', flag, sb);
        }
        char c = (char) (97 + vertex);
        sb.append(c);
        flag[vertex] = 2;
        return r;
    }

    public boolean findEdge(ArrayList<Integer>[] g, String s1, String s2, int[] flag) {
        int minLen = Math.min(s1.length(), s2.length());
        int i = 0;
        boolean diffFlag = false;
        while(i < minLen) {
            flag[s2.charAt(i)-'a'] = 0;
            flag[s1.charAt(i)-'a'] = 0;
            if(s1.charAt(i) != s2.charAt(i)) {
                g[s2.charAt(i)-'a'].add((int)s1.charAt(i));
                diffFlag = true;
            }
            i++;
        }
        if(s2.length() == s1.length() || s1.length() < s2.length()) diffFlag = true;
        while(diffFlag && i < s1.length()) {
            flag[s1.charAt(i)-'a'] = 0;
            i++;
        }

        while(diffFlag && i < s2.length()) {
            flag[s2.charAt(i)-'a'] = 0;
            i++;
        }


        return diffFlag;
    }
}
