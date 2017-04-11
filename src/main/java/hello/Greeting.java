package hello;

import io.swagger.annotations.ApiModel;

public class Greeting {

    /**
     * ID
     */
    private final long id;

    /**
     * お名前
     */
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
