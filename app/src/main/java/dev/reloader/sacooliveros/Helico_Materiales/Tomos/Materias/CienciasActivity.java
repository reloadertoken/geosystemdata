package dev.reloader.sacooliveros.Helico_Materiales.Tomos.Materias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import dev.reloader.sacooliveros.R;

public class CienciasActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciencias);

         pdfView=  findViewById(R.id.pdfView);
        pdfView.fromAsset("Helico_Materiales_pdf/cv_data.pdf")
                //.defaultPage(2) // paginas  a  mostrar
                .load();

    }
}
