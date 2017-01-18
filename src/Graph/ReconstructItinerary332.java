package Graph;

import java.util.*;

/**
 * Created by li on 11/14/2016.
 */
public class ReconstructItinerary332 {

    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

    public List<String> findItineraryBest(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }



    private static class Vertex {
        String ori;
        ArrayList<String> des;

        Vertex(String o) {
            ori = o;
            des = new ArrayList<>();
        }

        void addDesInti(String s) {
            des.add(s);
            Collections.sort(des);
        }

        void addDes(String s) {
            des.add(s);
        }
        String getmin() {
            return des.remove(0);
        }

    }
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, Vertex> graph = new HashMap<>();
        for(String[] temp:tickets) {
            if(!graph.containsKey(temp[0])) {
                graph.put(temp[0], new Vertex(temp[0]));
            }

            graph.get(temp[0]).addDesInti(temp[1]);
        }

        int[] ticketNum = {tickets.length};
        ArrayList<String> r = new ArrayList<>();
        dfs(graph, "JFK", ticketNum, r);
        return r;
    }

    public int dfs(HashMap<String, Vertex> g, String v, int[] tNo, ArrayList<String> r) {

        r.add(v);
        while (g.get(v).des.size() != 0) {
            String min = g.get(v).getmin();
            tNo[0]--;
            int i = dfs(g, min, tNo, r);
            if(i == 0) return 0;
            else {
                tNo[0]++;
                g.get(v).addDes(min);
            }
        }
        if(tNo[0] != 0) r.remove(r.size()-1);
        return  tNo[0];
    }

}
