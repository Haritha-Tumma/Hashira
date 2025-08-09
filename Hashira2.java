import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hashira2 {
    public static void main(String[] args) throws Exception {
        // Read the JSON file
        String content = new String(Files.readAllBytes(Paths.get("data.json")));

        // Parse JSON
        JSONObject jsonObj = new JSONObject(content);

        // Print "keys"
        JSONObject keys = jsonObj.getJSONObject("keys");
        System.out.println("n = " + keys.getInt("n"));
        System.out.println("k = " + keys.getInt("k"));

        // Loop through numbered keys
        for (int i = 1; i <= keys.getInt("n"); i++) {
            JSONObject obj = jsonObj.getJSONObject(String.valueOf(i));
            int base = obj.getInt("base");
            String value = obj.getString("value");

            // Convert to decimal
            long decimalValue = Long.parseLong(value, base);
            System.out.println(i + ": base " + base + " => decimal " + decimalValue);
        }
    }
}
