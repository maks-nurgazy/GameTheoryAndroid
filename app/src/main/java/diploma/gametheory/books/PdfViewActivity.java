package diploma.gametheory.books;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import diploma.gametheory.R;

public class PdfViewActivity extends AppCompatActivity {

    PDFView pdfView;
    int position = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);
        pdfView = findViewById(R.id.pdfView);
        position =getIntent().getIntExtra("position", -1);
        viewPdf();

    }
    private void viewPdf(){
        pdfView.fromFile(ActivityBooks.mFiles.get(position))
                .enableSwipe(true)
                .enableAnnotationRendering(true)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }
}