    import java.util.Date;  
      
    /* 
    Contact: This class will represent a single contact in the phonebook. It should have fields for the  
    contact’s name, phone number, email address, 
    address, birthday, and notes.  
    */  
      
    public class Contact implements Comparable<Contact> {  
        String name, phoneNumber, emailAddress, address, notes;  
        Date dateOfBirth; //20/11/2023  
        LinkedList<Events> events ;   
         
        public Contact() {  
            this.name = "";  
            this.phoneNumber = "";  
            this.emailAddress = "";  
            this.address = "";  
            this.dateOfBirth = null;  
            this.notes = "";  
            events = new LinkedList<Events>();  
        }  
      
        public Contact(String name, String phonenumber, String emailaddress, String address, String birthday, String notes) {  
            this.name = name;  
            this.phoneNumber = phonenumber;  
            this.emailAddress = emailaddress;  
            this.address = address;  
            this.dateOfBirth = new Date(birthday);  
            this.notes = notes;  
            events = new LinkedList<Events>();  
        }  
      
        @Override  
        public String toString() {  
            String cont="";
            String cont1="";
            cont= "\nName: " + name +  
                        "\nPhone Number: " + phoneNumber +  
                        "\nEmail Address: " + emailAddress +  
                        "\nAddress: " +  address +  
                        "\nBirthday: " + dateOfBirth +  
                        "\nNotes: " + notes +   
                        "\nEvents : ";  
                        events.findFirst();
                        while (events.current !=null) {
                            cont1+= events.retrieve();
                            events.findNext();
                        }
            return cont+cont1;
        }  
      
        public boolean addEvent( Events e)  
        {  
    //        if ((e.EventType) || (!e.EventType && e.contacts_names.size==0))  
    {  
                events.findFirst();  
                    if (! events.isEmpty())  
                    {  
                        while( events.current !=null) 
                        {   
                            if ((events.retrieve().date.compareTo(e.date) == 0)   
                                    && (events.retrieve().time.compareTo(e.time) == 0))  
                                return false;  
                            events.findNext();
                        }  
                  }  
                  
                return true;  
            }  
            //return false;  
        }  
      
        public boolean removeEvent( String etitle)  
        {  
            if (events.isEmpty())  
                return false;  
           Events val = new Events();  
           val.eventTitle = etitle;  
            if (events.search(val))  
            {  
                events.remove(val);  
                return true;  
            }  
            return false;  
        }  
          
        @Override  
        public int compareTo(Contact o) {  
            try {  
                return (this.name.compareToIgnoreCase(o.name)); //0 exit  
                                                                //- less  
                                                                //+ big  
            }  
            catch (Exception e)  
            {  
                 //To change body of generated methods, choose Tools | Templates.  
                throw new UnsupportedOperationException("Not supported yet.");  
            }  
        }  
      
          
        public int compareToPhone(String Phone) {  
            try {  
                return (this.phoneNumber.compareToIgnoreCase(Phone));//0 exit  
                                                                     //- less  
                                                                     //+ big  
            }  
            catch (Exception e)  
            {  
                 //To change body of generated methods, choose Tools | Templates.  
                throw new UnsupportedOperationException("Not supported yet.");  
            }  
        }  
      
        public int compareToEmail(String emailaddress) {  
            try {  
                return (this.emailAddress.compareToIgnoreCase(emailaddress));//0 exit  
                                                                             //- less  
                                                                             //+ big  
            }  
            catch (Exception e)  
            {  
                 //To change body of generated methods, choose Tools | Templates.  
                throw new UnsupportedOperationException("Not supported yet.");  
            }  
        }  
      
        public int compareToAddress(String address) {  
            try {  
                return (this.address.compareToIgnoreCase(address));  
            }  
            catch (Exception e)  
            {  
                 //To change body of generated methods, choose Tools | Templates.  
                throw new UnsupportedOperationException("Not supported yet.");  
            }  
        }  
      
        public int compareToBirthday(Date birthday) {  
            try {  
                return (this.dateOfBirth.compareTo(birthday) ) ;  
            }  
            catch (Exception e)  
            {  
                 //To change body of generated methods, choose Tools | Templates.  
                throw new UnsupportedOperationException("Not supported yet.");  
            }  
        }  
          
        public int compareFirstName(String n) {  
            try {  
                String [] new_name = this.name.split(" ");  
                return (new_name[0].trim().compareToIgnoreCase(n) ) ;  
            }  
            catch (Exception e)  
            {  
                 //To change body of generated methods, choose Tools | Templates.  
                throw new UnsupportedOperationException("Not supported yet.");  
            }  
        } 
     }  
