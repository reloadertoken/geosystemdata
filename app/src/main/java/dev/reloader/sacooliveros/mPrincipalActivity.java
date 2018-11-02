package dev.reloader.sacooliveros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import dev.reloader.sacooliveros.Helico_Materiales.HelicoMaterialesActivity;

public class mPrincipalActivity extends AppCompatActivity {

    FrameLayout fr_helicomateriales, fr_helicodiapositiva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mprincipalactivity);

        fr_helicomateriales= findViewById(R.id.fr_helicomateriales);
        fr_helicodiapositiva= findViewById(R.id.fr_helicodiapositiva);

        fr_helicomateriales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Helico Materiales  A", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(mPrincipalActivity.this, HelicoMaterialesActivity.class);
                startActivity(intent);
            }
        });

        fr_helicodiapositiva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Helico Diapositivas A", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
