package com.example.apps2_proyecto_final_creacion_y_lectura_qr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity extends AppCompatActivity {
    EditText qrEdtTxt;
    Button btnGenerate;
    ImageView imgQrDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qrEdtTxt = findViewById(R.id.qrEdtTxt);
        btnGenerate = findViewById(R.id.btnGenerate);
        imgQrDisplay = findViewById(R.id.imgQrDisplay);
    }

    public void generateQR(View v){
        String data = qrEdtTxt.getText().toString();

        QRGEncoder qrgEncoder = new QRGEncoder(data, null, QRGContents.Type.TEXT, 200);
        try{
            Bitmap qrBits = qrgEncoder.encodeAsBitmap();
            imgQrDisplay.setImageBitmap(qrBits);
        }catch(WriterException e){
            e.printStackTrace();
        }
    }
}