import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;

public class Invoice {

    float col = 280f;
    float[] headerTableColumnWidth = {col, col};
    float[] customerInfoTableColumnWidth = {80, 300, 100, 80};
    float[] itemInfoColumnWidth = {140, 140, 140, 140};

    public Invoice() {
    }

    public Table addHeaderTableToPDF(){

        Table headerTable = new Table(headerTableColumnWidth);
        // Styling of the table
        headerTable.setBackgroundColor(new DeviceRgb(63, 169, 219)).setFontColor(ColorConstants.WHITE);

        Style headerStyle = new Style()
                .setBorder(Border.NO_BORDER)
                .setPadding(25f);


        headerTable.addCell(new Cell().add(new Paragraph("INVOICE")).addStyle(headerStyle)
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setMarginTop(50f)
                .setMarginBottom(50f)
                .setFontSize(30f)
        );
        headerTable.addCell(new Cell().add(new Paragraph("Odazie Technologies\n 48 Tech Street\n +1 (934) 443344")).addStyle(headerStyle)
                .setTextAlignment(TextAlignment.RIGHT)
                .setMarginTop(30f)
                .setMarginBottom(30f)
                .setMarginRight(10f)
        );
        return headerTable;
    }

    public Table customerInfoTable(){
        Table customerInfoTable = new Table(customerInfoTableColumnWidth);

        Style customerInfoStyle = new Style().setBorder(Border.NO_BORDER);


        customerInfoTable.addCell(new Cell(0, 4) //expanding column span minute 12:20
                .add(new Paragraph("Customer Information").setBold()).addStyle(customerInfoStyle));

        customerInfoTable.addCell(new Cell().add(new Paragraph("Name:")).addStyle(customerInfoStyle));
        customerInfoTable.addCell(new Cell().add(new Paragraph("John Doe")).addStyle(customerInfoStyle));
        customerInfoTable.addCell(new Cell().add(new Paragraph("Invoice No:")).addStyle(customerInfoStyle));
        customerInfoTable.addCell(new Cell().add(new Paragraph("4343")).addStyle(customerInfoStyle));

        customerInfoTable.addCell(new Cell().add(new Paragraph("Mobile:")).addStyle(customerInfoStyle));
        customerInfoTable.addCell(new Cell().add(new Paragraph("+22325343233")).addStyle(customerInfoStyle));
        customerInfoTable.addCell(new Cell().add(new Paragraph("Date:")).addStyle(customerInfoStyle));
        customerInfoTable.addCell(new Cell().add(new Paragraph("28-02-2022")).addStyle(customerInfoStyle));



        return customerInfoTable;
    }

    public Table itemInfoTable(){

        Table itemInfoTable = new Table (itemInfoColumnWidth);

        Style firstRowStyle = new Style()
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(ColorConstants.WHITE);

        itemInfoTable.addCell(new Cell().add(new Paragraph("Service")).addStyle(firstRowStyle));

        itemInfoTable.addCell(new Cell().add(new Paragraph("Hours:")).addStyle(firstRowStyle));



        itemInfoTable.addCell(new Cell().add(new Paragraph("Unit Price (USD)"))
                .addStyle(firstRowStyle)
                .setTextAlignment(TextAlignment.RIGHT)
        );
        itemInfoTable.addCell(new Cell().add(new Paragraph("Amount"))
                .addStyle(firstRowStyle)
                .setTextAlignment(TextAlignment.RIGHT)
        );


        itemInfoTable.addCell(new Cell().add(new Paragraph("App Creation")));
        itemInfoTable.addCell(new Cell().add(new Paragraph("30")));
        itemInfoTable.addCell(new Cell().add(new Paragraph("250")).setTextAlignment(TextAlignment.RIGHT));
        itemInfoTable.addCell(new Cell().add(new Paragraph("" +30 * 250)).setTextAlignment(TextAlignment.RIGHT));


        Style lastRowStyle = new Style()
                .setBold()
                .setTextAlignment(TextAlignment.RIGHT)
                .setBorder(Border.NO_BORDER);

        itemInfoTable.addCell(new Cell().add(new Paragraph("")).addStyle(lastRowStyle));

        itemInfoTable.addCell(new Cell().add(new Paragraph("")).addStyle(lastRowStyle));

        itemInfoTable.addCell(new Cell().add(new Paragraph("Total Amount:")).addStyle(lastRowStyle));
        itemInfoTable.addCell(new Cell().add(new Paragraph("7500")).addStyle(lastRowStyle));

        return itemInfoTable;
    }


    public void signatory(Document document){

        document.add(new Paragraph("__________________\n (Authorised Signatory)")
                .setTextAlignment(TextAlignment.RIGHT)
        );

    }
}
