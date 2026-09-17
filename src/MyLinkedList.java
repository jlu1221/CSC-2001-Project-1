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
    // Purpose: this method adds an item to the existing session list and updates the list with the new sessions. Best use with sessionID
    public void insertAfter(Session session) {
        Node newNode = new Node();
        newNode.session = session;

        // beginning node
        Node current = head;

        // look for the session before the new one
        while (current.next != null) {

            if (current.session.getSessionID() == session.getSessionID() - 1) {
                newNode.next = current.next;
                current.next = newNode;
                return;
            }

            current = current.next;
        }
    }
    // searchIByD method
    // search ByMentor method
    // remove method
    // registerParticipant method

    // display method
    // Purpose: display method prints at the list in output
    public void display() {
        Node current = head;

        while (current != null) {
            System.out.println(current.session);
            current = current.next;
        }
    }



}
