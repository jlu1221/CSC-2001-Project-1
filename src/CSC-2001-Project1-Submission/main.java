public class main {

    public static void main(String[] args) {

        MyLinkedList session = new MyLinkedList();

        Session session1 = new Session(
                101,
                "Electrical",
                "Alex",
                "Engineering",
                "10/31/26",
                "5:15 AM",
                "Room 808",
                5
        );

        Session session2 = new Session(
                102,
                "Computer Science",
                "Jordan",
                "Computer",
                "4/2/26",
                "11:00 PM",
                "Room 916",
                13
        );

        Session session3 = new Session(
                103,
                "Mandarin",
                "Katie",
                "Language",
                "12/25/26",
                "3:01 AM",
                "Room 912",
                357
        );

        Session session4 = new Session(
                104,
                "Analysis",
                "Joanna",
                "Mathematics",
                "12/24/26",
                "1:00 AM",
                "Room 711",
                28
        );

        // Creates a new session List
        MyLinkedList list = new MyLinkedList();

        // Testing methods

        // addFirst method
        System.out.println("Test addFirst:");
        System.out.println("_______________________________");

        list.addFirst(session1);

        System.out.println("List after: ");
        System.out.println("_______________________________");
        System.out.println(list.display());
        System.out.println("_______________________________");

        // addLast method
        System.out.println("Test addLast: ");
        System.out.println("_______________________________");

        list.addLast(session2);
        list.addLast(session4);

        System.out.println("List after: ");
        System.out.println("_______________________________");
        System.out.println(list.display());
        System.out.println("_______________________________");

        //insertAfter method
        System.out.println("Test insertAfter: ");
        System.out.println("_______________________________");

        list.insertAfter(session3);

        System.out.println("Inserted session3: ");
        System.out.println("_______________________________");
        System.out.println(list.display());
        System.out.println("_______________________________");

        // searchByID method
        System.out.println("Test searchById: ");
        System.out.println("_______________________________");

        System.out.println("Search for Session 102:");
        System.out.println("_______________________________");
        System.out.println(list.searchByID(102));
        System.out.println("_______________________________");

        System.out.println("Search for Session 101");
        System.out.println("_______________________________");
        System.out.println(list.searchByID(101));

        System.out.println("Search for non-existent Session");
        System.out.println("_______________________________");
        System.out.println(list.searchByID(99));
        System.out.println("_______________________________");

        // searchByMentor method
        System.out.println("Test searchByMentor: ");
        System.out.println("_______________________________");

        System.out.println("Search for Mentor: Katie");
        System.out.println("_______________________________");
        System.out.println(list.searchByMentor("Katie"));

        System.out.println("Search for Mentor: Joanna");
        System.out.println("_______________________________");
        System.out.println(list.searchByMentor("Joanna"));

        System.out.println("Search for Non-existent mentor: Josh");
        System.out.println("_______________________________");
        System.out.println(list.searchByMentor("Josh"));
        System.out.println("_______________________________");

        // remove method
        System.out.println("Test remove:");
        System.out.println("_______________________________");

        System.out.println("Before removing Session 2");
        System.out.println("_______________________________");
        System.out.println(list.display());
        System.out.println("_______________________________");
        System.out.println("removed: " + list.remove(session2));
        System.out.println("_______________________________");

        System.out.println("After removing");
        System.out.println("_______________________________");
        System.out.println(list.display());
        System.out.println("_______________________________");

        // registerParticipants
        System.out.println("Test registerParticipants: ");
        System.out.println("_______________________________");

        System.out.println("Registering participant for Session 101:");
        System.out.println("_______________________________");

        boolean registered = list.registerParticipant(session1);

        if (registered) {
            System.out.println("Participant registered");
        } else {
            System.out.println("Registration failed");
        }

        System.out.println("Current participants: " + session1.getCurrentParticipants());
        System.out.println("_______________________________");
        System.out.println("Check for max > current: ");
        System.out.println("_______________________________");
        Session smallSession = new Session(
                10,
                "Small Session",
                "Professor Einakian",
                "Computer Science",
                "9/13/26",
                "12:00 PM",
                "Room 333",
                1
        );

        System.out.println(list.registerParticipant(smallSession));
        System.out.println(list.registerParticipant(smallSession));
        System.out.println("_______________________________");
    }
}
