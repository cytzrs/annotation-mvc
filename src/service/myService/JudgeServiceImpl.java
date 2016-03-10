package service.myService;


import service.vo.MessageBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cytzr on 2016/1/17.
 */
public class JudgeServiceImpl implements JudgeService {
    @Override
    public Map<String, MessageBean> getBean(String user) {
        boolean b = this.isuser(user);
        MessageBean msg = new MessageBean();
        Map<String, MessageBean> map = new HashMap<String, MessageBean>();
        String url = "";
        if(b) {
            msg.setName("Lucy");
            msg.setMessage("success");
            msg.setNick("Sawyer");
            msg.setDate("2015");
            map.put("/views/success.jsp", msg);
        }
        else {
            msg.setName("Lucy");
            msg.setMessage("failure");
            msg.setNick("Sawyer");
            msg.setDate("2015");
            map.put("/views/failure.jsp", msg);
        }

        return map;
    }

    private boolean isuser(String user) {
        boolean b = false;
        if(user.equals("liy")) {
            b = true;
        }
        return b;
    }
}
