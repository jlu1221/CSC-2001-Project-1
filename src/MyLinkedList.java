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
    // insertAfter method
    // searchIByD method
    // search ByMentor method
    // remove method
    // registerParticipant method
    // display method


}
