package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by li on 11/9/2016.
 */
public class CloneGraph133Nov19 {
    private class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }



    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        HashMap<Integer, UndirectedGraphNode> newMap = new HashMap<>();
        helper(node, map, newMap);
        return newMap.get(node.label);
    }

    public void helper(UndirectedGraphNode n, HashMap<Integer, UndirectedGraphNode> h, HashMap<Integer, UndirectedGraphNode> newMap) {

        h.put(n.label, n);
        newMap.put(n.label, new UndirectedGraphNode(n.label));
        for(UndirectedGraphNode temp:n.neighbors) {
            if(!h.containsKey(temp.label)) {
                helper(temp, h, newMap);
                newMap.get(n.label).neighbors.add(newMap.get(temp.label));
            }

        }
    }
}
