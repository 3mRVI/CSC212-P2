import java.util.Date;

public class Events implements Comparable<Events> {
    String eventTitle;
    String time;
    Date date;
    String eventLocation;
    LinkedList<String> ContactsNames;

    Events() {
        eventTitle = null;
        time = null;
        date = null;
        eventLocation = null;
        ContactsNames = new LinkedList<>();
    }

    public Events(String contactName, String eventTitle, String time, String date, String location) {
        this.eventTitle = eventTitle;
        this.time = time;
        this.date = new Date(date);
        eventLocation = location;
        ContactsNames = new LinkedList<>();
        ContactsNames.addSort(contactName);
    }

    public boolean AddContact(String CName) {
        return ContactsNames.addSort(CName);
    }

    public boolean removeContact(String CName) {
        return ContactsNames.remove(CName);
    }

    @Override
    public String toString() {
        String Container = "Event found!" +
                "\n Event's title: " + eventTitle + "\n Date and time: " + date + time +
                "\n Event's location: " + eventLocation +
                "\n Contacts's name: ";
        ContactsNames.findFirst();
        while (ContactsNames.current != null) {
            Container += ContactsNames.retrieve();
            ContactsNames.findNext();
        }
        return Container;
    }

    @Override
    public int compareTo(Events o) {
        return this.eventTitle.compareToIgnoreCase(o.eventTitle);
    }

}