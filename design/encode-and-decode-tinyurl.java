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

    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) return longToShort.get(longUrl);
        String shortUrl = base + counter++;
        shortToLong.put(shortUrl, longUrl);
        longToShort.put(longUrl, shortUrl);
        return shortUrl;
    }

    public String decode(String shortUrl) {
        return shortToLong.get(shortUrl);
    }
}

// Codec codec = new Codec();
// codec.decode(codec.encode(url));