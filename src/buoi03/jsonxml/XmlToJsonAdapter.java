package buoi03.jsonxml;

import org.json.JSONObject;
import org.json.XML;

public class XmlToJsonAdapter implements DataAdapter {

    // Chuyển XML thành JSON
    @Override
    public String convertToJson(String xmlData) {
        JSONObject json = XML.toJSONObject(xmlData);
        return json.toString(4); // Format đẹp
    }

    // Chuyển JSON thành XML
    @Override
    public String convertToXml(String jsonData) {
        JSONObject json = new JSONObject(jsonData);
        return XML.toString(json);
    }
}
