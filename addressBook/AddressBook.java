/**
 * 
 * @author bagal
 * Date:05-11-2020
 * Functions:Creating an AddressBook for storing Contacts
 *
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBook {

    ArrayList<Contact> array=new ArrayList<Contact>(); // An arrayList of Contacts - each stores info for one friend

    //Uses information to store Contact class object in an arrayList
    public void addContact(String name, String address,String city,String state,double zipCode,double number) {
        array.add(new Contact(name,address,city,state,zipCode,number));
    }

    // Print out info on all contacts.
    public void printContacts() {
        //Getting Iterator
        Iterator<Contact> itr = array.iterator();
        while(itr.hasNext()) {
            Contact info=(Contact)itr.next();
            System.out.println("Name "+"\t"+info.getName()+"Address "+"\t"+info.getAddress()+"City "+"\t"+info.getCity()+"State "+"\t"+info.getState()
                    +"\t"+ "Zip Code "+"\t"+info.getZipCode()+"Phone Number "+"\t"+info.getNumber());
            System.out.println();
        }
    }

    // Returns the number of Contacts currently in AddressBook
    public int numContacts() {
        return array.size();
    }

    // Returns a non-negative integer if a Contact with phone is exists corresponding
    // to which place in the arrayList the Contact is stored. Returns -1
    // otherwise.
    private int haveContact(double ph) {
        for (Contact info:array)
            if (info.getNumber()==ph) {
                return array.indexOf(info);
            }
        return -1;
    }
    // Deletes a contact with phone number ph, if it is in the AddressBook.
    public void deleteContact(double ph) {
        int place = (int)haveContact(ph);
        if(place>=0) {
            array.remove(place);
        }
    }

    // Sorts the Address Book by Friend's Name
    public void sorting(){
        Collections.sort(array, Contact.nameComparator);
        for(Contact str: array){
            System.out.println(str);
        }
    }

    public static void main(String[] args) throws IOException {


        Scanner stdin = new Scanner(System.in);

        // Instantiate AddressBook object
        AddressBook blackbook = new AddressBook();

        // Menu driven loop.
        menu();
        int choice = stdin.nextInt();


        while (choice!=6) {

            // adds contact in AddressBook called blackbook.
            if (choice == 1) {
                //Reads in all appropriate information.");
                System.out.println("Enter your friend\'s name:");
                String name = stdin.next();
                System.out.println("Enter their Address in one word");
                String address = stdin.next();
                System.out.println("Enter their City");
                String city = stdin.next();
                System.out.println("Enter their State");
                String state = stdin.next();
                System.out.println("Enter their ZIP Code");
                double zipCode = stdin.nextDouble();
                System.out.println("Enter their phone number.");
                double number = stdin.nextDouble();


                blackbook.addContact(name,address,city,state,zipCode,number);
            }

            // Implements rest of the choices by calling appropriate AddressBook methods on blackbook.
            else if (choice == 2) {
                System.out.println("List of Contacts");
                blackbook.printContacts();
                System.out.println("What is the phone number you want to delete?");
                int phno = stdin.nextInt();
                blackbook.deleteContact(phno);
            }
            else if (choice == 3) {
                System.out.println("You have " + blackbook.numContacts() + " contacts.");
            }
            else if (choice == 4) {
                blackbook.printContacts();
            }
            else if (choice == 5) {
                blackbook.sorting();
            }
            else if (choice !=6) {
                System.out.println("Sorry, that was an invalid menu choice, try again.");
            }

            menu();
            choice = stdin.nextInt();
        }

    }

    public static void menu() {
        System.out.println("1.Add a new contact to your address book.");
        System.out.println("2.Delete a contact from your address book.");
        System.out.println("3.Print out the number of contacts you have.");
        System.out.println("4.Print out information of all of your contacts.");
        System.out.println("5.Sort the List of Contact");
        System.out.println("6.Quit.");
        System.out.println("Enter your menu choice:");
    }
}
