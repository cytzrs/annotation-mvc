package structs.form;

import structs.utils.AnnotationParse;
import structs.utils.Structs_xml;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cytzr on 2016/1/19.
 */
public class ActionListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Map<String, XmlBean> bigMap = new HashMap<>();
        ServletContext context = servletContextEvent.getServletContext();
        String xmlPath = context.getInitParameter("structs-config.xml");
        String annotationPath = context.getInitParameter("annotation");
        //String tomcatPath = context.getRealPath("\\");
        Map<String, XmlBean> map = Structs_xml.parse(xmlPath);
        Map<String, XmlBean> map1 = AnnotationParse.parse(annotationPath);
        bigMap.putAll(map);
        bigMap.putAll(map1);
        context.setAttribute("struts", bigMap);
        System.out.println("信息: 系统加载已完成!!!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("信息: 系统已注销!!!");
    }
}
