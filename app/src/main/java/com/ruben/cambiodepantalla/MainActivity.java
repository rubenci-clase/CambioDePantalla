package com.ruben.cambiodepantalla;

import static com.ruben.cambiodepantalla.NoMainActivity.RESULT_CODE_MISSING_NAME;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //findViewById(R.id.miBoton1).setOnClickListener(view -> setContentView(R.layout.no_main_activity));

        findViewById(R.id.miBoton1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNameText = ((EditText) findViewById(R.id.nombre)).getText().toString();

                Intent inten = new Intent(MainActivity.this, NoMainActivity.class);
                inten.putExtra("NOMBRE", userNameText);
                startActivityForResult(inten, RESULT_CODE_MISSING_NAME);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(resultCode, resultCode, intent);

        if(requestCode == RESULT_CODE_MISSING_NAME) {
            findViewById(R.id.errorText).setVisibility(View.VISIBLE);
        }
    }
}