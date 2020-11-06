/**
 *
 * @author bagal
 * Date:04-11-2020
 * Functions:Contact class for storing details in the AddressBook
 *
 */
import java.util.Comparator;

public class Contact{

    private String name; // Stores name of a Contact
    private String address;  // Stores age of a Contact
    private String city;  // Stores city of  a Contact
    private String state; // Stores state of a Contact
    private double zipCode; // Stores Zip Code of a Contact
    private double phonenumber; // Stores phone number of a contact

    // Creates Contact object based on parameters.
    public Contact(String name, String address, String city, String state, double zipCode, double phonenumber) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phonenumber = phonenumber;
    }

    public Contact() {
        // TODO Auto-generated constructor stub
    }

    // Returns the name of a Contact
    public String getName() {
        return name;
    }

    // Returns the Address of a Contact
    public String getAddress() {
        return address;
    }

    // Returns the City of a Contact
    public String getCity() {
        return city;
    }

    // Returns the State of a Contact
    public String getState() {
        return state;
    }

    // Returns the Zip Code of a Contact
    public double getZipCode() {
        return zipCode;
    }

    // Returns the phone number of a Contact
    public double getNumber() {
        return phonenumber;
    }
    /*Comparator for sorting the list by Contact Name*/
    public static Comparator<Contact> nameComparator = new Comparator<Contact>() {

        @Override
        public int compare(Contact o1, Contact o2) {
            String friend1=o1.getName().toUpperCase();
            String friend2=o1.getName().toUpperCase();

            //ascending order
            return friend1.compareTo(friend2);
        }};


    @Override
    public String toString() {
        return "Contact [name=" + name + ", address=" + address + ", city=" + city + ", state=" + state + ", zipCode="
                + zipCode + ", phonenumber=" + phonenumber + "]";
    }
