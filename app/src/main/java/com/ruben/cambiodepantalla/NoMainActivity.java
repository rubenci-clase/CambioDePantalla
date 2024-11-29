package com.ruben.cambiodepantalla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NoMainActivity extends AppCompatActivity {

    public static int RESULT_CODE_MISSING_NAME = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.no_main_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String nombre = getIntent().getStringExtra("NOMBRE");
        TextView byeText = findViewById(R.id.byetext);

        if(nombre != null || nombre.isEmpty()) {
            byeText.setText("Bye " + nombre);

        }
        else{
            //byeText.setText("Bye world!");
            setResult(RESULT_CODE_MISSING_NAME);
            finish();
            return;

        }

        findViewById(R.id.miBoton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent( NoMainActivity.this, MainActivity.class);
                startActivity(inten);
            }
        });

    }
}