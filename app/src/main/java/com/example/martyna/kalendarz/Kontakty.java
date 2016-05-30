package com.example.martyna.kalendarz;

/**
 * Created by Martynka on 2016-05-16.
 */
public class Kontakty {

    private String _name, _phone, _email, _address;

    public Kontakty(String name,String phone, String email, String address){

        _name = name;
        _phone = phone;
        _email = email;
        _address = address;

    }

    public String getName(){
        return _name;
    }
    public String getEmail(){
        return _email;
    }
    public String getPhone(){
        return _phone;
    }
    public String getAddress(){
        return _address;
    }
}
