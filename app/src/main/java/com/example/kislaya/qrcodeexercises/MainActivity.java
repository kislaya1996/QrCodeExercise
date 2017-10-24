package com.example.kislaya.qrcodeexercises;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void QrGenerate(View view) throws Exception
    {
        EditText txtInput = (EditText) findViewById(R.id.txtInput);
        String message = txtInput.getText().toString();
        MultiFormatWriter mfw = new MultiFormatWriter();
        BitMatrix bmat = mfw.encode(message, BarcodeFormat.QR_CODE,200,200);
        BarcodeEncoder benc = new BarcodeEncoder();
        Bitmap bmap = benc.createBitmap(bmat);
        ImageView imgBarcode = (ImageView) findViewById(R.id.imgBarcode);
        imgBarcode.setImageBitmap(bmap);

    }
}
