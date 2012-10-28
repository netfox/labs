package lab.viewmakers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/23/12
 * Time: 7:07 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IViewMaker {
    String makeView(HttpServletRequest request, HttpServletResponse response);
}
