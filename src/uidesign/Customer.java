package uidesign;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
@author Aastha, Keerthi
*/
// This Class contains members, functions pertaining to the customers
public class Customer implements Comparable<Customer>{
    
    private String firstName;
    private String lastName;
    private String middleName;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private Integer zipcode = new Integer(9);
    private BigInteger phoneNumber ;
    private String emailAddress;
    private String proofOfPurchase;
    private Date dateReceived;
    String temp[] = new String[12];

    //Function that returns the customer details in an array
    public String[] getCustomer() {

        temp[0] = firstName;
        temp[1] = lastName;
        temp[2] = middleName;
        temp[3] = address1;
        temp[4] = address2;
        temp[5] = city;
        temp[6] = state;
        temp[7] = String.valueOf(zipcode);
        temp[8] = String.valueOf(phoneNumber);
        temp[9] = emailAddress;
        temp[10] = proofOfPurchase;
        temp[11] = new SimpleDateFormat("MM/dd/yyyy").format(dateReceived);

        return temp;
    }
    //Function that stores the values entered in the textboxes into an object of class customer.
    public void setCustomer(String a[]) {
        try {

            firstName = a[0];
            lastName = a[1];
            middleName = a[2];
            address1 = a[3];
            address2 = a[4];
            city = a[5];
            state = a[6];
            zipcode = Integer.parseInt(a[7]);
            //phoneNumber = BigInteger.valueOf(a[8]);
            phoneNumber =new BigInteger(a[8]);
            emailAddress = a[9];
            proofOfPurchase = a[10];

            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date date = formatter.parse(a[11]);

            dateReceived = date;
        } catch (java.text.ParseException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Function that compares the Customer object and is used to sort the objects as per name and phone number
    public int compareTo(Customer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

}
