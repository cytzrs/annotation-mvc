package structs.form;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

/**
 * Created by cytzr on 2016/1/17.
 */
public class FullForm extends ActionForm {

    public FullForm() {

    }

    public static ActionForm full(String formPath, HttpServletRequest request) {
        ActionForm form = null;
        try {
            Class clzz = Class.forName(formPath);
            form = (ActionForm) clzz.newInstance();
            Field[] fields = clzz.getDeclaredFields();
            for(Field f:fields) {
                f.setAccessible(true);
                f.set(form, request.getParameter(f.getName()));
                f.setAccessible(false);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return form;
    }
}
