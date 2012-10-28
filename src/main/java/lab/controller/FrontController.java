package lab.controller;

import lab.util.ApplictionResources;
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
    }

    public void destroy() {
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException,
            IOException {

        ApplictionResources applictionResources = ApplictionResources.getInstance();
        applictionResources.setContext(getServletContext());

        PageViewer helper = new PageViewer(request);
        IViewMaker command = helper.getCommand();
        String page = command.makeView(request, response);




        dispatch(request, response, page);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {
        //super.doGet(request, response);

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
            page.replace(".fc", ".jsp");
            response.sendRedirect("/" + page);
        } else {
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }
    }
}
