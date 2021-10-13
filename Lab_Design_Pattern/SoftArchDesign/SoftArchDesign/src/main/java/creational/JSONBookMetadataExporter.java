package creational;

import java.io.IOException;

public class JSONBookMetadataExporter extends BookMetadataExporter{
    @Override
    public BookMetadataFormatter createBookExport() throws IOException {
        return new JSONBookMetadataFormatter();
    }
}
