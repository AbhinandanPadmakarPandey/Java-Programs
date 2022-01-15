package dataStructure.LinkedList.DeleteLoopInLL;

/* Solution: Using Floyd’s Cycle Detection Algorithm */

/**
 * Explanation #
 * This is the most optimized method to find out the loop in the LinkedList.
 * We start traversing the LinkedList using two pointers called slow and fast.
 * Move slow by one (line # 22) and fast by two (line # 23). If these pointers meet at the same node, then there is a loop. If these pointers do not meet, then LinkedList doesn’t have a loop.
 *
 * Time Complexity #
 * The algorithm runs in Constant with O(n)O(n)O(n) with the Auxiliary Space complexity of O(1).
 */

public class CheckLoop {
    public static <T> boolean detectLoop(SinglyLinkedList<T> list) {
        SinglyLinkedList.Node slow = list.headNode;
        SinglyLinkedList.Node fast = list.headNode;

        while(slow != null && fast != null && fast.nextNode != null)
        {
            slow = slow.nextNode;	//the slow pointer will jump 1 step
            fast = fast.nextNode.nextNode; //the fast pointer will jump 2 steps
            // when the pointers become equal then there must be a loop
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main( String args[] ) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        System.out.println("Before adding loop: " + detectLoop(list));
        list.headNode.nextNode.nextNode = list.headNode;
        System.out.println("After adding loop: " + detectLoop(list));
    }
}