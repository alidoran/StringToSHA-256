package com.example.stringtosha_256;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String input = "Sample String";
        String stringHashCode = "";
        try {
            MessageDigest objSHA = MessageDigest.getInstance("SHA-256");
            byte[] bytSHA = objSHA.digest(input.getBytes());
            BigInteger intNumber = new BigInteger(1, bytSHA);
            stringHashCode = intNumber.toString(16);
            while (stringHashCode.length() < 64) {
                stringHashCode = "0" + stringHashCode;
            }
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, stringHashCode, Toast.LENGTH_SHORT).show();

    }
}
