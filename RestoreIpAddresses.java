import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * Error case that I had while trying. Does not allow 010, 00, 001
 * Input: "010010"
 * Output: ["0.1.0.10","0.1.0.10","0.1.1.0","0.10.0.10","0.10.1.0","0.100.1.0","1.0.0.10","1.0.1.0","1.0.1.0","10.0.1.0"]
 * Expected: ["0.10.0.10","0.100.1.0"]
 * 
 * @author joshluo
 * 
 */
public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        assert (s != null);
        List<String> result = new ArrayList<String>();
        int depth = 0;
        String ipAddress = "";
        restoreIpAddresses(s, ipAddress, depth, result);
        return result;
    }

    private void restoreIpAddresses(String s, String ipAddress, int depth, List<String> result) {
        if (depth == 4) {
            if (s.isEmpty()) {
                result.add(ipAddress.substring(0, ipAddress.length() - 1)); // remove last .
            }
            return;
        }
        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            int block = Integer.valueOf(s.substring(0, i));
            if (0 <= block && block <= 255 && String.valueOf(block).length() == i) {
                restoreIpAddresses(s.substring(i), ipAddress + String.valueOf(block) + ".", depth + 1, result);
            }
        }
    }

    public static void main(String args[]) {
        System.out.println(new RestoreIpAddresses().restoreIpAddresses("010010"));
    }
}
