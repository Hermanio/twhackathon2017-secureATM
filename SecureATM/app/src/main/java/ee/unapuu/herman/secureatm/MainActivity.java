package ee.unapuu.herman.secureatm;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    File imageFile = null;
    Bitmap bitmap;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        takePicture();

        //Intent intent = new Intent(this, WhateverActivity.class);
        //startActivity(intent);
    }

    private void takePicture() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String imageFileName = "JPEG_" + timeStamp + "_";
            File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            try {
                imageFile = File.createTempFile(
                        imageFileName,  /* prefix */
                        ".jpg",         /* suffix */
                        storageDir      /* directory */
                );
                String mCurrentPhotoPath = "file:" + imageFile.getAbsolutePath();

            } catch (IOException ex) {

            }
            //print("imagepath is \"" + imageFile.getAbsolutePath() + "\"");

            if (imageFile != null) {

                Uri photoURI = Uri.fromFile(imageFile); //FileProvider.getUriForFile(EventCreateActivity.this.getApplicationContext(), "com.example.android.fileprovider", imagepath);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                //print("successful");

            }
        }
    }

    private void print(String info) {
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
        Log.i(this.getClass().getSimpleName(), info);
    }
}
