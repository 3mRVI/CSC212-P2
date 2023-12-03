    import java.util.Date;  
    public class Events implements Comparable<Events> {  
        String eventTitle;  
        Date date; 
        String time;  
        String location;  
        boolean isEvent;  // event true , appointment = false;  
        LinkedList <String> contactsNames;//if event has more than contact one contact
      
        public Events() {  
            this.eventTitle = "";  
            this.date = null;  
            this.time = "";  
            this.location = "";  
            this.isEvent = true;  
            this.contactsNames = new LinkedList<String> ();  
        }  
          
        public Events(String eventTitle, String date, String time, String location, boolean type, String contact) {  
            this.eventTitle = eventTitle;  
            this.date = new Date(date);  
            this.time = time;  
            this.location = location;  
            this.isEvent =type;  
            this.contactsNames = new LinkedList<String> ();  
            contactsNames.addSort(contact);  
        }  
      
        public boolean addContact (String contact)  
        {                    
            if ((this.isEvent == true) || ((this.isEvent == false)&&(contactsNames.isEmpty())))
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
       public static boolean checkSameEvent(LinkedList<Events> eList, Events e){
                if( (!eList.isEmpty()) && eList.search(e)   
                && (eList.retrieve().date.compareTo(e.date)==0)   
                && (eList.retrieve().time.compareTo(e.time)==0)  
                && (eList.retrieve().location.compareTo(e.location)==0)  
                && (eList.retrieve().isEvent== e.isEvent))
                return true;
            return false;

       }
       public static boolean checkDatesConflict(LinkedList<Events> eList, Events e){
        if(eList.isEmpty())
            return false;
        eList.findFirst();
        while (eList.current != null){
            if(eList.retrieve().date.compareTo(e.date)==0 &&
            eList.retrieve().time.compareToIgnoreCase(e.time)==0)
            return true;
            eList.findNext();
        }
        return false;
       }
        @Override  
        public String toString() {  
            String eType = (this.isEvent == true)? "Events ": "Appoinment ";    
            String rr="";   
            String container = "\n" + eType + " title: " + eventTitle +  
                        "\n " + eType + "  date and time (MM/DD/YYYY HH:MM): " + date + time +  
                       "\n" + eType + " location: " + location +  
                       "\nType: " + eType +  
                        "\nContacts names:   \n";
                        contactsNames.findFirst();
                        while(contactsNames.current !=null){ 
                        rr+=contactsNames.retrieve()+", ";  
                        contactsNames.findNext();
                        }
              return container+rr;  
        }  
          
          
        @Override  
        public int compareTo(Events obj) {  
                return (this.eventTitle.compareToIgnoreCase(obj.eventTitle)); 
        }  
 }  
