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
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        User user = (User) obj;

        if (id != user.id) return false;
        if (!username.equalsIgnoreCase(user.username)) return false;

        return username != null ? username.equals(user.username) : user.username == null;

    }






}
