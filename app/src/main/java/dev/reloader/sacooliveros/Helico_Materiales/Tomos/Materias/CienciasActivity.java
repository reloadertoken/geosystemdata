package dev.reloader.sacooliveros.Helico_Materiales.Tomos.Materias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.shockwave.pdfium.PdfDocument;

import java.util.List;

import dev.reloader.sacooliveros.R;

public class CienciasActivity extends AppCompatActivity implements OnPageChangeListener, OnLoadCompleteListener, OnPageErrorListener {

    PDFView pdfView;
    String pdfFileName;
    public static final String SAMPLE_FILE = "Helico_Materiales_pdf/cv_data.pdf";
    private static final String TAG = "PDFSaco";
    Integer pageNumber = 0;
    Integer pagecontador=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciencias);

        pdfView=  findViewById(R.id.pdfView);
        displayFromAsset(SAMPLE_FILE);

    }


    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(SAMPLE_FILE)
                .defaultPage(pageNumber)
                .onPageChange(this)
                //.enableDoubletap(true)
                //.swipeHorizontal(true)
                .pageSnap(true)
                .pageFling(true)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(0)
                .autoSpacing(false)
                .onPageError(this)
                .enableAntialiasing(true) // mejora  calidad de  imagen
                .nightMode(false) // toggle night mode
                .pageSnap(true)
                .password(null)
                .load();

    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        //page=0;
        pageNumber = page;
        pagecontador= pageCount;
        setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pagecontador));

    }




    @Override
    public void loadComplete(int nbPages) {

        PdfDocument.Meta meta = pdfView.getDocumentMeta();
        Log.e(TAG, "title = " + meta.getTitle());
        Log.e(TAG, "author = " + meta.getAuthor());
        Log.e(TAG, "subject = " + meta.getSubject());
        Log.e(TAG, "keywords = " + meta.getKeywords());
        Log.e(TAG, "creator = " + meta.getCreator());
        Log.e(TAG, "producer = " + meta.getProducer());
        Log.e(TAG, "creationDate = " + meta.getCreationDate());
        Log.e(TAG, "modDate = " + meta.getModDate());

        printBookmarksTree(pdfView.getTableOfContents(), "-");

    }

    private void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {

                for (PdfDocument.Bookmark b : tree) {

                Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));

                if (b.hasChildren()) {
                    printBookmarksTree(b.getChildren(), sep + "-");
                }
            }

    }

    @Override
    public void onPageError(int page, Throwable t) {
        Log.e(TAG, "Cannot load page " + page);

    }

}
