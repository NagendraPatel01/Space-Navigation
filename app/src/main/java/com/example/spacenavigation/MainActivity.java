package com.example.spacenavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class MainActivity extends AppCompatActivity {

    SpaceNavigationView space;
    FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        space = findViewById(R.id.space);


        space.addSpaceItem(new SpaceItem("HOME",R.drawable.man));
        space.addSpaceItem(new SpaceItem("profile",R.drawable.man5));
       // space.showTextOnly();

        space.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Toast.makeText(MainActivity.this, "Center", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {


                    switch (itemIndex){
                        case 0:
                            replace(new AnkitFragment());
                            break;
                        case 1:
                            replace(new AnkitFragment());
                            break;
                    }

            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {

            }
        });

    }

    void replace(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame, fragment);
        ft.commit();
    }


}