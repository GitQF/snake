package com.example.as.snake;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    snakview sv = null;
    snakthread st = null;
    float x1,x2,y1,y2;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(MainActivity.this,"Game over",Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sv = (snakview)findViewById(R.id.snakeview);
        snake snake= new snake();
        sv.setSnake(snake);
        st = new snakthread(sv);
        st.setHandler(handler);
        st.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            x1 = event.getX();
            y1 = event.getY();
        }
        if(event.getAction() == MotionEvent.ACTION_UP){
            x2 = event.getX();
            y2 = event.getY();
        }
        if(x2-x1 > 150 && x2-x1>y2-y1){
            if(sv.getSnake().getDerection()%2 == 0){
                sv.getSnake().setDerection(1);
            }
        }if(x1-x2 > 150 && x1-x2>y1-y2){
            if(sv.getSnake().getDerection()%2 == 0){
                sv.getSnake().setDerection(3);
            }

        }
        if(y2-y1 > 150 && y2-y1>x2-x1){
            if(sv.getSnake().getDerection()%2 == 1){
                sv.getSnake().setDerection(2);
            }
        }
        if(y1-y2 > 150 && y1-y2>x1-x2){
            if(sv.getSnake().getDerection()%2 == 1){
                sv.getSnake().setDerection(4);
            }
        }
        return super.onTouchEvent(event);
    }
}
