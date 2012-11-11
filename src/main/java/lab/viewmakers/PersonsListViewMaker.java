package lab.viewmakers;

import lab.converters.DTOBetweenPersonsConverter;
import lab.converters.DTOPersonsToXmlConverter;
import lab.dao.PersonDao;
import lab.domain.Person;
import lab.dto.DtoPersons;
import lab.exceptions.IteratorException;
import lab.transformers.XSLTTransformer;
import lab.util.ApplicationResources;
import lab.util.UrlUtil;
import lab.valuelisthandler.PersonsListHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/29/12
 * Time: 12:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class PersonsListViewMaker implements IViewMaker {

    private static final int RECORDS_PER_PAGE = 2;
    private static final String CURRENT_PAGE_PARAM = "current_page";
    private static final String COMMAND_PARAM = "command";
    private static final String COMMAND_NEXT = "nextPage";
    private static final String COMMAND_PREVIOUS = "previousPage";
    private static final String COMMAND_HOME = "home";

    @Override
    public String makeView(HttpServletRequest request, HttpServletResponse response) {
        if (COMMAND_HOME.equals(request.getParameter(COMMAND_PARAM))) {
            return "index.jsp";
        }

        String flScript = "/transformfiles/persons.xsl";

        PersonsListHandler personsListHandler = new PersonsListHandler();
        personsListHandler.setPersonDao(new PersonDao());

        ApplicationResources applicationResources = ApplicationResources.getInstance();
        InputStream xsltInputStream = applicationResources.getResourceAsStream(flScript);

        try {
            personsListHandler.executeSearch();
            int currentPage = getCurrentPage(request.getParameter(COMMAND_PARAM), request.getParameter(CURRENT_PAGE_PARAM));
            List<Person> persons = null;
            for (int i = 0; i < currentPage; i++) {
                persons = personsListHandler.getNextElements(RECORDS_PER_PAGE);
            }
            DtoPersons personsDto = new DtoPersons();
            personsDto.setPersons(new DTOBetweenPersonsConverter().convert(persons));
            personsDto.setPath(request.getRequestURI());
            int numOfPages = getNumberOfPages(personsListHandler.getSize());
            personsDto.setNumOfPages(numOfPages);
            personsDto.setCurrentPage(currentPage);
            Source xmlSource = new DTOPersonsToXmlConverter().convertToXml(personsDto);
            XSLTTransformer transformer = new XSLTTransformer();
            transformer.transform(xmlSource, xsltInputStream, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IteratorException e) {
            e.printStackTrace();
        }
        return UrlUtil.getPage(request);
    }

    private int getCurrentPage(String command, String pageParam) {
        int currentPage;
        int page = 0;
        if (pageParam != null) {
            page = Integer.valueOf(pageParam).intValue();
        }
        if (command == null) {
            currentPage = 1;
        } else {
            currentPage = page;
            if (COMMAND_NEXT.equals(command)) {
                currentPage++;
            } else if (COMMAND_PREVIOUS.equals(command)) {
                currentPage--;
            }
        }
        return currentPage;
    }

    private int getNumberOfPages(int listSize) {
        int numOfPages = listSize / RECORDS_PER_PAGE;
        if (listSize % RECORDS_PER_PAGE > 0) {
            numOfPages++;
        }
        return numOfPages;
    }
}
