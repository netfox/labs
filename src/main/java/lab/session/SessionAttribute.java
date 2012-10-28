package lab.session;

import javax.faces.bean.SessionScoped;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: meloman
 * Date: 13.09.12
 * Time: 16:56
 */
@SessionScoped
public class SessionAttribute {
    private String param;
    private static List<String> accessibleNavigation = Arrays.asList("add.jsp", "/index.jsp", "/form1.jsp",
            "/form2.jsp", "/form3.jsp", "/form4.jsp", "/error.jsp");

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public boolean validateCurrentUrl(String requestUrl) {
        boolean result = true;
        if (requestUrl == null || requestUrl.isEmpty()) {
            return result;
        }
        if (param == null || param.isEmpty()) {
            return result;
        }

        if (accessibleNavigation.contains(requestUrl)) {
            int pos = accessibleNavigation.indexOf(requestUrl);
            int prevPos = accessibleNavigation.indexOf(param);
            return (pos > prevPos);
        }
        return result;
    }
}
