package com.example.fairplay;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Maze_World extends AppCompatActivity {
    int[][] m=new int[7][7];
    Random r=new Random();

    public void Maze(View view) {
        for(int i=1;i<6;i++)
            for(int j=1;j<6;j++)
                m[i][j] = r.nextInt(2);
        m[1][1] = 1;
        m[5][5] = 9;
        SolveMaze(view);
    }

    public void SolveMaze(View view){
        if (findPath(1,1)) {
            m[1][1]=4;
            display(view);
        } else {
            Maze(view);
        }
    }

    public boolean findPath(int x,int y){
        if(m[x][y]==9){ //Reached final Location
            return true;
        }
        if(m[x][y]==1 || m[x][y]==9){ // Not Visited node or Pointer Position
            m[x][y]=2;// Visited Node
            int dx=1;
            int dy=0;
            if(findPath(x+dx,y+dy))// Go down
                return true;
            dx=0;
            dy=1;
            if(findPath(x+dx,y+dy))// Go right
                return true;
            dx=-1;
            dy=0;
            if(findPath(x+dx,y+dy))// Go up
                return true;
            dx=0;
            dy=-1;
            if(findPath(x+dx,y+dy))// Go left
                return true;
        }
        return false;
    }

    public void display(View view){
        ImageView imgView1 = (ImageView)findViewById(R.id.wall1);
        ImageView imgView2 = (ImageView)findViewById(R.id.wall2);
        ImageView imgView3 = (ImageView)findViewById(R.id.wall3);
        ImageView imgView4 = (ImageView)findViewById(R.id.wall4);
        ImageView imgView5 = (ImageView)findViewById(R.id.wall5);
        ImageView imgView6 = (ImageView)findViewById(R.id.wall6);
        ImageView imgView7 = (ImageView)findViewById(R.id.wall7);
        ImageView imgView8 = (ImageView)findViewById(R.id.wall8);
        ImageView imgView9 = (ImageView)findViewById(R.id.wall9);
        ImageView imgView10 = (ImageView)findViewById(R.id.wall10);
        ImageView imgView11 = (ImageView)findViewById(R.id.wall11);
        ImageView imgView12 = (ImageView)findViewById(R.id.wall12);
        ImageView imgView13 = (ImageView)findViewById(R.id.wall13);
        ImageView imgView14 = (ImageView)findViewById(R.id.wall14);
        ImageView imgView15 = (ImageView)findViewById(R.id.wall15);
        ImageView imgView16 = (ImageView)findViewById(R.id.wall16);
        ImageView imgView17 = (ImageView)findViewById(R.id.wall17);
        ImageView imgView18 = (ImageView)findViewById(R.id.wall18);
        ImageView imgView19 = (ImageView)findViewById(R.id.wall19);
        ImageView imgView20 = (ImageView)findViewById(R.id.wall20);
        ImageView imgView21 = (ImageView)findViewById(R.id.wall21);
        ImageView imgView22 = (ImageView)findViewById(R.id.wall22);
        ImageView imgView23 = (ImageView)findViewById(R.id.wall23);
        for (int i=1;i<6;i++){
            for (int j=1;j<6;j++) {
                if(m[i][j]==0){
                    if(i==1 && j==2)
                        imgView1.setVisibility(View.VISIBLE);
                    else if(i==1 && j==3)
                        imgView2.setVisibility(View.VISIBLE);
                    else if(i==1 && j==4)
                        imgView3.setVisibility(View.VISIBLE);
                    else if(i==1 && j==5)
                        imgView4.setVisibility(View.VISIBLE);
                    else if(i==2 && j==1)
                        imgView5.setVisibility(View.VISIBLE);
                    else if(i==2 && j==2)
                        imgView6.setVisibility(View.VISIBLE);
                    else if(i==2 && j==3)
                        imgView7.setVisibility(View.VISIBLE);
                    else if(i==2 && j==4)
                        imgView8.setVisibility(View.VISIBLE);
                    else if(i==2 && j==5)
                        imgView9.setVisibility(View.VISIBLE);
                    else if(i==3 && j==1)
                        imgView10.setVisibility(View.VISIBLE);
                    else if(i==3 && j==2)
                        imgView11.setVisibility(View.VISIBLE);
                    else if(i==3 && j==3)
                        imgView12.setVisibility(View.VISIBLE);
                    else if(i==3 && j==4)
                        imgView13.setVisibility(View.VISIBLE);
                    else if(i==3 && j==5)
                        imgView14.setVisibility(View.VISIBLE);
                    else if(i==4 && j==1)
                        imgView15.setVisibility(View.VISIBLE);
                    else if(i==4 && j==2)
                        imgView16.setVisibility(View.VISIBLE);
                    else if(i==4 && j==3)
                        imgView17.setVisibility(View.VISIBLE);
                    else if(i==4 && j==4)
                        imgView18.setVisibility(View.VISIBLE);
                    else if(i==4 && j==5)
                        imgView19.setVisibility(View.VISIBLE);
                    else if(i==5 && j==1)
                        imgView20.setVisibility(View.VISIBLE);
                    else if(i==5 && j==2)
                        imgView21.setVisibility(View.VISIBLE);
                    else if(i==5 && j==3)
                        imgView22.setVisibility(View.VISIBLE);
                    else if(i==5 && j==4)
                        imgView23.setVisibility(View.VISIBLE);
                }
            }
        }
        ImageView b1 = (ImageView)findViewById(R.id.uarrow);
        ImageView b2 = (ImageView)findViewById(R.id.larrow);
        ImageView b3 = (ImageView)findViewById(R.id.darrow);
        ImageView b4 = (ImageView)findViewById(R.id.rarrow);
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
        b4.setVisibility(View.VISIBLE);
    }
    public void movement(View view){
        ImageView block0 = (ImageView)findViewById(R.id.block0);
        ImageView block1 = (ImageView)findViewById(R.id.block1);
        ImageView block2 = (ImageView)findViewById(R.id.block2);
        ImageView block3 = (ImageView)findViewById(R.id.block3);
        ImageView block4 = (ImageView)findViewById(R.id.block4);
        ImageView block5 = (ImageView)findViewById(R.id.block5);
        ImageView block6 = (ImageView)findViewById(R.id.block6);
        ImageView block7 = (ImageView)findViewById(R.id.block7);
        ImageView block8 = (ImageView)findViewById(R.id.block8);
        ImageView block9 = (ImageView)findViewById(R.id.block9);
        ImageView block10 = (ImageView)findViewById(R.id.block10);
        ImageView block11 = (ImageView)findViewById(R.id.block11);
        ImageView block12 = (ImageView)findViewById(R.id.block12);
        ImageView block13 = (ImageView)findViewById(R.id.block13);
        ImageView block14 = (ImageView)findViewById(R.id.block14);
        ImageView block15 = (ImageView)findViewById(R.id.block15);
        ImageView block16 = (ImageView)findViewById(R.id.block16);
        ImageView block17 = (ImageView)findViewById(R.id.block17);
        ImageView block18 = (ImageView)findViewById(R.id.block18);
        ImageView block19 = (ImageView)findViewById(R.id.block19);
        ImageView block20 = (ImageView)findViewById(R.id.block20);
        ImageView block21 = (ImageView)findViewById(R.id.block21);
        ImageView block22 = (ImageView)findViewById(R.id.block22);
        ImageView block23 = (ImageView)findViewById(R.id.block23);
        ImageView block24 = (ImageView)findViewById(R.id.block24);
        ImageView home = (ImageView)findViewById(R.id.home);
        block0.setVisibility(View.INVISIBLE);
        block1.setVisibility(View.INVISIBLE);
        block2.setVisibility(View.INVISIBLE);
        block3.setVisibility(View.INVISIBLE);
        block4.setVisibility(View.INVISIBLE);
        block5.setVisibility(View.INVISIBLE);
        block6.setVisibility(View.INVISIBLE);
        block7.setVisibility(View.INVISIBLE);
        block8.setVisibility(View.INVISIBLE);
        block9.setVisibility(View.INVISIBLE);
        block10.setVisibility(View.INVISIBLE);
        block11.setVisibility(View.INVISIBLE);
        block12.setVisibility(View.INVISIBLE);
        block13.setVisibility(View.INVISIBLE);
        block14.setVisibility(View.INVISIBLE);
        block15.setVisibility(View.INVISIBLE);
        block16.setVisibility(View.INVISIBLE);
        block17.setVisibility(View.INVISIBLE);
        block18.setVisibility(View.INVISIBLE);
        block19.setVisibility(View.INVISIBLE);
        block20.setVisibility(View.INVISIBLE);
        block21.setVisibility(View.INVISIBLE);
        block22.setVisibility(View.INVISIBLE);
        block23.setVisibility(View.INVISIBLE);
        block24.setVisibility(View.INVISIBLE);
        for (int i=1;i<6;i++){
            for (int j=1;j<6;j++){
                if(m[i][j]==4){
                    if(i==1 && j==1)
                        block0.setVisibility(View.VISIBLE);
                    if(i==1 && j==2)
                        block1.setVisibility(View.VISIBLE);
                    else if(i==1 && j==3)
                        block2.setVisibility(View.VISIBLE);
                    else if(i==1 && j==4)
                        block3.setVisibility(View.VISIBLE);
                    else if(i==1 && j==5)
                        block4.setVisibility(View.VISIBLE);
                    else if(i==2 && j==1)
                        block5.setVisibility(View.VISIBLE);
                    else if(i==2 && j==2)
                        block6.setVisibility(View.VISIBLE);
                    else if(i==2 && j==3)
                        block7.setVisibility(View.VISIBLE);
                    else if(i==2 && j==4)
                        block8.setVisibility(View.VISIBLE);
                    else if(i==2 && j==5)
                        block9.setVisibility(View.VISIBLE);
                    else if(i==3 && j==1)
                        block10.setVisibility(View.VISIBLE);
                    else if(i==3 && j==2)
                        block11.setVisibility(View.VISIBLE);
                    else if(i==3 && j==3)
                        block12.setVisibility(View.VISIBLE);
                    else if(i==3 && j==4)
                        block13.setVisibility(View.VISIBLE);
                    else if(i==3 && j==5)
                        block14.setVisibility(View.VISIBLE);
                    else if(i==4 && j==1)
                        block15.setVisibility(View.VISIBLE);
                    else if(i==4 && j==2)
                        block16.setVisibility(View.VISIBLE);
                    else if(i==4 && j==3)
                        block17.setVisibility(View.VISIBLE);
                    else if(i==4 && j==4)
                        block18.setVisibility(View.VISIBLE);
                    else if(i==4 && j==5)
                        block19.setVisibility(View.VISIBLE);
                    else if(i==5 && j==1)
                        block20.setVisibility(View.VISIBLE);
                    else if(i==5 && j==2)
                        block21.setVisibility(View.VISIBLE);
                    else if(i==5 && j==3)
                        block22.setVisibility(View.VISIBLE);
                    else if(i==5 && j==4)
                        block23.setVisibility(View.VISIBLE);
                    else if(i==5 && j==5){
                        block24.setVisibility(View.VISIBLE);
                        home.setVisibility(View.INVISIBLE);
                        new AlertDialog.Builder(this)
                                .setTitle("You did it!!!")
                                .setMessage("Wanna play more??")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent1 = new Intent(getApplicationContext(), Maze_World.class);
                                        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent1);

                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                        finish();
                                        Intent intent=new Intent(Maze_World.this,MainActivity.class);
                                        startActivity(intent);
                                    }
                                }).show();
                    }
                }
            }
        }
    }
    public void up(View view) {
        for (int i=0;i<7;i++)
            for (int j=0;j<7;j++)
                if(m[i][j]==4)
                    if(m[i-1][j]!=0){
                        m[i][j]=1;
                        m[i-1][j]=4;
                        movement(view);
                        return;
                    }
                    else{
                        Toast.makeText(this, "Wrong Move", Toast.LENGTH_SHORT).show();
                        return;
                    }
    }

    public void down(View view) {
        for (int i=0;i<7;i++)
            for (int j=0;j<7;j++)
                if(m[i][j]==4)
                    if(m[i+1][j]!=0){
                        m[i][j]=1;
                        m[i+1][j]=4;
                        movement(view);
                        return;
                    }
                    else{
                        Toast.makeText(this, "Wrong Move", Toast.LENGTH_SHORT).show();
                        return;
                    }
    }

    public void left(View view) {
        for (int i=0;i<7;i++)
            for (int j=0;j<7;j++)
                if(m[i][j]==4)
                    if(m[i][j-1]!=0){
                        m[i][j]=1;
                        m[i][j-1]=4;
                        movement(view);
                        return;
                    }
                    else{
                        Toast.makeText(this, "Wrong Move", Toast.LENGTH_SHORT).show();
                        return;
                    }
    }

    public void right(View view) {
        for (int i=0;i<7;i++)
            for (int j=0;j<7;j++)
                if(m[i][j]==4)
                    if(m[i][j+1]!=0){
                        m[i][j]=1;
                        m[i][j+1]=4;
                        movement(view);
                        return;
                    }
                    else{
                        Toast.makeText(this, "Wrong Move", Toast.LENGTH_SHORT).show();
                        return;
                    }
    }
    public void reset(View view) {
        Button im= (Button) findViewById(R.id.button1);
        im.setVisibility(View.INVISIBLE);
        Maze(view);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maze_world);
    }
}