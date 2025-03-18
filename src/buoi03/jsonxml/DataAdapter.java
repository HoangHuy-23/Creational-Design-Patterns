package buoi03.jsonxml;

public interface DataAdapter {
    String convertToJson(String xmlData);  // Chuyển XML → JSON
    String convertToXml(String jsonData);  // Chuyển JSON → XML
}
