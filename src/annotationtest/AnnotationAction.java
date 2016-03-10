package annotationtest;

import annotation.Controller;
import annotation.MyService;
import annotation.ResponseBody;
import busness.AddUserForm;
import structs.action.Action;
import structs.form.ActionForm;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by cytzr on 2016/3/10.
 */
@MyService
public class AnnotationAction implements Action {
    @Override
    @Controller(name = "user", formClass = "busness.AddUserForm", actionClass = "busness.AddUserAction", path = "/userAdd",
    urls = {@ResponseBody(name = "success", value = "/views/addUserSuccess.jsp"), @ResponseBody(name = "failure", value = "/views/addUserFailuer.jsp") })
    public String execute(HttpServletRequest request, ActionForm form, Map<String, String> forward) {
        String url = "failure";
        AddUserForm myForm = (AddUserForm) form;
        if(myForm.getName().equals("liy")) {
            url = "success";
        }
        return forward.get(url);
    }
}
