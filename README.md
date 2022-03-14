# iText-7-High-Level-API-DEMO

The code in this repository, generates a PDF invoice using the iText 7 Suite High Level API. See/download the generated PDF in `invoice.pdf`.

## Prerequisite
To follow along in this `README.md`, first read this article on [Getting Started with iText 7 Suite in Java]()


## How it works
The file `invoice.pdf` generated, is made up of 3 `Table` block elements with one `Paragraph` block element styled and added to the root element (`Document`).

The `addHeaderTableToPDF()` method of `/src/main/java/Invoice.java` class forms the header (first table) of the Invoice.

```
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

```

In the above `addHeaderTableToPDF` method:

- The first line of code creates an instance of the `Table` class `headerTable` taking parameter of a defined `headerTableColumnWidth` (2 columns).
- The next line, sets the background & font color of the `headerTable` using methods inherited from the [`ElementPropertyContainer`](https://api.itextpdf.com/iText7/java/7.2.1/com/itextpdf/layout/ElementPropertyContainer.html) — a superclass of all [layout object](https://api.itextpdf.com/iText7/java/7.2.1/com/itextpdf/layout/element/IElement.html) implementations.
- The next line of code is an instance of `Style` - a container object for style properties of an element. Using a `Style`object, you can apply different properties (font, font color, background color, font size,...) in one go with the `addStyle()` method reducing the amount of code to style elements in your `document`.
- The next line adds a `Cell` - a one piece of data in an enclosing grid, of block element `Paragraph` with `“Invoice”` text object to the first column of the header table and styles it with the `ElementPropertyContainer` methods.
- The last line of code does the same but with address text to the second column.



The `customerInfoTable()` method of `/src/main/java/Invoice.java` class forms the customer info section of the Invoice:


```
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
```
In the above `customerInfoTable` method:

- After the instance of the `Table` class `customerInfoTable`.
- The next line of code adds the text `“Customer Information”` to the table. The rowspan & colspan parameters `Cell (1, 4)` states that the text should occupy 1 row and 4 columns. The `customerInfoTableColumnWidth` defines 4 columns for the `customerInfoTable`.
- The following lines of code hard codes the rest of the customer details across the 4 columns creating 2 more rows.

<b>Note</b>: To understand how the last bullet point works: After creating a table with 4 column widths, when you add cells to each column, once it reaches the 4th, the next cell added creates a new row in the table.


- The `.setBorder``(``Border.``NO_BORDER)` of the `ElementPropertyContainer` class set by the `customerInfoStyle` object removes the border of each cell.



The `itemInfoTable()` method of `/src/main/java/Invoice.java` class forms the item info section of the Invoice:


```
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

```


In the above `itemInfoTable()` method:

- After the instance of the `Table` class `itemInfoTable`
- The next 4 lines of code adds new cells (labels) to the defined 4 columns of the table
- And the next 4 lines hard codes item information on a new row under the labels.
- The last 4 structures the `Total` of the invoice.

You can find these methods added to the `Document` in the `main` method of the `CreatePDF` class to generate the Invoice PDF.

## Resources

To learn more about the iText 7 Suite, check the following resources:

- [iText 7 Core Documentation](https://api.itextpdf.com/iText7/java/7.2.1/)
- [iText 7: Building Blocks](https://kb.itextpdf.com/home/it7kb/ebooks/itext-7-building-blocks)
- [iText 7: Jump-Start Tutorial for Java](https://kb.itextpdf.com/home/it7kb/ebooks/itext-7-jump-start-tutorial-for-java)
- [iText 7: Converting HTML to PDF with pdfHTML](https://kb.itextpdf.com/home/it7kb/ebooks/itext-7-converting-html-to-pdf-with-pdfhtml)
- [Blockchain for PDF Documents](https://kb.itextpdf.com/home/it7kb/ebooks/blockchain-for-pdf-documents)
- [Best iText 7 Questions on StackOverflow Answered](https://kb.itextpdf.com/home/it7kb/ebooks/best-itext-7-questions-on-stackoverflow)
