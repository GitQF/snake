package com.example.as.snake;

public class point {
    int x;
    int y;
    public point(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        point temp = (point)o;
        if(this.x == temp.x&&this.y == temp.y){
            return true;
        }else{
            return false;
        }
    }
    public String toString(){
        return String.valueOf(x)+"   "+String.valueOf(y);
    }
}
