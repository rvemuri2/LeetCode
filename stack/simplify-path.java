import java.util.*;

public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();
        Iterator<String> it = stack.descendingIterator();
        while (it.hasNext()) {
            result.append("/").append(it.next());
        }

        return result.length() > 0 ? result.toString() : "/";
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] testPaths = {
            "/home/",
            "/../",
            "/home//foo/",
            "/a/./b/../../c/",
            "/.../a/../b",
        };

    }
}