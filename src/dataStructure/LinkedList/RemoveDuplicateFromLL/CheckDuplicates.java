package dataStructure.LinkedList.RemoveDuplicateFromLL;

/**
 * Explanation #
 *
 * This solution is simply a brute force solution. In this solution, we traverse the linked
 * list using two loops. The pointer current keeps track of the outer loop, and the pointer
 * compare is used for the inner loop. When both of these pointers point to the same value,
 * then that node is deleted.
 *
 * This is not the most efficient approach to solve this problem. It can also be solved
 * using a Hash Table.
 *
 * Time Complexity #

 * This algorithm has two nested loops. Hence, the time complexity is O(n^2).
 */

class CheckDuplicates {
    public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node current = list.headNode; // will be used for outer loop
        SinglyLinkedList<T>.Node compare = null;          // will be used for inner loop

        while (current != null && current.nextNode != null) {
            compare = current;
            while (compare.nextNode != null) {
                if (current.data.equals(compare.nextNode.data)) { //check if duplicate
                    compare.nextNode = compare.nextNode.nextNode;
                } else {
                    compare = compare.nextNode;
                }
            }
            current = current.nextNode;
        }
    }
    public static void main( String args[] ) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        for(int i = 0; i < 9; i++)
            list.insertAtEnd(i);
        list.insertAtEnd(0);
        list.insertAtEnd(1);
        System.out.print("Before ");
        list.printList();
        removeDuplicates(list);
        System.out.print("After ");
        list.printList();
    }
}