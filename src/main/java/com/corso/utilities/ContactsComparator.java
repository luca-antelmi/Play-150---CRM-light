package com.corso.utilities;

import java.util.Comparator;
import com.corso.models.Contact;

public class ContactsComparator implements Comparator<Contact> {

    @Override
    public int compare(Contact c1, Contact c2) {
        if (c1.getEmail().equals(c2.getEmail()) || c1.getPhone().equals(c2.getPhone()))     //sia email che phone sono string,
            return 1;   // return true                                                      //quindi l'equals utilizzato sarà 
        else                                                                                //quello di string
            return 0;   // return false
    }

}
