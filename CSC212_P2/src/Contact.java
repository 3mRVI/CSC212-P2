    import java.util.Date;  
      
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
      
    //     public boolean checkConflict( Events e)  
    //     {  
    // {  
    //             events.findFirst();  
    //                 if (! events.isEmpty())  
    //                 {  
    //                     while( events.current !=null) 
    //                     {   
    //                         if ((events.retrieve().date.compareTo(e.date) == 0)   
    //                                 && (events.retrieve().time.compareTo(e.time) == 0))  
    //                             return false;  
    //                         events.findNext();
    //                     }  
    //               }  
                  
    //             return true;  
    //         }  
    //     }  
      
        // public boolean removeEvent( String etitle)  
        // {  
        //     if (events.isEmpty())  
        //         return false;  
        //    Events val = new Events();  
        //    val.eventTitle = etitle;  
        //     if (events.search(val))  
        //     {  
        //         events.remove(val);  
        //         return true;  
        //     }  
        //     return false;  
        // }  
          
        @Override  
        public int compareTo(Contact o) {  
         
                return (this.name.compareToIgnoreCase(o.name));  
            }  
      
      
          
        public int compareToPhone(String Phone) {  
         
                return (this.phoneNumber.compareToIgnoreCase(Phone));
         
        }
        public int compareToEmail(String emailaddress) {  
             
                return (this.emailAddress.compareToIgnoreCase(emailaddress)); 
        }
      
        public int compareToAddress(String address) {  
           
                return (this.address.compareToIgnoreCase(address));  
            }  
        
      
        public int compareToBirthday(Date birthday) {  
          
                return (this.dateOfBirth.compareTo(birthday) ) ;  
        }  
          
        public int compareFirstName(String n) {  
                String [] new_name = this.name.split(" ");  
                return (new_name[0].trim().compareToIgnoreCase(n) ) ;  
        } 
     }  
