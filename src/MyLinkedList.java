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
    // searchByID method
    // Purpose: this method search for the ID given by the user and return the string ID
    public String searchByID(int id) {
        Node current = head;

        while (current != null) {
            if (current.session.getSessionID() == id ) {
                return current.session.toString();
            }

            current = current.next;
        }
        return "session not found";
    }
    // search ByMentor method
    // Purpose: this method search for the given mentor given by the user and return the string of the mentor's name
    public String searchByMentor(String name) {
        Node current = head;

        while (current != null) {
            if (current.session.getMentor().equals(name)) {
                return current.session.toString();
            }

            current = current.next;
        }

        return "No session found for mentor" + name;
    }
    // remove method
    // Purpose: this method will remove one of the session and return a string
    public String remove(Session session) {
        // If the list is empty
        if (head == null) {
            return "session not found";
        }

        // If the session to remove is the first node
        if (head.session.getSessionID() == session.getSessionID()) {
            head = head.next;
            return "Session has been removed";
        }

        Node current = head;

        // Search for the next node before removing
        while (current.next != null) {

            if (current.next.session.getSessionID() == session.getSessionID()) {
                current.next = current.next.next;
                return "Session has been removed";
            }

            current = current.next;
        }

        return "Session not found";
    }
    // registerParticipant method
    // Purpose: this method check if the current number of participants is less than the max amount, then add that participant (add 10
    public boolean registerParticipant(Session session) {

        if (session.getCurrentParticipants() < session.getMaxParticipants()) {
            session.setCurrentParticipants(session.getCurrentParticipants() + 1);

            return true;
        }

        return false;
    }


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
