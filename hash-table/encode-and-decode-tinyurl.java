import java.util.*;

public class Codec {
    private Map<String, String> shortToLong;
    private Map<String, String> longToShort;
    private String base;
    private int counter;

    public Codec() {
        shortToLong = new HashMap<>();
        longToShort = new HashMap<>();
        base = "http://tinyurl.com/";
        counter = 1;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return longToShort.get(longUrl);
        }
        String shortUrl = base + counter++;
        shortToLong.put(shortUrl, longUrl);
        longToShort.put(longUrl, shortUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLong.get(shortUrl);
    }

    // Simple tests
    public static void main(String[] args) {
        Codec codec = new Codec();

        String url1 = "https://leetcode.com/problems/design-tinyurl";
        String tiny1 = codec.encode(url1);
        String original1 = codec.decode(tiny1);
        System.out.println("Original: " + url1);
        System.out.println("Tiny: " + tiny1);
        System.out.println("Decoded: " + original1);
        System.out.println();

        String url2 = "https://openai.com/research";
        String tiny2 = codec.encode(url2);
        String original2 = codec.decode(tiny2);
        System.out.println("Original: " + url2);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));