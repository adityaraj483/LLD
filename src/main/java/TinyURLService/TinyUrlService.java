package TinyURLService;


import TinyURLService.Repository.URLRepository;

public class TinyUrlService {
    URLRepository repository;
    String baseURl;
    String characters;
    public TinyUrlService(){
        this.repository = new URLRepository();
        this.baseURl = "http://aditya.com/";
        characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // 62 digits
    }

    public String getTinyUrl(String url){
        Long id = repository.getCode();

        repository.getCodeVSUrl().put(id, url);
        return baseURl + generateTinyURL(id);
    }

    private String generateTinyURL(Long id) {
        StringBuilder url = new StringBuilder();
        while(id > 0){
            int index = (int) (id % 62);
            url.append(characters.charAt(index));
            id /=62;
        }
        return url.reverse().toString();
    }

    public String getActualURL(String tinyUrl){
        tinyUrl = tinyUrl.replace(baseURl, "");
        Long id = decode(tinyUrl);
        return repository.getCodeVSUrl().getOrDefault(id, "Not found");
    }

    private Long decode(String tinyUrl) {
        Long id = 0L;
        for(Character ch : tinyUrl.toCharArray()){
            id *= 62;
            if(ch <= 'z' && ch >= 'a'){
                id += ch - 'a';
            }else if(ch <= 'Z' && ch >= 'A'){
                id += ch - 'A' + 26;
            }else if(ch >= '0' && ch <= '9'){
                id += ch - '0' + 52;
            }
        }
        return id;
    }

}
