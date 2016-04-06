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


@SuppressWarnings("SpellCheckingInspection")
public class LoginActivity extends ActionBarActivity {
    private EditText editLogin;
    private EditText editPassword;

    String nazwa= "M";
    String haslo="Sawiko";

    private String someVariable;

    public String getSomeVariable() {
        return someVariable;
    }

    public void setSomeVariable(String someVariable) {
        this.someVariable = someVariable;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editLogin= (EditText) findViewById(R.id.login);
        editPassword= (EditText) findViewById(R.id.password);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
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


    public void onSignClick(View view) {

        String h =editPassword.getText().toString();
        String nick =editLogin.getText().toString();
        if(nazwa.equals(nick) && haslo.equals(h)) {
            Intent intent = new Intent(this, activity_menu.class);
            intent.putExtra("imie", nazwa);
            intent.putExtra("haslo", haslo);
            startActivity(intent);
        }
    }
}
