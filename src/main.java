public class main {

    public static void main(String[] args) {

        MyLinkedList sessions = new MyLinkedList();

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

        MyLinkedList list = new MyLinkedList();

        list.addFirst(session1);
        list.addLast(session2);
    }
}
