import java.util.HashMap;
import java.util.List;

public class SockResult {
    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer>  ar) {
        // Write your code here
        HashMap<Integer, Integer> sockMap = new HashMap<Integer, Integer>();
        int pairCount = 0;
        for (Integer i : ar) {
            if (sockMap.containsKey(i)) {
                int value = sockMap.get(i) + 1;
                sockMap.put(i, value);
            } else {
                sockMap.put(i, 1);
            }
        }

        for (Integer i : sockMap.values()) {
            int count = i / 2;
            pairCount += count;
        }

        return pairCount;
    }

}

