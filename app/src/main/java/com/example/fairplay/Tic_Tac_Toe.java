package com.example.fairplay;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import java.util.Random;

public class Tic_Tac_Toe extends AppCompatActivity {
    boolean iswinner = false;
    int imageClicked = -1;
    Random r = new Random();
    int player = r.nextInt(2), ch = 1, t = 0; //player1 is cross
    int[][] winngstate = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {2, 4, 6}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}};
    int[] gamestate = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    int[] ws = {-1, -1, -1};

    public void load(View view)  {
        ImageView v = (ImageView) view;
        TextView tv1 = (TextView) findViewById(R.id.textView3);
        TextView tv2 = (TextView) findViewById(R.id.textView4);
        Button bt=(Button)findViewById(R.id.button);
        ImageView c = (ImageView) findViewById(R.id.imageView15);
        if (ch == 1) {
            ch = 0;
            if (player == 1)
                c.setRotation(180F);
            else
                c.setRotation(0F);
        }
        int tag = Integer.parseInt(v.getTag().toString());
        imageClicked = gamestate[tag];
        if (!iswinner && imageClicked == -1) {
            bt.setVisibility(View.VISIBLE);
            if (player == 1) {
                c.setRotation(0F);
                v.setImageResource(R.drawable.cross);
                gamestate[tag] = player;
                player = 0;
            } else {
                c.setRotation(180F);
                v.setImageResource(R.drawable.zero);
                gamestate[tag] = player;
                player = 1;
            }
            for (int i = 0; i < winngstate.length; i++) {
                if (gamestate[winngstate[i][0]] == gamestate[winngstate[i][1]] && gamestate[winngstate[i][1]] == gamestate[winngstate[i][2]] && gamestate[winngstate[i][0]] > -1) {
                    c.setVisibility(View.INVISIBLE);
                    ch = 1;
                    if (player == 1) {
                        int a = Integer.parseInt((String) tv2.getText());
                        tv2.setText("" + (a + 1));
                        Toast.makeText(this, "Winner: " + "O", Toast.LENGTH_SHORT).show();
                    } else {
                        int a = Integer.parseInt((String) tv1.getText());
                        tv1.setText("" + (a + 1));
                        Toast.makeText(this, "Winner: " + "X", Toast.LENGTH_SHORT).show();
                    }
                    iswinner = true;
                    if (player == 1) {
                        ws[t] = 0;
                    } else {
                        ws[t] = 1;
                    }
                    t = t + 1;
                    if (t != 3) {
                        Handler handler = new Handler();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        reset(view);
                                    }
                                });
                            }
                        });
                    }
                }
                if (t == 3) {
                    t = 0;
                    char a = 'O';
                    if (ws[0] == ws[1] || ws[0] == ws[2]) {
                        if (ws[0] == 1) {
                            a = 'X';
                            Toast.makeText(this, "Winner of Competition is: " + "X", Toast.LENGTH_LONG).show();
                        } else
                            Toast.makeText(this, "Winner of Competition is: " + "O", Toast.LENGTH_LONG).show();
                    } else if (ws[1] == ws[2]) {
                        if (ws[1] == 1) {
                            a = 'X';
                            Toast.makeText(this, "Winner of Competition is: " + "X", Toast.LENGTH_LONG).show();
                        } else
                            Toast.makeText(this, "Winner of Competition is: " + "O", Toast.LENGTH_LONG).show();
                    }
                    new AlertDialog.Builder(this)
                            .setTitle("Winner is: " + a)
                            .setMessage("Wanna play more??")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    fullreset(view);
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    finish();
                                    Intent intent = new Intent(Tic_Tac_Toe.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }).show();

                }
            }
        }
    }

    public void reset(View view) {
        Button bt=(Button)findViewById(R.id.button);
        bt.setVisibility(View.INVISIBLE);
        player = r.nextInt(2);
        ImageView c = (ImageView) findViewById(R.id.imageView15);
        c.setVisibility(View.VISIBLE);
        if (player == 1) {
            c.setRotation(180F);
        } else
            c.setRotation(0F);
        GridLayout gridlayout = findViewById(R.id.gridlayout);
        int total_image = gridlayout.getChildCount();
        for (int i = 0; i < total_image; i++) {
            ImageView v = (ImageView) gridlayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        iswinner = false;
        imageClicked = -1;
        for (int i = 0; i < gamestate.length; i++) {
            gamestate[i] = -1;
        }
    }

    public void fullreset(View view) {
        TextView tv1 = (TextView) findViewById(R.id.textView3);
        TextView tv2 = (TextView) findViewById(R.id.textView4);
        tv1.setText("0");
        tv2.setText("0");
        reset(view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tic_tac_toe);


    }

}