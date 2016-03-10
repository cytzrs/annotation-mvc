package structs.utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by cytzr on 2016/1/17.
 */
public class ParseXml {

    public ParseXml() {

    }

    public void read(String path) throws ParserConfigurationException, SAXException, IOException {
        File inputFile = new File(path);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        UserHandler userhandler = new UserHandler();
        saxParser.parse(inputFile, userhandler);
        Map<String, Map<String, String>> maps = userhandler.getMaps();
        System.out.println("---------------------------------------");
        Set<String> set = maps.keySet();
        for(Iterator<String> it = set.iterator();it.hasNext();) {
            String key = it.next();

        }
    }

    public static void main(String[] arguments) throws IOException, SAXException, ParserConfigurationException {
        new ParseXml().read("C:/Users/cytzr/IdeaProjects/untitled/web/resources/demo.xml");
    }
}

class UserHandler extends DefaultHandler {
    boolean bFirstName = false;
    boolean bLastName = false;
    boolean bNickName = false;
    boolean bMarks = false;
    String rollNo = "";

    Map<String, Map<String, String>> maps = new HashMap<String, Map<String, String>>();
    Map<String, String> map = new HashMap<String, String>();
    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            rollNo = attributes.getValue("rollno");
            System.out.println("Roll No : " + rollNo);
        } else if (qName.equalsIgnoreCase("firstname")) {
            bFirstName = true;
        } else if (qName.equalsIgnoreCase("lastname")) {
            bLastName = true;
        } else if (qName.equalsIgnoreCase("nickname")) {
            bNickName = true;
        }
        else if (qName.equalsIgnoreCase("marks")) {
            bMarks = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            System.out.println("End Element :" + qName);
            maps.put(rollNo, map);
        }

    }

    @Override
    public void characters(char ch[],
                           int start, int length) throws SAXException {

        if (bFirstName) {
            System.out.println("First Name: "
                    + new String(ch, start, length));
            String fName = new String(ch, start, length);
            map.put("fName", fName);
            bFirstName = false;
        } else if (bLastName) {
            System.out.println("Last Name: "
                    + new String(ch, start, length));
            String lName = new String(ch, start, length);
            map.put("lName", lName);
            bLastName = false;
        } else if (bNickName) {
            System.out.println("Nick Name: "
                    + new String(ch, start, length));
            String nickName = new String(ch, start, length);
            map.put("nickName", nickName);
            bNickName = false;
        } else if (bMarks) {
            System.out.println("Marks: "
                    + new String(ch, start, length));
            String marks = new String(ch, start, length);
            map.put("marks", marks);
            bMarks = false;
        }

    }

    public Map<String, Map<String, String>> getMaps() {
        return this.maps;
    }
}
