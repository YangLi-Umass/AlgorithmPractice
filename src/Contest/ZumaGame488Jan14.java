package Contest;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by li on 1/14/2017.
 */
public class ZumaGame488Jan14 {


    public int findMinStep(String board, String hand) {
        //precomputation
        //convert board from String to StringBuilder, easy to delete and insert char.
        //convert hand from String to HashMap, easy to get the number of a particular kind of ball in hand.
        StringBuilder b = new StringBuilder(board);
        Map<Character,Integer> handMap = new HashMap<>(5);
        handMap.put('R', 0);
        handMap.put('B', 0);
        handMap.put('G', 0);
        handMap.put('W', 0);
        handMap.put('Y', 0);
        for(char c : hand.toCharArray()) {
            handMap.put(c, handMap.get(c)+1);
        }
        //after precomputation, use helper method to find the answer recursively.
        return helper(b, handMap);
     }


    public int helper(StringBuilder board, Map<Character,Integer> hand) {
        if(board.length() == 0) return 0;
        if(handIsEmpty(hand)) return -1;
        int count = 1;
        int min = Integer.MAX_VALUE;
        //find a place to insert ball(s) to remove at least three balls.
        for (int i = 0; i < board.length(); i++) {
            char nowChar = board.charAt(i);
            if(i+1 < board.length() && board.charAt(i+1) == nowChar) {
                count++;
                continue;
            }
            int missing = 3-count;
            if(hand.get(nowChar) - missing >= 0) {
                //new board to manipulate
                StringBuilder newBoard = new StringBuilder(board);
                //insert ball(s) according to the missing number
                newBoard = newBoard.insert(i+1,nowChar);
                if(missing == 2) newBoard = newBoard.insert(i+1,nowChar);
                //update the number of balls in hand
                hand.put(nowChar, hand.get(nowChar)-missing);
                //shrink board
                shrinkBoard(newBoard);
                System.out.println(board + "-" + newBoard + "*" + nowChar);
                //find the min for the new board
                int res = helper(newBoard, hand);
                //if find a way to remove all balls
                if(res != -1) {
                    min = Math.min(min, res+missing);
                    System.out.println(min);
                }
                //recover the balls in hand for further computation
                hand.put(nowChar, hand.get(nowChar)+missing);

            }
            System.out.println();
            count = 1;

        }
        return min == Integer.MAX_VALUE ? -1:min;
    }

    //method to shrink the board if possible.
    public void shrinkBoard(StringBuilder b) {
        if(b.length() < 3) return;
        boolean clean = true;
        int count = 0;
        char c = b.charAt(0);
        for (int i = 0; i < b.length(); i++) {
            if(b.charAt(i) == c) count++;
            else {
                if(count >= 3) {
                    b.delete(i-count,i);
                    clean = false;
                    count = 0;
                    break;
                } else {
                    c = b.charAt(i);
                    count = 1;
                }
            }
        }
        if(count >= 3) {
            b.delete(b.length()-count, b.length());
            clean = false;
        }

        if(!clean) shrinkBoard(b);
    }
    //test hand is empty or not.
    public boolean handIsEmpty(Map<Character,Integer> hand) {
        for(int temp:hand.values()) {
            if(temp != 0 ) return false;
        }
        return true;
    }
}
