import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;

public class CreatePDF {

    public static void main(String[] args) throws FileNotFoundException {
        String pdfName = "invoice.pdf";
        PdfWriter pdfWriter = new PdfWriter(pdfName);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();
        Document document = new Document(pdfDocument);

        // First set size of page.
        pdfDocument.setDefaultPageSize(PageSize.A4);

        Invoice invoice = new Invoice();

        document.add(invoice.addHeaderTableToPDF());
        document.add(new Paragraph("\n"));
        document.add(invoice.customerInfoTable());
        document.add(new Paragraph("\n"));
        document.add(invoice.itemInfoTable());
        document.add(new Paragraph("\n\n"));
        invoice.signatory(document);

        document.close();
        System.out.println("Your PDF invoice has been created!!!");
    }

}

