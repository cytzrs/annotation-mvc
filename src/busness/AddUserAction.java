package busness;

import structs.action.Action;
import structs.form.ActionForm;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by cytzr on 2016/1/19.
 */
public class AddUserAction implements Action {
    @Override
    public String execute(HttpServletRequest request, ActionForm form, Map<String, String> forward) {
        String url = "failure";
        AddUserForm myForm = (AddUserForm) form;
        if(myForm.getName().equals("liy")) {
            url = "success";
        }
        return forward.get(url);
    }
}
