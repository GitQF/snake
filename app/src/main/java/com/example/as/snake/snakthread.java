package com.example.as.snake;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class snakthread extends Thread{
    private snakview sv;
    private Handler handler;
    snakthread(snakview sv){
        this.sv = sv;
    }
    public void setHandler(Handler handler){
        this.handler = handler;
    }
    public void run(){
        while (true) {
            try{
                Thread.sleep(200);
            }catch (Exception e){
                e.printStackTrace();
            }
            sv.getSnake().move();
            if(!sv.getSnake().isalive()){
                sv.getSnake().getPath().remove(sv.getSnake().getPath().size()-1);
                Message msg = new Message();
                handler.sendMessage(msg);
                break;
            }
            if(!sv.getSnake().food.equals(sv.getSnake().head)) {
                sv.getSnake().getPath().remove(0);
            }else{
                sv.getSnake().food = sv.getSnake().getfood();
            }
            sv.postInvalidate();
        }
    }
}
