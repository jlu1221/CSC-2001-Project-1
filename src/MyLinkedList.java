public class MyLinkedList {

    // Node class
    private Node head;

    private class Node {
        Session session;
        Node next;
    }

    // Constructor
    public MyLinkedList() {
        head = null;
    }

    // addFirst method
    // Purpose: add a session to the beginning of the linkedlist,
    public void addFirst(Session session) {
        Node newNode = new Node();
        newNode.session = session;
        newNode.next = head;
        head = newNode;
    }
    // addLast method
    // Purpose: add a session to the end of the list, always checking if the next node is null

    public void addLast(Session session) {
        Node newNode = new Node();
        newNode.session = session;
        newNode.next = null;

        // if list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        // start at the current node
        Node current = head;

        // Move down the list
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }
    // insertAfter method
    // searchIByD method
    // search ByMentor method
    // remove method
    // registerParticipant method

    // display method
    


}
