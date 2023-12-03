import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;  
      
    /* 
     This class will represent the phonebook application itself. It should have a field for  
    the linked list ADT that stores the contacts and methods for interacting with the list (e.g., adding,  
    searching, and deleting contacts). You will also need to schedule events and appointments with  
    contacts. 
    */  
      
    public class PhoneBook {  
        public static Scanner input = new Scanner (System.in);  
        public static BST contacts = new BST();  
        public static LinkedList <Events> events = new LinkedList <Events>();  
          
        // public static int menu ()  
        // {  
        //     System.out.println("Please choose an option:");  
        //     System.out.println("1. Add a contact");  
        //     System.out.println("2. Search for a contact");  
        //     System.out.println("3. Delete a contact");  
        //     System.out.println("4. Schedule an event/Appoinment");  
        //     System.out.println("5. Print event details");  
        //     System.out.println("6. Print contacts by first name");  
        //     System.out.println("7. Print all events alphabetically");  
        //     System.out.println("8. Exit");  
        //     System.out.println("\nEnter your choice: ");  
        //     int choice = input.nextInt();  
              
        //     return choice;  
        // }  
          
        // public static int submenu2()  
        // {  
        //     System.out.println("Enter search criteria:");  
        //     System.out.println("1. Name");  
        //     System.out.println("2. Phone Number");  
        //     System.out.println("3. Email Address");  
        //     System.out.println("4. Address");  
        //     System.out.println("5. Birthday");  
        //     System.out.println("\nEnter your choice: ");  
        //     int choice = input.nextInt();  
        //     return choice;  
        // }  
      
        // public static int submenu5()  
        // {  
        //     System.out.println("Enter search criteria:");  
        //     System.out.println("1. contact name");  
        //     System.out.println("2. Events tittle");  
        //     System.out.println("\nEnter your choice: ");  
        //     int choice = input.nextInt();  
        //     return choice;  
        // }  
      
        // public static int submenu6()  
        // {  
        //     System.out.println("Enter type:");  
        //     System.out.println("1. event");  
        //     System.out.println("2. appointment");  
        //     System.out.println("\nEnter your choice: ");  
        //     int choice = input.nextInt();  
        //     return choice;  
        // }  
      
          
        //1. Add a contact  
        public static void AddContact(){  
            Contact c = new Contact();  
            System.out.println("Enter the contact\'s name: ");  
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
      
        //2. Search for a contact  
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
                        String phonenumber = input.nextLine();  

                        if (contacts.SearchPhone(phonenumber))  
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
                         
                            if(contacts.SearchEmail(emailaddress)){  
                            System.out.println("Contact found!");  
                            break;  
                        }  
                        System.out.println("The contact does not exist!");  
                   }                  
                   break;  
      
                   case 4:  
                   {  
                       System.out.print("Enter the contact's address: ");  
                       input.nextLine();  
                        String address = input.nextLine();  
                        if (contacts.SearchAddress(address) )  
                        {  
                            System.out.println("Contact found!");  
                            break;  
                        }  
                        System.out.println("The contact does not exist!");  
                   }                  
                   break;  
      
                   case 5:  
                   {  
                    Date birthday;
                       System.out.print("Enter the contact's Birthday: ");  

                       try{
                         birthday = new Date(input.next());
                       } catch(IllegalArgumentException e){
                System.out.println("please choose a correct format as indicated: (MM/DD/YYYY)");
                return;
            }
                        if (contacts.SearchBirthday(birthday))  
                        {  
                            System.out.println("Contact found!");  
                            break;  
                        }  
                        System.out.println("The contact does not exist!");  
                   }  
               }  
            }              
        }  
          
        //3. Delete a contact  
        public static void DeleteContact()  
        {  
            Contact c = new Contact();  
              
            System.out.print("Enter the contact\'s name: ");  
            input.nextLine();  
            c.name = input.nextLine();  
             
            if (contacts.empty())  
                System.out.println("Contact not found!");  
            else  
            {  
                  
                if ( contacts.findkey(c.name)==false)  
                    System.out.println("Contact not found!");  
                else  
                {  
                    c = contacts.retrieve();  
                    contacts.removeKey(c.name);  
                    if (! c.events.isEmpty())  
                    {  
                        c.events.findFirst();  
                        while( c.events.current != null) 
                        {  
                            Events e = c.events.retrieve();  
                            if ( (!events.isEmpty()) && events.search(e)   
                                    && (events.retrieve().date.compareTo(e.date)==0)   
                                    && (events.retrieve().time.compareTo(e.time)==0)  
                                    && (events.retrieve().location.compareTo(e.location)==0)  
                                    && (events.retrieve().isEvent== e.isEvent))  
                            {  
                                Events Update_Event = events.retrieve();  
                                  
                                Update_Event.removeContact(c.name);  
                                if (Update_Event.contactsNames.isEmpty())  
                                {  
                                    events.remove(e);  
                                    System.out.println("Delete event, No cantact particapate");  
                                }  
                                else  
                                    events.update(Update_Event);  
                                  
                            }  
                            c.events.findNext();  
                        }  
                    }  
                    System.out.println("Contact Deleted Successfully !");  
                    System.out.println(c);  
                }      
            }          
        }  
          
        //4. Schedule an event  
        public static void ScheduleEvent()  
        {  
            if(contacts.empty())
                {
                    System.out.println("there is no contacts! please add a contact first");
                    return;
                }
            Contact c = new Contact();  
            Events e = new Events();  
              
            boolean event_Updated = false;              
             System.out.println("Enter type:");  
            System.out.println("1. event");  
            System.out.println("2. appointment");  
            System.out.println("\nEnter your choice: ");  
            int choice = input.nextInt();
            switch(choice){
            case 1:  
            {  
                  
                e.isEvent = true;  
                System.out.print("Enter event eventTitle: ");  
                input.nextLine();  
                e.eventTitle = input.nextLine();  
                  
                System.out.print("Enter contacts name separated by a comma: ");  
                String line = input.nextLine();  
                String [] names = line.split(",");  
                  try{
                System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");  
                e.date = new Date (input.next()); 
                e.time = input.next();  
                    }  catch(IllegalArgumentException ec){
                System.out.println("please choose a correct format as indicated: (MM/DD/YYYY)");
                return; 
                    }
      
                System.out.print("Enter event location: ");  
                input.nextLine();  
                e.location = input.nextLine();  
                  
                for ( int i = 0 ; i < names.length ; i++){      
                    c.name = names[i].trim();  
              
                    if ( contacts.findkey(c.name) == true)  
                    {  
                        c = contacts.retrieve();  
                        // Added_Event_To_Contact =c.events.addSort(e);
                        
                        if (c.addEvent(e))  
                        {  
                            c.events.addSort(e);
                            // event added to contact  
                            contacts.update(c.name,c);  
                            if ( (!events.isEmpty()) && events.search(e)   
                                    && (events.retrieve().date.compareTo(e.date)==0)   
                                    && (events.retrieve().time.compareTo(e.time)==0)  
                                    && (events.retrieve().location.compareTo(e.location)==0)  
                                    && (events.retrieve().isEvent== e.isEvent))  
                            {  
                                Events eventFound = events.retrieve();  
                                eventFound.contactsNames.addSort(c.name);  
                                events.update(eventFound);  
                                event_Updated = true;  
                            }  
                              
                            if (! event_Updated)    
                            {  
                                    e.contactsNames.addSort(c.name);  
                                    events.addSort(e);  
                            }  
                            System.out.println("Events scheduled successfully for " + c.name + "  !");  
                        }  
                        else  
                            System.out.println("Contact has conflict Events for " + c.name + "  !");  
                    }  
                    else  
                        System.out.println("Contact " + c.name + " not found !");   
                        break;                                  
                 } // end for   
                 break;
            }  // end schedule event  
            case 2: 
            { // schedule appoinment  
                e.isEvent = false;  
                System.out.print("Enter appointment eventTitle: ");  
                input.nextLine();  
                e.eventTitle = input.nextLine();  
              
                System.out.print("Enter contact name: ");  
                c.name = input.nextLine();  
              
                if ( contacts.findkey(c.name) == true)  
                {  
                    c = contacts.retrieve();  
                      try{
                    System.out.print("Enter appoinment date and time (MM/DD/YYYY HH:MM): ");  
                    e.date = new Date (input.next());  
                    e.time = input.next();  
                }catch(IllegalArgumentException ec){
                System.out.println("please choose a correct format as indicated: (MM/DD/YYYY)");
                return;}
                    System.out.print("Enter appoinment location: ");  
                    input.nextLine();  
                    e.location = input.nextLine();  
      
                    if ( (!events.isEmpty()) && events.search(e)   
                            && (events.retrieve().date.compareTo(e.date)==0)   
                            && (events.retrieve().time.compareTo(e.time)==0)  
                            && (events.retrieve().location.compareTo(e.location)==0)  
                            && (events.retrieve().isEvent== e.isEvent))  
                    {  
                        System.out.println("Appointment had been scheduled previously, could not add more contacts, try again ");  
                    }  
                    else  
                    {  
                        
                        if (c.addEvent(e))  
                        {  
                            // event added to contact  
                            c.events.addSort(e);
                            contacts.update(c.name,c);  
                            e.contactsNames.addSort(c.name);  
                            events.addSort(e);  
                            System.out.println("Appoinment scheduled successfully!   ");  
                        }  
                        else  
                            System.out.println("Contact has conflict Events/Appoinment !  ");  
                        }  
                }      
                else  
                    System.out.println("contact not found !"); 
                    break; 
            } // end schedule appoinment    
            default:{
                System.out.println("wrong input try again!");
                break;
            }
        }      
        }  
          
        //5. Print event details  
        public static void PrintEvent(){   
              System.out.println("Enter search criteria:");  
            System.out.println("1. contact name");  
            System.out.println("2. Events tittle");  
            System.out.println("\nEnter your choice: ");  
            int choice = input.nextInt();  
            switch ( choice )  
            {  
                case 1:  
                {  
                    Contact c = new Contact();  
                    System.out.print("Enter the contact name :  ");  
                    input.nextLine();  
                    c.name = input.nextLine();  
                              
                    if (! contacts.empty() )  
                    {  
                      if (contacts.findkey(c.name) == true)  
                      {  
                        System.out.println("Contact found !");  
                        c = contacts.retrieve();  
      
                        if (c.events.isEmpty())  
                            System.out.println("No events found for this contact !");  
                         }  
                        c.events.findFirst();  
                        while( c.events.current != null) 
                        {  
                            Events e = c.events.retrieve();  
                            if (!events.isEmpty() && events.search(e)   
                                    && (events.retrieve().date.compareTo(e.date)==0)   
                                    && (events.retrieve().time.compareTo(e.time)==0)  
                                    && (events.retrieve().location.compareTo(e.location)==0)  
                                    && (events.retrieve().isEvent== e.isEvent))  
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
                    Events e = new Events();  
                    System.out.print("Enter the event eventTitle:  ");  
                    input.nextLine();  
                    e.eventTitle = input.nextLine();  
                      
                   if (! events.isEmpty())  
                    {  
                        events.findFirst();  
                        while( events.current != null) 
                        {     
                            if (events.retrieve().compareTo(e) == 0)  
                            {  
                                if (events.retrieve().isEvent == true)  
                                    System.out.println("Events found!");  
                                else  
                                    System.out.println("Appoinment found!");  
                                  
                                Events ee = events.retrieve();  
                                System.out.println(ee);  
                            }  
                            events.findNext();  
                        }  
                    }  
                    else  
                        System.out.println("Events/Appoinment not found !");  
                }  
                break;  
            }  
        }  
          
        //6. Print contacts by first name  
        public static void PrintContactsFirstName(){  
             
            System.out.print("Enter the first name:");  
           String fname = input.next().trim();  
              
            if (contacts.empty())  
                System.out.println("No Contacts found !");  
            else  
                contacts.SearchSameFirstName(fname);  
        }  
          
        //7. Print all events alphabetically // O(n)  
        public static void PrintAllEvents(){  
            // if (!events.isEmpty())  
            //     System.out.println(events.toString());  
            // else  
            //     System.out.println("No events found !");  
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
            System.out.println("\nEnter your choice: ");  
           
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
                        PrintAllEvents();  
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
