package busness;

import service.myService.JudgeService;
import service.myService.JudgeServiceImpl;
import service.vo.MessageBean;
import structs.action.Action;
import structs.form.ActionForm;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by cytzr on 2016/1/17.
 */
public class JudgeAction implements Action {
    @Override
    public String execute(HttpServletRequest request, ActionForm form, Map<String, String> forward) {
        String name = request.getParameter("text");
        String url = "";
        boolean b = this.isuser(name);
        Map<String, MessageBean> map = new HashMap<String, MessageBean>();
        JudgeService judge = new JudgeServiceImpl();
        map = judge.getBean(name);
        Set<String> set = map.keySet();
        for(Iterator<String> it=set.iterator(); it.hasNext();) {
           url = it.next();
            request.setAttribute("msg", map.get(url));
        }
        return url;
    }

    private boolean isuser(String user) {
        boolean b = false;
        if(user.equals("liy")) {
            b = true;
        }
        return b;
    }
}
