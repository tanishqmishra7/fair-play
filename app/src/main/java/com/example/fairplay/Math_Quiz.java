package com.example.fairplay;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class Math_Quiz extends AppCompatActivity {

    int matchCounter=0;
    int []score={-1,-1,-1,-1,-1};
    String operators[]={"+","-","*","/"};
    Random random=new Random();
    int correctButton;
    TextView textView2;
    Button button1,button2,button3,button4;
    public void load(View view){
        Button buttonClicked=(Button)view;
        if(buttonClicked.getTag().toString().equals(correctButton+"")){
            score[matchCounter++]=1;
        }else{
            score[matchCounter++]=0;
        }
        newMatch();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_quiz);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        textView2=findViewById(R.id.textView2);
        newMatch();
    }
    public void newMatch() {
        correctButton=random.nextInt(4);
        double o1 = random.nextInt(10),o2=random.nextInt(10);
        int n=random.nextInt(4);
        double a1=0,a2=0,a3=0,ans=0;
        String a,b,c,d;
        while(o2==0 && n==3)
            o2=random.nextInt(10);
        if(n==0){
            ans=o1+o2;
        }else if(n==1){
            ans=o1-o2;
        }else if(n==2){
            ans=o1*o2;
        }else if(n==3 && o2!=0.0){
            ans=o1/o2;
            while(a1==ans || a1==a2 || a1==a3)
                a1= random.nextInt(20)+2*random.nextDouble()-1;
            while(a2==ans || a1==a2 || a2==a3)
                a2= random.nextInt(20)+2*random.nextDouble()-1;
            a3=a2;
            while(a3==ans || a3==a2 || a1==a3)
                a3= random.nextInt(20)+2*random.nextDouble()-1;
        }
        while(a1==ans || a1==a2 || a1==a3)
            a1= random.nextInt(20);
        while(a2==ans || a1==a2 || a2==a3)
            a2= random.nextInt(20);
        a3=a2;
        while(a3==ans || a3==a2 || a1==a3)
            a3= random.nextInt(20);
        String operator = operators[n];
        textView2.setText(String.format("%.0f", o1) + operator + String.format("%.0f", o2));
        if(n!=3) {
            a=String.format("%.0f", ans);
            b=String.format("%.0f", a1);
            c=String.format("%.0f", a2);
            d=String.format("%.0f", a3);
        }else {
            a=String.format("%.2f", ans);
            b=String.format("%.2f", a1);
            c=String.format("%.2f", a2);
            d=String.format("%.2f", a3);
        }
        if(correctButton==0){
            button1.setText(a);
            button2.setText(b);
            button3.setText(c);
            button4.setText(d);
        }else if(correctButton==1 && !(o2==0 && n==3)){
            button2.setText(a);
            button1.setText(b);
            button3.setText(c);
            button4.setText(d);
        }else if(correctButton==2 && !(o2==0 && n==3)){
            button3.setText(a);
            button2.setText(b);
            button1.setText(c);
            button4.setText(d);
        }else if(correctButton==3 && !(o2==0 && n==3)){
            button4.setText(a);
            button2.setText(b);
            button3.setText(c);
            button1.setText(d);
        }
        if(matchCounter==5){
            matchCounter=0;
            int sc=sumOfScore();
            Toast.makeText(this,""+"Score: "+sc, Toast.LENGTH_SHORT).show();
            new AlertDialog.Builder(this)
                    .setTitle("Break")
                    .setMessage("Wanna play more")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            newMatch();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            finish();
                            Intent intent=new Intent(Math_Quiz.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }).show();
        }
    }
    public int sumOfScore(){
        int sum=score[0]+score[1]+score[2]+score[3]+score[4];
        return sum;
    }
}