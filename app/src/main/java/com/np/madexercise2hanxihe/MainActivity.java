package com.np.madexercise2hanxihe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Loading name and description from User
        Intent receiveRandInt = getIntent();
        int randInt = receiveRandInt.getIntExtra("randIntIntent", 0);
        String desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua";
        user = new User("Han Xihe", desc, 1, false);

        // sets name and random integer together, and textDesc
        TextView textView = findViewById((R.id.textDesc));
        textView.setText(desc);
        TextView nameAndRandInt = findViewById(R.id.textTitle);
        nameAndRandInt.setText(user.name + " " + randInt);

        Button button = findViewById(R.id.followButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Button button = findViewById(R.id.followButton);
                if (user.followed) {
                    user.followed = false;
                    button.setText("FOLLOW");
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    user.followed = true;
                    button.setText("UNFOLLOW");
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        Button button2 = findViewById(R.id.messgeButton);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(i);
            }
        });
    }
}