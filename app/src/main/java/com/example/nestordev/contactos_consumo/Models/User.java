package com.example.nestordev.contactos_consumo.Models;

public class User {
    public String id;
    public String username;
    public String lastName;
    public String age;
    public String gemale;
    public String telephone;
    public String email;
    public String image;

    public User(){
        this.id ="";
        this.username ="";
        this.lastName ="";
        this.age ="";
        this.gemale ="";
        this.telephone ="";
        this.email ="";
        this.image ="";
    }

    public User(String id,String username,String lastName,String age,String gemale,String telephone,String email,String image){
        this.id =id;
        this.username =username;
        this.lastName =lastName;
        this.age =age;
        this.gemale =gemale;
        this.telephone =telephone;
        this.email =email;
        this.image =image;

    }


}
