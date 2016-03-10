package service.vo;

/**
 * Created by cytzr on 2016/1/17.
 */
public class MessageBean {

    public MessageBean() {

    }

    private String name = "";
    private String message = "";
    private String nick = "";
    private String date = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
