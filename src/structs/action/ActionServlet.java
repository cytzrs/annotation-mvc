package structs.action;

import busness.JudgeAction;
import structs.form.ActionForm;
import structs.form.FullForm;
import structs.form.XmlBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by cytzr on 2016/1/16.
 */
public class ActionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        /*String url = "";
        Action action = new JudgeAction();
        url = action.execute(request);
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);*/
        //System.out.println(request.getServletPath());
        String servletPath = this.getPath(request.getServletPath());
        Map<String, XmlBean> xmlBeanMap = (Map<String, XmlBean>) this.getServletContext().getAttribute("struts");
        XmlBean bean = xmlBeanMap.get(servletPath);
        /*String beanName = bean.getBeanName();
        String beanClass = bean.getBeanClass();
        String beanType = bean.getBeanType();*/
        String name = bean.getName();
        String formClass = bean.getFormClass();
        String actionPath = bean.getActionPath();
        String actionType = bean.getActionType();
        Map<String, String> forward = bean.getForward();
        ActionForm form = FullForm.full(formClass, request);
        String url = "";
        try {
            Class cl = Class.forName(actionType);
            Action action = (Action) cl.newInstance();
            url = action.execute(request, form, forward);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doGet(request, response);
    }

    private String getPath(String servletPath) {
        String[] str  = servletPath.split("\\.");
        return str[0];
    }
}
