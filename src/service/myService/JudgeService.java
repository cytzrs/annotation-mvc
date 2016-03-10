package service.myService;


import service.vo.MessageBean;

import java.util.Map;

/**
 * Created by cytzr on 2016/1/17.
 */
public interface JudgeService {

    public Map<String, MessageBean> getBean(String user);
}
