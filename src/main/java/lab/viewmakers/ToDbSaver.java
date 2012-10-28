package lab.viewmakers;

import lab.dao.PersonDao;
import lab.domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/28/12
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class ToDbSaver implements IViewMaker {
    @Override
    public String makeView(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        Person person = new Person((String) session.getAttribute("firstName"), (String) session.getAttribute("lastName"), (String) session.getAttribute("middleName"), (String) request.getParameter("data"));
        (new PersonDao()).insert(person);

        return "index.jsp";
    }
}