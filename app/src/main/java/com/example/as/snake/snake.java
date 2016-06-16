package com.example.as.snake;

import java.util.ArrayList;

public class snake {
    point food = null;
    private int derection = 1;  //right=1,down=2,left=3,up=4;
    private ArrayList<point> path = new ArrayList<point>();
    point head;
    public ArrayList<point> getPath(){
        return path;
    }
    public snake(){
        for (int i = 5;i<17;i++) {
            path.add(new point(i,15));
        }
        head = path.get(path.size()-1);
        food = getfood();
    }
    public void setDerection(int d){
        this.derection = d;
    }
    public int getDerection(){
        return derection;
    }
    public void move(){
        switch (derection){
            case 1:
                head = new point(head.x+1,head.y);
                if(head.equals(path.get(path.size()-2))){
                    break;
                }path.add(head);
                break;
            case 2:
                head = new point(head.x,head.y+1);
                if(head.equals(path.get(path.size()-2))){
                    break;
                }path.add(head);
                break;
            case 3:
                head = new point(head.x-1,head.y);
                if(head.equals(path.get(path.size()-2))){
                    break;
                }path.add(head);
                break;
            case 4:
                head = new point(head.x,head.y-1);
                if(head.equals(path.get(path.size()-2))){
                    break;
                }
                path.add(head);
                break;
        }
    }
    public boolean isalive(){
        for(int i = 0;i<path.size()-1;i++){
            if(head.equals(path.get(i))){
                return false;
            }
        }
        if(head.x>=30||head.y>=30||head.x<0||head.y<0) {
            return false;
        }else{
            return true;
        }
    }
    public point getfood() {
        do {
            int x = (int) (Math.random() * 30);
            int y = (int) (Math.random() * 30);
            food = new point(x, y);
        } while (insnake(food));
        return food;
    }
    private boolean insnake(point food){
            for(int i = 0;i<path.size();i++){
                if(food.equals(path.get(i))) {
                    return true;
                }
            }return false;
    }
}

