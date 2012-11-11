package lab.controller;

import lab.util.ApplicationResources;
import lab.viewmakers.IViewMaker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/23/12
 * Time: 11:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class FrontController extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ApplicationResources applicationResources = ApplicationResources.getInstance();
        applicationResources.setContext(getServletContext());

    }

    public void destroy() {
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException,
            IOException {

        PageViewer helper = new PageViewer(request);
        IViewMaker command = helper.getCommand();
        String page = command.makeView(request, response);
        dispatch(request, response, page);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {

        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    protected void dispatch(HttpServletRequest request,
                            HttpServletResponse response, String page)
            throws IOException, ServletException {
        if (page.contains("index")) {
            String newPage = page.replace(".fc", ".jsp");
            response.sendRedirect("/" + newPage);
        } else {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }
    }
}
