package lab.viewmakers;


import lab.converters.DTOPersonToXmlConverter;
import lab.dto.DtoPerson;
import lab.transformers.XSLTTransformer;
import lab.util.ApplictionResources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/23/12
 * Time: 7:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonViewMaker implements IViewMaker {
    @Override
    public String makeView(HttpServletRequest request, HttpServletResponse response) {
        String flScript = "/transformfiles/person.xsl";

        ApplictionResources applictionResources = ApplictionResources.getInstance();
        InputStream xsltInputStream = applictionResources.getResourceAsStream(flScript);

        HttpSession session = request.getSession();
        session.setAttribute("birthDate", (String) request.getParameter("data"));

        DtoPerson person = new DtoPerson((String) session.getAttribute("firstName"), (String) session.getAttribute("lastName"), (String) session.getAttribute("middleName"), (String) session.getAttribute("birthDate"));

        Source xmlSource = (new DTOPersonToXmlConverter()).convertToXml(person);
        
        XSLTTransformer transformer = new XSLTTransformer();



        try {
            transformer.transform(xmlSource, xsltInputStream, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String pageName = request.getRequestURI().substring(request.getContextPath().length());
        String page = pageName.replace("fc", "jsp");

        return page;
    }
}
