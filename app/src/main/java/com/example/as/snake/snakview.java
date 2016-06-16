package com.example.as.snake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class snakview extends View {
    private static  final int size = 30;
    Paint paint = null;
    private snake snake;
    public void setSnake(snake snake){
        this.snake = snake;
    }
    public snake getSnake(){
        return snake;
    }
    public  snakview(Context context){
        super(context);
    }
    public  snakview(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }
    protected void onDraw(Canvas canvas){
        int width = getWidth()-getPaddingRight()-getPaddingRight();
        int wid = width/size;
        paint = new Paint();
        paint.setColor(0x33000000);
        canvas.drawRect(0,0,width,width,paint);
        paint.setColor(0x77000000);
        for (int i = 0;i<snake.getPath().size();i++){
            if(i == snake.getPath().size()-1) {
                paint.setColor(0xbb000000);
            }
            canvas.drawRect(wid*snake.getPath().get(i).x, wid*snake.getPath().get(i).y, wid*snake.getPath().get(i).x + wid, wid*snake.getPath().get(i).y + wid, paint);
        }
        paint.setColor(0x77000000);
        canvas.drawRect(wid*snake.food.x,wid*snake.food.y,wid*snake.food.x+wid,wid*snake.food.y+wid,paint);
    }

}
