package DivideAndConquer;

/**
 * Created by li on 1/6/2017.
 */
public class MergeKSortedLists23Jan6 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    /**
     * TLE 把排两个list思想挪到排n个list 不管用
     * */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        ListNode dummyHead = new ListNode(0);
        ListNode c = dummyHead;

        while(true){
            int flag = -1;
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] != null) {
                    if(flag == -1 || lists[flag].val > lists[i].val) {
                        flag = i;
                    }
                }
            }
            if(flag == -1) break;
            c.next = lists[flag];
            c = c.next;
            lists[flag] = lists[flag].next;

        }
        return dummyHead.next;
    }
}
