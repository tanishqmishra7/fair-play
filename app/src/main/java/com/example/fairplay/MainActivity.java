package com.example.fairplay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fairplay.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    public void gm1(View view) {
        Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent1);
        Intent intent = new Intent(MainActivity.this, Math_Quiz.class);
        startActivity(intent);
//        ImageView i1 =(ImageView) findViewById(R.id.game1);
//        i1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
    }

    public void gm2(View view) {
        Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent1);
        Intent intent = new Intent(MainActivity.this, Tic_Tac_Toe.class);
        startActivity(intent);
    }

    public void gm3(View view) {
        Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent1);
        Intent intent = new Intent(MainActivity.this, Maze_World.class);
        startActivity(intent);
//        ImageView i3 = (ImageView) findViewById(R.id.game3);
//        i3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
    }

    //    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FragmentManager fm3 = getSupportFragmentManager();
        FragmentTransaction ft3 = fm3.beginTransaction();
        ft3.replace(R.id.frm1, new First_Page());
        ft3.commit();
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home1:
                    FragmentManager fm2 = getSupportFragmentManager();
                    FragmentTransaction ft2 = fm2.beginTransaction();
                    ft2.replace(R.id.frm1, new First_Page());
                    ft2.commit();
                    break;
                case R.id.info:
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frm1, new About_Us());
                    ft.commit();
                    break;
                case R.id.contact:
                    FragmentManager fm1 = getSupportFragmentManager();
                    FragmentTransaction ft1 = fm1.beginTransaction();
                    ft1.replace(R.id.frm1, new Contact_Us());
                    ft1.commit();
                    break;
            }
            return true;
        });
    }
}
