package com.example.com.sugarorm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.com.sugarom.models.Contact;
import com.orm.SugarRecord;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SugarRecord.deleteAll(Contact.class);

        //save
        Contact contact = new Contact("Sod", "+6285000000");
        contact.save();

        Contact contact1 = new Contact("Diq", "+6285000001");
        contact1.save();

        Contact contact2 = new Contact("Sodiq", "+6285000003");
        contact2.save();

        //update
        contact2.setPhone("+6285000002");
        contact2.save();

        //load all
        List<Contact> contacts = SugarRecord.listAll(Contact.class);

        Log.d(TAG, "listAll: " + contacts.toString());

        //find by id, id = 2
        Contact contact4 = SugarRecord.findById(Contact.class, (long) 2);

        if (contact4 != null) {
            Log.d(TAG, "findById = 2: " + contact4.toString());
        }

        //find with where clause and the arguments
        List<Contact> contacts1 = SugarRecord.find(Contact.class, "name = ?", "Sodiq");

        Log.d(TAG, "where clause and the arguments: " + contacts1.toString());

        //find with custom query
        List<Contact> contacts2 = SugarRecord.findWithQuery(Contact.class, "SELECT * FROM Contact WHERE name = ?", "Sodiq");

        Log.d(TAG, "custom query: " + contacts2.toString());

        //find with query builder
        List<Contact> contacts3 = Select.from(Contact.class).where(Condition.prop("name").eq("Sodiq")).list();
        Log.d(TAG, "query builder: " + contacts3.toString());

        //delete by id, id = 3
        try {
            Contact contact5 = SugarRecord.findById(Contact.class, (long) 3);
            contact5.delete();
        } catch (Exception e) {}

        //delete all
        SugarRecord.deleteAll(Contact.class);


    }
}
