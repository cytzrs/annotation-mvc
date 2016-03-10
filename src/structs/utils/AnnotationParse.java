package structs.utils;

import annotation.Controller;
import annotation.MyService;
import annotation.ResponseBody;
import structs.form.XmlBean;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liyang on 2016/3/10.
 */
public class AnnotationParse {

    public static Map<String, XmlBean> parse(String path) {
        Map<String, XmlBean> map = new HashMap<>();
        String p = Thread.currentThread().getContextClassLoader().getResource("").getPath() + path;
        String[] fileNames = new File(p).list();
        XmlBean xmlBean = new XmlBean();
        Map<String, String> mmap = new HashMap<>();
        for(String fileName : fileNames) {
            try {
                String className = path + "." + fileName;
                className = className.substring(0, className.lastIndexOf('.'));
                Class<?> cls = Class.forName(className);
                if(cls.isAnnotationPresent(MyService.class)) {
                    Method[] methods = cls.getDeclaredMethods();
                    for (Method m: methods) {
                        if(m.isAnnotationPresent(Controller.class)) {
                            Controller c = m.getAnnotation(Controller.class);
                            String name = c.name();
                            String formClass = c.formClass();
                            String acitonClass = c.actionClass();
                            String paht = c.path();
                            ResponseBody[] urls = c.urls();
                            Map<String, String> url = new HashMap<>();
                            for(ResponseBody r: urls) {
                                url.put(r.name(), r.value());
                            }
                            xmlBean.setForward(url);
                            xmlBean.setName(name);
                            xmlBean.setFormClass(formClass);
                            xmlBean.setActionPath(paht);
                            xmlBean.setActionType(acitonClass);
                            map.put(paht, xmlBean);
                        }
                    }
                } else {
                    return map;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return map;
    }

    public static void main(String[] args) {
        AnnotationParse.parse("/annotation");
    }
}
