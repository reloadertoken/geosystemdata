package dev.reloader.sacooliveros.Helico_Materiales.Tomos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import dev.reloader.sacooliveros.Helico_Materiales.Tomos.Materias.CienciasActivity;
import dev.reloader.sacooliveros.R;

public class Tomo1MenuActivity extends AppCompatActivity {

    FrameLayout frciencias;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomomenu1);

        frciencias= findViewById(R.id.fr_ciencias);

        frciencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Ciencias", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Tomo1MenuActivity.this, CienciasActivity.class);
                startActivity(intent);
            }
        });


    }
}
