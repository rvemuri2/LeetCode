import java.util.*;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder); // Sort folders lexicographically
        List<String> result = new ArrayList<>();
        
        for (String f : folder) {
            // If result is empty or f is not a subfolder of the last added folder
            if (result.isEmpty() || !f.startsWith(result.get(result.size() - 1) + "/")) {
                result.add(f);
            }
        }

        return result;
    }

    public static void main(String[] args) {}
}
