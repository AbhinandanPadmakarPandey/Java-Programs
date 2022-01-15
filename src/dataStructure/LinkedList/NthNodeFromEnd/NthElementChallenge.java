package dataStructure.LinkedList.NthNodeFromEnd;

class NthElementChallenge {

    public static <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n) {
        int size = list.getSize();
        n = size - n + 1; //we can use the size variable to calculate distance from start
        if (size == 0 || n > size) {
            return null; //returns null if list is empty or n is greater than size
        }
        SinglyLinkedList.Node current = list.getHeadNode();
        int count = 1;
        //traverse until count is not equal to n
        while (current != null) {
            if (count == n)
                return current.data;
            count++;
            current = current.nextNode;
        }
        return null;
    }
    public static void main( String args[] ) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.printList(); //list is empty
        System.out.println("3rd element from end : " + nthElementFromEnd(sll, 3)); //will return null
        for(int i=0; i<15; i+=2){
            sll.insertAtHead(i);
        }
        sll.printList(); // List is 14 -> 12 -> 10 -> 8 -> 6 -> 4 -> 2 -> 0 -> null
        System.out.println("3rd element from end : " + nthElementFromEnd(sll, 3)); //will return 4
        System.out.println("10th element from end : " + nthElementFromEnd(sll, 10));//will return null
    }
}