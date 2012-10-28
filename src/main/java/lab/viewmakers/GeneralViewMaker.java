package lab.viewmakers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/23/12
 * Time: 7:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class GeneralViewMaker implements IViewMaker {
    @Override
    public String makeView(HttpServletRequest request, HttpServletResponse response) {
        if (request.getRequestURI().contains("index")) {
            return request.getContextPath() + "/" + "index.jsp";
        }
        return request.getRequestURI().substring(request.getContextPath().length());
    }
}
