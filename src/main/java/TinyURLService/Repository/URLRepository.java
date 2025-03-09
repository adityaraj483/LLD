package TinyURLService.Repository;

import java.util.HashMap;
import java.util.Map;

public class URLRepository {
    Map<Long, String> codeVSUrl;
    Long code;
    public URLRepository(){
        this.codeVSUrl = new HashMap<>();
        code = 1000000L;
    }

    public Map<Long, String> getCodeVSUrl() {
        return codeVSUrl;
    }

    public void setCodeVSUrl(Map<Long, String> codeVSUrl) {
        this.codeVSUrl = codeVSUrl;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }
}
