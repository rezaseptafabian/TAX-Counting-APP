package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Camera extends Activity   {

    private ImageView imageHolder;
    private final int requestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        imageHolder = (ImageView)findViewById(R.id.captured_photo);
        Button capturedImageButton = (Button)findViewById(R.id.take_picture);
        capturedImageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoCaptureIntent, requestCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(this.requestCode == requestCode && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            imageHolder.setImageBitmap(bitmap);
        }
    }
}