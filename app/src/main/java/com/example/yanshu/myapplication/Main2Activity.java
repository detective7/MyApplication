package com.example.yanshu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn = (Button) this.findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(in);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, this.toString()+"   "+this.getTaskId(), Toast.LENGTH_SHORT).show();

        Log.e("launch instance", this.toString());
        Log.e("launch task id", this.getTaskId() + "");
    }
}
