package TinyURLService;

public class Main {
    public static void main(String[] args) {
        TinyUrlService service = new TinyUrlService();
        String url = "https://long/long/longutl";
        String tiny = service.getTinyUrl(url);
        String actual = service.getActualURL(tiny);

        System.out.println(tiny);
        System.out.println(actual);
    }
}
