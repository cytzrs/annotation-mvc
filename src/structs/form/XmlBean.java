package structs.form;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cytzr on 2016/1/18.
 */
public class XmlBean {

    public XmlBean() {


    }

    private String name = "";
    private String formClass  = "";
    private String actionType   = "";
    private String actionPath   = "";
    private Map<String, String> forward = new HashMap<String, String>();

    public Map<String, String> getForward() {
        return forward;
    }

    public void setForward(Map<String, String> forward) {
        this.forward = forward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormClass() {
        return formClass;
    }

    public void setFormClass(String formClass) {
        this.formClass = formClass;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionPath() {
        return actionPath;
    }

    public void setActionPath(String actionPath) {
        this.actionPath = actionPath;
    }
}
