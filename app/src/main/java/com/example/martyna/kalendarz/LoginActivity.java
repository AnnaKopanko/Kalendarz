package com.example.martyna.kalendarz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;


@SuppressWarnings("SpellCheckingInspection")
public class LoginActivity extends ActionBarActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    public void onButtonClick(View v) {

        if (v.getId() == R.id.Blogin) {
            EditText a = (EditText) findViewById(R.id.login);
            String str = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.password);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);

            if (pass.equals(password)) {
                Intent i = new Intent(LoginActivity.this, activity_menu.class);
                i.putExtra("login", str);
                startActivity(i);
            } else {
                Toast temp = Toast.makeText(LoginActivity.this, "Login lub hasło są złe", Toast.LENGTH_SHORT);
                temp.show();
            }

        }
        if (v.getId() == R.id.Bzarejestruj) {
            Intent i = new Intent(LoginActivity.this, SignUp.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
