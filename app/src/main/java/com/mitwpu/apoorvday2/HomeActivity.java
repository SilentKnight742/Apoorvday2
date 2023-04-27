package com.mitwpu.apoorvday2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements Runnable{
    EditText ed1, ed2, ed3;
    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button btn = (Button)findViewById(R.id.homeButton);
        ed1 = findViewById(R.id.etName);
        ed2 = findViewById(R.id.etEmail);
        ed3 = findViewById(R.id.etPwd);
        iv1 = findViewById(R.id.ivPic);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp=MediaPlayer.create(HomeActivity.this, R.raw.not);
                mp.start();
                Handler h = new Handler();
                h.postDelayed(HomeActivity.this, 500);
            }

        });
    }

    public void btnPicClick(View view) {
        String name = ed1.getText().toString();
        String email = ed2.getText().toString();
        String pwd = ed3.getText().toString();
        String msg = "Welcome " + name + " email " + email + " Password " + pwd;
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(in, 7);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 7 & resultCode ==RESULT_OK) {
            Bundle b = data.getExtras();
            Bitmap bmp = (Bitmap) b.get("data");
            iv1.setImageBitmap(bmp);
        }
    }

    @Override
    public void run() {
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }
}