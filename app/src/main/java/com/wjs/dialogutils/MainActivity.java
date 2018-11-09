package com.wjs.dialogutils;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wjs.dialogutils2.ConfirmDialog;

import static com.wjs.dialogutils2.ConfirmDialog.MODE_SURE_OR_CANCLE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConfirmDialog dialog=new ConfirmDialog(this);
        dialog.setDialogMode(ConfirmDialog.MODE_SURE_OR_CANCLE);
        dialog.show();
    }
}
