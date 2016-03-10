package structs.utils;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import structs.form.XmlBean;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cytzr on 2016/1/18.
 */
public class Structs_xml {

    public static Map<String, XmlBean> parse(String formbean) {
        Map<String, XmlBean> rmap = new HashMap<String, XmlBean>();
        SAXBuilder builder = new SAXBuilder();
        try {
            Document document = builder.build(new File(formbean));
            Element root = document.getRootElement();
            /*Element formBeansRoot = root.getChild("formbeans");
            List<Element> formBeans = formBeansRoot.getChildren();
            for(Element e : formBeans) {
                String name = e.getAttributeValue("name");
                String cl = e.getAttributeValue("class");
                System.out.println(name + " - " + cl);
            }*/
            Map<String, String> map = new HashMap<String, String>();

            Element actionMappingRoot = root.getChild("action-mapping");
            List<Element> actionMapping = actionMappingRoot.getChildren();
            for(Element e : actionMapping) {
                XmlBean bean = new XmlBean();
                String name= e.getAttributeValue("name");
                String type = e.getAttributeValue("type");
                String path = e.getAttributeValue("path");
                bean.setName(name);
                bean.setActionType(type);
                bean.setActionPath(path);
                Element formBeansRoot = root.getChild("formbeans");
                List<Element> formBeans = formBeansRoot.getChildren();
                for(Element fx : formBeans) {
                    if(name.equals(fx.getAttributeValue("name"))) {
                        bean.setFormClass(fx.getAttributeValue("class"));
                    }
                }
                System.out.println(name + " -- " + type + " " + path);
                //Element forwardRoot = e.getChild("forward");
                List<Element> forwards = e.getChildren();
                for(Element f : forwards) {
                    String fName = f.getAttributeValue("name");
                    String fValue = f.getAttributeValue("value");
                    System.out.println(fName + " --- " + fValue);
                    map.put(fName, fValue);
                }
                bean.setForward(map);
                rmap.put(path, bean);
            }
            System.out.println("--------------");
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rmap;
    }

}
