package dev.reloader.sacooliveros.Helico_Materiales.Tomos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import dev.reloader.sacooliveros.R;

public class Tomo1Activity extends AppCompatActivity {
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomo1);

        pdfView=  findViewById(R.id.pdfView);
        pdfView.fromAsset("cv_data.pdf").load();
    }
}
