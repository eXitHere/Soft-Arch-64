package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Arrays;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JSONObject jsonObj;
    private JSONArray jsonArr;

    public JSONBookMetadataFormatter() {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        // clear all
        try {
            jsonObj = new JSONObject();
            jsonArr = new JSONArray();

            jsonObj.put(Book.class.getSimpleName() + "s", jsonArr);
        }
        catch(Exception error) {
            error.printStackTrace();
        }

        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        try{
            JSONObject tmp = new JSONObject();
            JSONArray authorsArr =  new JSONArray();
            for(String author : b.getAuthors()) {
                authorsArr.add(author);
            };
            tmp.put(Book.Metadata.ISBN.value, b.getISBN());
            tmp.put(Book.Metadata.TITLE.value, b.getTitle());
            tmp.put(Book.Metadata.PUBLISHER.value, b.getPublisher());
            tmp.put(Book.Metadata.AUTHORS.value, authorsArr);
            jsonArr.add(tmp);
        }
        catch(Exception error) {
            error.printStackTrace();
        }

        return this;
    }

    @Override
    public String getMetadataString() {
        return jsonObj.toJSONString();
    }
}
