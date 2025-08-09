import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hashira {
    public static void main(String[] args) throws Exception {
        String jsonData = "{\n" +
                "    \"keys\": { \"n\": 4, \"k\": 3 },\n" +
                "    \"1\": { \"base\": \"10\", \"value\": \"4\" },\n" +
                "    \"2\": { \"base\": \"2\", \"value\": \"111\" },\n" +
                "    \"3\": { \"base\": \"10\", \"value\": \"12\" },\n" +
                "    \"6\": { \"base\": \"4\", \"value\": \"213\" }\n" +
                "}";

        // Parse JSON
        JSONObject obj = new JSONObject(jsonData);

        // Example: decode value of "2" from base 2
        JSONObject root2 = obj.getJSONObject("2");
        int base = Integer.parseInt(root2.getString("base"));
        String value = root2.getString("value");
        int decoded = Integer.parseInt(value, base);

        System.out.println("Decoded value for '2': " + decoded);
    }
}
