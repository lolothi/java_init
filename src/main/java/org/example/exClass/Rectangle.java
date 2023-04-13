package org.example.exClass;

public class Rectangle {
    public int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int y;

    public Rectangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void display(){
        String ligne = "";
        String charToDisplay = "X";
        for (int i=1; i <= x; i++) {
            ligne = ligne + charToDisplay;
        }
        for (int i=1; i <= y; i++) {
            System.out.println(ligne);
        }

    }
}
