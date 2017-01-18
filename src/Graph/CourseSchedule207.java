package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by li on 11/9/2016.
 */
public class CourseSchedule207 {

    //14ms
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] flag = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] temp:prerequisites) {
            graph[temp[0]].add(temp[1]);
        }
        boolean r = true;
        for(int i = 0; i < numCourses; i++) {
            if(flag[i] == 0) {
                r = r & dfs(graph, i, flag);
                if(!r) return false;
            }
        }
        return r;
    }

    public boolean dfs(ArrayList<Integer>[] graph, int vertex, int[] flag) {
        if(flag[vertex] == 1) return false;
        flag[vertex] = 1;
        boolean r = true;
        for(Integer temp:graph[vertex]) {
            r = r & dfs(graph, temp, flag);
            if(!r) return false;
        }
        flag[vertex] = 2;
        return r;

    }


    public boolean canFinish50(int numCourses, int[][] prerequisites) {
        if(numCourses < 1) return true;
        List<Set<Integer>> graph = new ArrayList<>(numCourses);
        Set<Integer> nodes = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<>());
        }
        for(int[] temp:prerequisites) {
            graph.get(temp[0]).add(temp[1]);
        }

        boolean r = true;
        HashSet<Integer> vertices = new HashSet<>();

        for(int i = 0; i < numCourses; i++) {
            if(nodes.contains(i)) continue;
            r = r && helper50(graph, vertices, i, nodes);
            if(!r) break;
        }

        return r;
    }

    public boolean helper50(List<Set<Integer>> g, HashSet<Integer> v, int node, Set<Integer> visited) {
        visited.add(node);
        v.add(node);
        boolean r = true;
        for(Integer temp:g.get(node)) {
            if(!v.contains(temp)) {
                r = r && helper50(g, v, temp, visited);
                if(!r) return false;
            } else return false;
        }
        v.remove(node);
        return r;
    }
}
