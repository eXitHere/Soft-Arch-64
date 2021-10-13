package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {

    public void export(PrintStream stream) throws IOException, ParserConfigurationException {
        BookMetadataFormatter formatter = createBookExport();
        for(Book book : books) {
            formatter.append(book);
        }
        stream.print(formatter.getMetadataString());
    }

    public abstract BookMetadataFormatter createBookExport() throws IOException, ParserConfigurationException;
}
