import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

The basic level of the in-memory database contains records. Each record can be accessed with a unique identifier key of string type. A record may contain several field-value pairs, both of which are of string type.

SET <key> <field> <value> — should insert a field-value pair to the record associated with key. If the field in the record already exists, replace the existing value with the specified value. If the record does not exist, create a new one. This operation should return an empty string.

        GET <key> <field> — should return the value contained within field of the record associated with key. If the record or the field doesn't exist, should return an empty string.

DELETE <key> <field> — should remove the field from the record associated with key. Returns "true" if the field was successfully deleted, and "false" if the key or the field do not exist in the database.

        Examples
The example below shows how these operations should work (the section is scrollable to the right):

Queries	Explanations
queries = [
        ["SET", "A", "B", "E"],
        ["SET", "A", "C", "F"],
        ["GET", "A", "B"],
        ["GET", "A", "D"],
        ["DELETE", "A", "B"],
        ["DELETE", "A", "D"]
        ]

returns ""; database state: {"A": {"B": "E"}}
returns ""; database state: {"A": {"C": "F", "B": "E"}}
returns "E"
returns ""
returns "true"; database state: {"A": {"C": "F"}}
returns "false"; database state: {"A": {"C": "F"}}

the output should be ["", "", "E", "", "true", "false"].
 */
public class Cache {

    public String[] cache(String[][] queries) {
        Map<String, Map<String, String>> container = new HashMap<>();
        List<String> results = new ArrayList<>();

        for (String[] query : queries) {
            String operation = query[0];
            String key = query[1];
            String field = query[2];

            switch (operation) {
                case "SET" :
                    String value = query.length > 3 ? query[3] : "";
                    container.computeIfAbsent(key, k -> new HashMap<>()).put(field, value);
                    results.add("SET");
                    break;
                case "GET" :
                    Map<String, String> record = container.get(key);
                    if (record == null || !record.containsKey(field)) {
                        results.add("GET for " + key +"-" + field + "-" +  "No Value");
                    } else {
                        results.add("GET for " + key +"-" + field + "-" + record.get(field));
                    }
                    break;
                case "DELETE" :
                    Map<String, String> deleteRecord = container.get(key);

                    if(deleteRecord != null && deleteRecord.containsKey(field)) {
                        deleteRecord.remove(field);
                        results.add("DELETE for " + key +"-" + field + "-" + "true");
                    } else {
                        results.add("DELETE for " + key +"-" + field + "-" + "false");
                    }
                    break;
            }

        }
        return results.toArray(new String[0]);
    }


    public static void main(String[] args) {
        Cache db = new Cache();

        String[][] queries = {
                {"SET", "A", "B", "E"}, // SET
                {"SET", "A", "C", "F"}, // SET
                {"GET", "A", "B"}, // GET E
                {"GET", "A", "D"}, // GET NO VALUE
                {"DELETE", "A", "B"}, // DELETE A-B true
                {"DELETE", "A", "D"}}; // DELETE NO false
        String[] results = db.cache(queries);

        for(String s : results) {
            System.out.print(s + ";");
        }
    }
}
