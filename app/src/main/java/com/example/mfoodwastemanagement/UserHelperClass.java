package com.example.mfoodwastemanagement;

public class UserHelperClass {
    String food, prize, phno;

    public UserHelperClass(String food, String prize, String phno) {
        this.food = food;
        this.prize = prize;
        this.phno = phno;
    }

    public UserHelperClass() {

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
}
