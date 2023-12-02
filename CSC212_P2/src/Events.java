    import java.util.Date;  
      
    /* 
    Events: This class will represent events or appointment that can be scheduled with a contact. It  
    should have fields for the event title, date and time, location, and the contact involved in this  
    event. 
    */  
      
    public class Events implements Comparable<Events> {  
        String title;  
        Date date;//2023/11/24  
        String time;  
        String location;  
        boolean EventType;  // event true , appointment = false;  
        LinkedList <String> contactsNames;//if event have many contact  
      
        public Events() {  
            this.title = "";  
            this.date = null;  
            this.time = "";  
            this.location = "";  
            this.EventType = true;  
            this.contactsNames = new LinkedList<String> ();  
        }  
          
        public Events(String title, String date, String time, String location, boolean t, String contact) {  
            this.title = title;  
            this.date = new Date(date);  
            this.time = time;  
            this.location = location;  
            this.EventType =t;  
            this.contactsNames = new LinkedList<String> ();  
            contactsNames.addSort(contact);  
        }  
      
        public boolean addContact (String contact)  
        {                    
            if ((this.EventType == true) || ((this.EventType == false)&&(contactsNames.isEmpty())))
                return contactsNames.addSort(contact);  
              
            System.out.println("Could not add more than contact for an appoinment");  
            return false;  
        }  
      
        public boolean removeContact(String contact)  
        {  
                boolean name = contactsNames.remove(contact);  
                if ( name)  
                    return true;   
                return false;  
        }  
       
        @Override  
        public String toString() {  
            String EventT = (this.EventType == true)? "Events ": "Appoinment ";    
            String rr="";   
            String str = "\n" + EventT + " title: " + title +  
                        "\n " + EventT + "  date and time (MM/DD/YYYY HH:MM): " + date + time +  
                       "\n" + EventT + " location: " + location +  
                       "\nType: " + EventT +  
                        "\nContacts names:   \n";
                        contactsNames.findFirst();
                        while(contactsNames.current !=null){ 
                        rr+=contactsNames.retrieve()+", ";  
                        contactsNames.findNext();
                        }
              return str+rr;  
        }  
          
          
        @Override  
        public int compareTo(Events obj) {  
                return (this.title.compareToIgnoreCase(obj.title)); //0 eqal + big - less  
        }  
 }  
