package com.thanhtam.intentcamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgHinh;
    Button btnCamera;
    int REQUESTCODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgHinh = (ImageView)findViewById(R.id.imageViewHinh);
        btnCamera = (Button)findViewById(R.id.buttonCamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUESTCODE);
            }
        });
    }

   @Override /*Trả lại kết quả*/
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUESTCODE && resultCode ==  RESULT_OK){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            imgHinh.setImageBitmap(bitmap);

        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
