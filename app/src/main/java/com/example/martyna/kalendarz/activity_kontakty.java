package com.example.martyna.kalendarz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;




public class activity_kontakty extends AppCompatActivity {
    EditText nameTxt, phoneTxt, emailTxt, adressTxt;
    List<Kontakty> Kontakt = new ArrayList<Kontakty>();
    ListView contactListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontakty);

        nameTxt = (EditText) findViewById(R.id.ETimie);
        phoneTxt = (EditText) findViewById(R.id.ETnumertel);
        emailTxt = (EditText) findViewById(R.id.ETemaill);
        adressTxt = (EditText) findViewById(R.id.ETadres);
        contactListView = (ListView) findViewById(R.id.listView2);


        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("Dodawanie kontaktów");
        tabSpec.setContent(R.id.tabCreator);
        tabSpec.setIndicator("Dodawanie kontaktów");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Lista kontaktów");
        tabSpec.setContent(R.id.tabContactStore);
        tabSpec.setIndicator("Lista kontaktów");
        tabHost.addTab(tabSpec);


        final Button Bdodajkon = (Button) findViewById(R.id.Bdodajkontakt);





        Bdodajkon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addContacts(nameTxt.getText().toString(), phoneTxt.getText().toString(), emailTxt.getText().toString(), adressTxt.getText().toString());
                populateList();
                Toast.makeText(getApplicationContext(), nameTxt.getText().toString() + " został dodany do kontaktów", Toast.LENGTH_SHORT).show();
            }
        });
        nameTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

                Bdodajkon.setEnabled(!nameTxt.getText().toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private void populateList (){
        ArrayAdapter<Kontakty> adapter = new ContactListAdapter();
        contactListView.setAdapter(adapter);
    }


    private void addContacts(String name, String phone, String email, String address) {
        Kontakt.add(new Kontakty(name, phone, email, address));


    }


    private class ContactListAdapter extends ArrayAdapter<Kontakty> {

        public ContactListAdapter() {
            super(activity_kontakty.this, R.layout.listview_item, Kontakt);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view == null)
                view = getLayoutInflater().inflate(R.layout.listview_item, parent, false);
            Kontakty currentContact = Kontakt.get(position);

            TextView name = (TextView) view.findViewById(R.id.Contactname);
            name.setText(currentContact.getName());
            TextView phone = (TextView) view.findViewById(R.id.PhoneNumber);
            phone.setText(currentContact.getPhone());
            TextView email = (TextView) view.findViewById(R.id.Email);
            email.setText(currentContact.getEmail());
            TextView address = (TextView) view.findViewById(R.id.Address);
            address.setText(currentContact.getAddress());

            return view;
        }
    }
}