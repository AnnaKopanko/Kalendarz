package com.example.martyna.kalendarz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Martynka on 2016-04-25.
 */
public class SignUp extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


    }
    public void onClick (View v){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void onSignUpClick(View v)
    {
        if(v.getId()==R.id.Bsignup){
            EditText name =(EditText)findViewById(R.id.TFname);
            EditText uname =(EditText)findViewById(R.id.TFuname);
            EditText email =(EditText)findViewById(R.id.TFemail);
            EditText pass1 =(EditText)findViewById(R.id.TFpass1);
            EditText pass2 =(EditText)findViewById(R.id.TFpass2);


            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if(!pass1str.equals(pass2str)){
                Toast pass = Toast.makeText(SignUp.this,"Hasło sie nie zgadza",Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                contact c = new contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);
                helper.insertcontact(c);

            }

        }
    }
}