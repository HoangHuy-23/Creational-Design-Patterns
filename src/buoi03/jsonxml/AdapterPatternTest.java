package buoi03.jsonxml;

public class AdapterPatternTest {
    public static void main(String[] args) {
        DataAdapter adapter = new XmlToJsonAdapter();

        // Dữ liệu XML đầu vào
        String xmlData = "<user><name>Hoàng Huy</name><age>22</age></user>";
        System.out.println("🔹 XML Input:\n" + xmlData);

        // Chuyển đổi XML → JSON
        String jsonData = adapter.convertToJson(xmlData);
        System.out.println("\n🔹 Converted JSON:\n" + jsonData);

        // Chuyển đổi ngược JSON → XML
        String convertedXml = adapter.convertToXml(jsonData);
        System.out.println("\n🔹 Converted XML:\n" + convertedXml);
    }
}

