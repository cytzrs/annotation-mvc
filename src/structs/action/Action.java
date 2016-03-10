package structs.action;

import structs.form.ActionForm;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by cytzr on 2016/1/17.
 */
public interface Action {

    public String execute(HttpServletRequest request, ActionForm form, Map<String, String> forward);
}
