import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;  
      

    public class PhoneBook {  
        public static Scanner input = new Scanner (System.in);  
        public static BST contacts = new BST();  
        public static LinkedList <Events> events = new LinkedList <Events>();  
          
        public static void AddContact(){  
            Contact c = new Contact();  
            System.out.print("Enter the contact\'s name: ");  
            input.nextLine();  
            c.name = input.nextLine();  
              
            if (!contacts.empty() && contacts.findkey(c.name))  
            {  
                    System.out.println("Contact found!");  
                    return;  
            }  
            System.out.print("Enter the contact's phone number:");  
            c.phoneNumber = input.nextLine();  
              
            if (!contacts.empty() && (contacts.SearchPhone(c.phoneNumber)))  

            {  
                System.out.println("phone number found!");  
                return;  
            }  
            System.out.print("Enter the contact's email address: ");  
            c.emailAddress = input.nextLine();  
              
            System.out.print("Enter the contact's address: ");  
            c.address = input.nextLine();  
              
            System.out.print("Enter the contact's birthday: ");  
            try{
            c.dateOfBirth = new Date(input.nextLine());  
            }catch(IllegalArgumentException e){
                System.out.println("please choose a correct format as indicated: (MM/DD/YYYY)");
                return;
            }
            System.out.print("Enter any notes for the contact: ");  
            c.notes = input.nextLine();  
              
            if (contacts.addSort(c.name, c))  
                System.out.println("Contact added successfully!");  
        }  
      
        public static void SearchContact()  
        {  
            
            System.out.println("Enter search criteria:"); 
             System.out.println("1. Name");  
            System.out.println("2. Phone Number");  
            System.out.println("3. Email Address");  
            System.out.println("4. Address");  
            System.out.println("5. Birthday");  
            System.out.println("\nEnter your choice: ");   
            int choice = input.nextInt();  
        
            if (contacts.empty())  
                System.out.println("There is no contacts!");  
            else  
            {  
                switch (choice)  
               {  
                   case 1:  
                   {  
                        System.out.print("Enter the contact\'s name: ");  
                        input.nextLine();  
                        String name = input.nextLine();  
                          
                        if (contacts.findkey(name))  
                        {  
                            System.out.println("Contact found!");  
                            System.out.println(contacts.retrieve().toString());  
                            break;  
                        }  
                        System.out.println("The contact does not exist!");  
                   }  
                   break;  
      
                   case 2:  
                   {  
                       System.out.print("Enter the contact's phone number:");  
                       input.nextLine();  
                        String phoneNum = input.nextLine();  

                        if (contacts.SearchPhone(phoneNum))  
                        {  
                            System.out.println("Contact found!");  
                              
                            System.out.println(contacts.retrieve());  
                            break;  
                        }  
                        System.out.println("The contact does not exist!");  
                   }  
                   break;  
                   case 3:  
                   {  
                       System.out.print("Enter the contact's email address: ");  
                       input.nextLine();  
                        String emailaddress = input.nextLine();  
                         
                        if (!contacts.empty())  
                        {  
                            contacts.SearchEmail(emailaddress);  
                            System.out.println("Contact found!");  
                            break;  
                        }  
                        System.out.println("Contacts could not found!");  
                   }                  
                   break;  
      
                   case 4:  
                   {  
                       System.out.print("Enter the contact's address: ");  
                       input.nextLine();  
                        String address = input.nextLine();  
                        if (!contacts.empty() )  
                        {  
                            contacts.SearchAddress(address);  
                            System.out.println("Contact found!");  
                            break;  
                        }  
                        System.out.println("Contacts could not found!");  
                   }                  
                   break;  
      
                   case 5:  
                   {  
                       System.out.print("Enter the contact's Birthday: ");  
                        Date birthday = new Date(input.next());  
                        if (!contacts.empty() )  
                        {  
                            contacts.SearchBirthday(birthday);  
                            System.out.println("Contact found!");  
                            break;  
                        }  
                        System.out.println("The contact does not exist!");  
                   }  
               }  
            }              
        }  
          
        public static void DeleteContact()  
        {  
            if (contacts.empty()) 
            {
                System.out.println("there is no contacts! please add a contact first"); 
                return;
            } 
            Contact delContact = new Contact();  
              
            System.out.print("Enter the contact\'s name: ");  
            input.nextLine();  
            delContact.name = input.nextLine();  
             
                  
                if ( contacts.findkey(delContact.name)==false)  
                    System.out.println("Contact not found!");  
                else  
                {  
                    delContact = contacts.retrieve();  
                    contacts.removeKey(delContact.name);  
                    if (delContact.events.isEmpty()== false)  
                    {  
                        delContact.events.findFirst();  
                        while( delContact.events.current != null) 
                        {  
                            Events e = delContact.events.retrieve();  
                            if (Events.checkSameEvent(events, e))  
                            {  
                                Events Update_Event = events.retrieve();  
                                  
                                Update_Event.removeContact(delContact.name);  
                                if (Update_Event.contactsNames.isEmpty())  
                                {  
                                    events.remove(e);  
                                    System.out.println("Event deleted!");  
                                }  
                                else  
                                    events.update(Update_Event);  
                                  
                            }  
                            delContact.events.findNext();  
                        }  
                    }  
                    System.out.println("Contact Deleted Successfully !");  
                    System.out.println(delContact);  
                }                
        }  
          
        public static void ScheduleEvent()  
        {  
            if(contacts.empty())
                {
                    System.out.println("there is no contacts! please add a contact first");
                    return;
                }
            Contact C1 = new Contact();  
            Events E1 = new Events();   
            System.out.println("Enter type:");  
            System.out.println("1. event");  
            System.out.println("2. appointment");  
            System.out.println("\nEnter your choice: ");  
            int choice = input.nextInt();
            switch(choice){
            case 1:  
            {  
                  
                E1.isEvent = true;  
                System.out.print("Enter event title: ");  
                input.nextLine();  
                E1.eventTitle = input.nextLine();  
                  
                System.out.print("Enter contacts name: ");  
                C1.name= input.nextLine();  
                  try{
                System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");  
                E1.date = new Date (input.next()); 
                E1.time = input.next();  
                    }  catch(IllegalArgumentException ec){
                System.out.println("please choose a correct format as indicated: (MM/DD/YYYY)");
                return; 
                    }
      
                System.out.print("Enter event location: ");  
                input.nextLine();  
                E1.location = input.nextLine();  
              
                    if ( contacts.findkey(C1.name) == true)  
                    {  
                        if(Events.checkDatesConflict(events, E1)&&Events.checkSameEvent(events, E1)==false)
                        {
                            System.out.println("Conflict of events");  
                            return;
                        }
                        C1 = contacts.retrieve();  
                       
                            C1.events.addSort(E1);
                            // event added to C1  
                            contacts.update(C1.name,C1);  
                            if ( Events.checkSameEvent(events, E1)) 
                            {  
                                Events eventFound = events.retrieve();  
                                eventFound.contactsNames.addSort(C1.name);  
                                events.update(eventFound);  
                            }  
                              
                            if (Events.checkSameEvent(events, E1)== false)    
                            {  
                                    E1.contactsNames.addSort(C1.name);  
                                    events.addSort(E1);  
                                
                            }  
                            System.out.println("Events scheduled successfully for " + C1.name + "  !");  
                     
                    }  
                    else  
                        System.out.println("Contact " + C1.name + " not found !");   
                        break;                                  
            }  // Event Scheduled. 
            case 2: 
            { // schedule appointment  
                E1.isEvent = false;  
                System.out.print("Enter appointment title: ");  
                input.nextLine();  
                E1.eventTitle = input.nextLine();  
              
                System.out.print("Enter contact name: ");  
                C1.name = input.nextLine();  
              
                if ( contacts.findkey(C1.name) == true)  
                {  
                    C1 = contacts.retrieve();  
                      try{
                    System.out.print("Enter appointment date and time (MM/DD/YYYY HH:MM): ");  
                    E1.date = new Date (input.next());  
                    E1.time = input.next();  
                }catch(IllegalArgumentException ec){
                System.out.println("please choose a correct format as indicated: (MM/DD/YYYY)");
                return;}
                    System.out.print("Enter appointment location: ");  
                    input.nextLine();  
                    E1.location = input.nextLine();  
      
                    if (Events.checkSameEvent(events, E1)||Events.checkDatesConflict(events, E1))  
                    {  
                        System.out.println("Appointment had been scheduled previously, could not add more contacts, try again \n or the time slot is unavalible");  
                    }  
                    else  
                    {  
                        
                        if (C1.events.addSort(E1))  
                        {  
                            contacts.update(C1.name,C1);  
                            E1.contactsNames.addSort(C1.name);  
                            events.addSort(E1);  
                            System.out.println("Appointment scheduled successfully! ");  
                        }  
                        else  
                            System.out.println("Contact has conflict Events/Appoinment! ");  
                        }  
                }      
                else  
                    System.out.println("contact not found !"); 
                    break; 
            } // Appointment scheduled  
            default:{
                System.out.println("wrong input try again!");
                break;
            }
        }      
        }  
        // method searches for an event and print its details
        public static void PrintEvent(){   
            if(contacts.empty()||events.isEmpty())
            {
                System.out.println("There is no events!");
                return;
            }

              System.out.println("Enter search criteria:");  
            System.out.println("1. contact name");  
            System.out.println("2. Events title");  
            System.out.println("\nEnter your choice: ");  
            int choice = input.nextInt();  
            switch ( choice )  
            {  
                case 1:  
                {  
                    Contact c = new Contact();  
                    System.out.print("Enter the contact name:  ");  
                    input.nextLine();  
                    c.name = input.nextLine();  
                      if (contacts.findkey(c.name) == true)  
                      {  
                        System.out.println("Contact found !");  
                        c = contacts.retrieve();  
      
                        if (c.events.isEmpty())  
                            System.out.println("No events found for this contact !");  
                          
                        c.events.findFirst();  
                        while( c.events.current != null) 
                        {  
                            Events e = c.events.retrieve();  
                            if (Events.checkSameEvent(events, e))  
                                System.out.println(events.retrieve().toString());  
                            c.events.findNext();  
                        }
                    }
                        else 
                        System.out.println("Contact not found !");  
                }  
                break;  
      
                case 2:  
                {  
                    Events E1 = new Events();  
                    int count=0;
                    System.out.print("Enter the event title:  ");  
                    input.nextLine();  
                    E1.eventTitle = input.nextLine();  
                        events.findFirst();  
                        while( events.current != null) 
                        {     
                            if (events.retrieve().compareTo(E1) == 0)  
                            {  
                                if (events.retrieve().isEvent == true) 
                                    System.out.println("Event found!");  
                                else  
                                    System.out.println("Appointment found!");  
                                  
                                Events E2 = events.retrieve();  
                                System.out.println(E2);  
                                count++;
                            }  
                            events.findNext();  
                        }  
                        if(count==0)
                        System.out.println("Events or Appointment not found !");  
                }  
                break;  
            }  
        }  
          
        public static void PrintContactsFirstName(){  
             
            System.out.print("Enter the first name:");  
           String firstName = input.next().trim();  
              
            if (contacts.empty())  
                System.out.println("No Contacts found !");  
            else  
                contacts.SearchSameFirstName(firstName);  
        }  
          
        public static void printAllEventsAlphabetically(){  
            int count = 1;
            if (events.isEmpty()) // check if there is no events
                System.out.println("No events found !");
    
            else {
                events.findFirst();
                while (events.current != null) {
                    if(events.retrieve().isEvent)
                    System.out.println(count + ". Event : " + events.retrieve().eventTitle);
                    else
                        System.out.println(count + ". Appointment: " + events.retrieve().eventTitle);
                    events.findNext();
                    count++;
                }
            }
        }  
              
        public static void main(String[] args) {                
            System.out.println("Welcome to the BST Phonebook!");  
            int userInput=0;
            do {  
                try{
             System.out.println("Please choose an option:");  
            System.out.println("1. Add a contact");  
            System.out.println("2. Search for a contact");  
            System.out.println("3. Delete a contact");  
            System.out.println("4. Schedule an event/Appoinment");  
            System.out.println("5. Print event details");  
            System.out.println("6. Print contacts by first name");  
            System.out.println("7. Print all events alphabetically");  
            System.out.println("8. Exit");  
            System.out.print("\nEnter your choice: ");  
           
             userInput = input.nextInt();
                
                switch (userInput)  
                {  
                    case 1:  
                        AddContact();  
                        break;  
                      
                    case 2:  
                        SearchContact();  
                        break;  
                      
                    case 3:  
                        DeleteContact();  
                        break;  
                      
                    case 4:  
                        ScheduleEvent();  
                        break;  
                      
                    case 5:  
                        PrintEvent();  
                        break;  
                          
                    case 6:  
                        PrintContactsFirstName();  
                        break;  
                          
                    case 7:  
                        printAllEventsAlphabetically();  
                        break;  
                          
                    case 8:  
                        System.out.println("Goodbye!");  
                        break;  
                    default :  
                        System.out.println("Bad choice! Try again");  
                }  
                System.out.println("\n\n");
                
             } catch (InputMismatchException ex) {
                System.out.println("please choose a number from 1 to 8.\n your choice was: " + input.nextLine());
            }
        
            }while (userInput != 8);  
        
        }  
              
    }  
