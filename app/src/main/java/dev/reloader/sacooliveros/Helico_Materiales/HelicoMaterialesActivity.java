package dev.reloader.sacooliveros.Helico_Materiales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import dev.reloader.sacooliveros.Helico_Materiales.Tomos.Tomo1Activity;
import dev.reloader.sacooliveros.R;

public class HelicoMaterialesActivity extends AppCompatActivity {

    FrameLayout fr_tomo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helico_materiales);

        fr_tomo1= findViewById(R.id.fr_tomo1);


        fr_tomo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Tomo 1", Toast.LENGTH_SHORT).show();

                Intent intent= new Intent(HelicoMaterialesActivity.this, Tomo1Activity.class);
                startActivity(intent);


            }
        });

    }
}
