package com.example.mfoodwastemanagement;

public class User {
    private String food;
    private String prize;
    private String phno;

    public User() {

    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public User(String food, String prize, String phno) {
        this.food = food;
        this.prize = prize;
        this.phno = phno;

    }
}
