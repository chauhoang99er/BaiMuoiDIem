package vn.edu.ntu.chauhoang.baimuoidiem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;

import android.os.Bundle;
import android.view.View;

import vn.edu.ntu.chauhoang.baimuoidiem.Controller.Icontroller;
import vn.edu.ntu.chauhoang.baimuoidiem.Controller.controller;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    NavController navController;
    Icontroller icontroller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        icontroller = new controller();
        icontroller = (Icontroller) getApplication();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigateUp();
            }
        });
    }
}