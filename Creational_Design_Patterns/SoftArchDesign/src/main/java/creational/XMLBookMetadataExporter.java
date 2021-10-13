package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XMLBookMetadataExporter extends BookMetadataExporter{
    @Override
    public BookMetadataFormatter createBookExport() throws IOException, ParserConfigurationException {
        return new XMLBookMetadataFormatter();
    }
}
