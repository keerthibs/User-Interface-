/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uidesign;

/**
 *
 * @author Aastha, Keerthi
 */
public class FileOperations {

    public static int index = 0;
    public static String message[] = new String[12];
    int messageIndex = 0;
    public static String rowset[] = new String[12];
    
    ReadWrite rw = new ReadWrite();
    public static Customer cust[] = new Customer[500];

    int flag=0;
    
    //Function calling Validation and returning boolean array for Add button click
    public boolean[] Add(String rowset[]) {
        flag=0;
        String messageFinal = "";
        boolean[] Valid = new boolean[14];
        int localIndex=-1;
        Valid[10]= true;
        Valid[0] = Validate_firstName(rowset[0]);
        Valid[1] = Validate_lastName(rowset[1]);
        Valid[2] = Validate_middleName(rowset[2]);
        Valid[3] = Validate_addressLine1(rowset[3]);
        Valid[4] = Validate_addressLine2(rowset[4]);
        Valid[5] = Validate_City(rowset[5]);
        Valid[6] = Validate_State(rowset[6]);
        Valid[7] = Validate_Zipcode(rowset[7]);
        Valid[8] = Validate_phoneNumber(rowset[8]);
        Valid[9] = Validate_Emailid(rowset[9]);
        Valid[11] = Validate_dateReceived(rowset[11]);
        Valid[12] = Validate_fullName(rowset,localIndex);
        for (int k=0;k<13;k++) {
                if(Valid[k]==false) {
                    Valid[13]=false;
                    break;
                }
                else
                    Valid[13]=true;
        }
        if (Valid[13]!=false) {
            cust[index] = new Customer();
            cust[index].setCustomer(rowset);
            index++;
            ReadWrite rw2 = new ReadWrite();
            rw2.Write(index);
        } 

        return Valid;
    }
//Function calling Validation and returning boolean array for Modify button click
    public boolean[] Modify(String rowset[], int localIndex) {
        flag=1;
      //  String messageFinal = "";
        boolean[] Valid = new boolean[14];
        Valid[10] = true;
        Valid[0] = Validate_firstName(rowset[0]);
        Valid[1] = Validate_lastName(rowset[1]);
        Valid[2] = Validate_middleName(rowset[2]);
        Valid[3] = Validate_addressLine1(rowset[3]);
        Valid[4] = Validate_addressLine2(rowset[4]);
        Valid[5] = Validate_City(rowset[5]);
        Valid[6] = Validate_State(rowset[6]);
        Valid[7] = Validate_Zipcode(rowset[7]);
        Valid[8] = Validate_phoneNumber(rowset[8]);
        Valid[9] = Validate_Emailid(rowset[9]);
        Valid[11] = Validate_dateReceived(rowset[11]);
        Valid[12] = Validate_fullName(rowset,localIndex);
        
        for (int k=0;k<13;k++) {
                if(Valid[k]==false) {
                    Valid[13]=false;
                    break;
                }
                else
                    Valid[13]=true;
        }
        if (Valid[13]!=false) {
            cust[localIndex].setCustomer(rowset);
            rw.Write(index);
        } 
        return Valid;
    }
//Function calling Validation for Delete button click
    public boolean Delete(String rowset[],int localIndex) {
        String temp[];
            temp = cust[localIndex].getCustomer();
            if ((temp[0].equalsIgnoreCase(rowset[0])) && (temp[1].equalsIgnoreCase(rowset[1])) && (temp[2].equalsIgnoreCase(rowset[2]))) {
                for (int m = localIndex; m < index - 1; m++) {
                    cust[m].setCustomer(cust[m + 1].getCustomer());
                }

                index = index - 1;
                rw.Write(index);
                return true;
            }
            else {
                //return a message
                return false;
            }
        }
        
   boolean regex, regex1; //variables to store regular expressions for validating input fields
   
   //Function for Validating First Name
        public boolean Validate_firstName(String rowset) {
        regex= rowset.matches("\\w+");
        regex1= rowset.matches(".*\\d+.*");
        if (rowset.equals("") || rowset.length() > 20 || !regex || regex1 || rowset.contains(" ") || rowset.contains("_")) {
            return false;
        }
        else
            return true;
    }
    //Function for Validating Last Name
    public boolean Validate_lastName(String rowset) {
        regex= rowset.matches("\\w+");
        regex1= rowset.matches(".*\\d+.*");
        if (rowset.equals("") || rowset.length() > 20 || !regex || regex1 || rowset.contains(" ") || rowset.contains("_")) {
            return false;
        }
        else
            return true;
    }
    //Function for Validating Middle Name
    public boolean Validate_middleName(String rowset) {
        //Below is the condition for Validation of Middle Name
        regex= rowset.matches("\\w+");
        regex1= rowset.matches(".*\\d+.*");
        if (rowset.length() > 1 || !regex || regex1 || rowset.contains("_")) {
            return false;
        }
        else
            return true;
    }
    //Function for Validating Address Line 1
    public boolean Validate_addressLine1(String rowset) {
        if (rowset.equals("") || rowset.length() > 35 || rowset.matches("\\s+")) {
            return false;
        }
        else
            return true;
    }
    //Function for Validating Address 2
    public boolean Validate_addressLine2(String rowset) {
        if (rowset.length() > 35 || rowset.matches("\\s+")) {
            return false;
        }
        else
            return true;
    }
    //Function for Validating City
    public boolean Validate_City(String rowset) {
        regex= rowset.matches("(\\w+\\ *)*");
        regex1= rowset.matches(".*\\d+.*");
        if (rowset.equals("") || rowset.length() > 25 || !regex || regex1 || rowset.contains("_")) {
            return false;
        }
        else
            return true;
    }
    String[] State= new String[] {"AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN",
                                    "IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV",
                                    "NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN",
                                    "TX","UT","VT","VA","WA","WV","WI","WY"};
    
    //Function for Validating State
    public boolean Validate_State(String rowset) {
        regex= rowset.matches("\\w+");
        regex1= rowset.matches(".*\\d+.*");
        if (rowset.equals("") || rowset.length() != 2 || !regex || regex1 || rowset.contains(" ") || rowset.contains("_")) {
            return false;
        }
        else {
            for(int i=0;i<50;i++) {
                if(rowset.equalsIgnoreCase(State[i]))
                    return true;
            }
            return false;
        }
    } 
    //Function for Validating Zipcode
    public boolean Validate_Zipcode(String rowset) {
        regex= rowset.matches("\\d+");
        if (rowset.equals("") || rowset.length() > 9 ||!regex) {
            return false;
        }
        else
            return true;
    }
    //Function for Validating Phone Number
    public boolean Validate_phoneNumber(String rowset) {
        regex= rowset.matches("\\d+");
        if (rowset.equals("") || rowset.length() > 21 || !regex) {
            return false;
        }
        else
            return true;
    }
    
    //Function for Validating Email Address
    public boolean Validate_Emailid(String rowset) {
        boolean emailValid;
        emailValid=rowset.matches("^[A-Za-z]+[._0-9a-zA-Z]*@[a-zA-Z0-9]+\\.[A-Za-z]+$");
        if (rowset.equals("") || rowset.length() > 60 || !emailValid) {
            return false;
        }
        else
            return true;
    }
    //Function for validating Date Received
    public boolean Validate_dateReceived(String rowset) {
        boolean dvalid;
        dvalid=rowset.matches("[\\d]{2}/[\\d]{2}/[\\d]{4}");

       if(dvalid)
       {
        String dt[] = (rowset.split("/"));
        Integer dtValid[] = new Integer[3];
        dtValid[0] = Integer.parseInt(dt[0]); //value for month
        dtValid[1] = Integer.parseInt(dt[1]);    //value for date
        dtValid[2] = Integer.parseInt(dt[2]);    //value for year
        if (!rowset.equals("")) {
            if (dtValid[0] >= 1 && dtValid[0] <= 12) {
                if ((dtValid[0] == 1 || dtValid[0] == 3 || dtValid[0] == 5 || dtValid[0] == 7 || dtValid[0] == 8 || dtValid[0] == 10 || dtValid[0] == 12) && (dtValid[1] < 1 || dtValid[1] > 31)) {
                    return false;
                } else if ((dtValid[0] == 4 || dtValid[0] == 6 || dtValid[0] == 9 || dtValid[0] == 11) && (dtValid[1] < 1 || dtValid[1] > 30)) {
                    return false;
                } else if (dtValid[0] == 2 && (dtValid[1] > 28 || dtValid[1] < 1)) {
                    return false;
                }
                else
                    return true;
            }
            else
                return false;

        } else 
            return false;
       }
       else {
           return false;
       }
    }
    //Function for validating Full Name, that is if the entry for First Name, Last Name and Middle Name 
    //already exists in the customer class
    public boolean Validate_fullName(String[] rowset, int localIndex) {
        String temp[]=new String[12];   
        if(flag==0) {
        for (int i = 0; i < index; i++) {
            temp = cust[i].getCustomer();
            if ((temp[0].equalsIgnoreCase(rowset[0])) && (temp[1].equalsIgnoreCase(rowset[1])) && (temp[2].equalsIgnoreCase(rowset[2]))) {
                return false;
            }

        }
        return true;
        }
        else {
            for(int i=0; i<index;i++) {
                if(index!=localIndex) {
                    temp=cust[i].getCustomer();
                    if ((temp[0].equalsIgnoreCase(rowset[0])) && (temp[1].equalsIgnoreCase(rowset[1])) && (temp[2].equalsIgnoreCase(rowset[2]))) {
                    return false;
                    }
                }
            }
            return true;
        }
    }
    
//Function to retrieve customer data
    public String[] retrieveCustomer(int localIndex) {

        return cust[localIndex].getCustomer();
    }
    
    


}
