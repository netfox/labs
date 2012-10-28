package lab.converters;

import lab.dto.DtoPerson;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/23/12
 * Time: 11:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class DTOPersonsToXmlConverter {

    public Source convertToXml(List<DtoPerson> persons) {

        Document doc = null;
        try {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Element personsList = doc.createElement("persons");
            doc.appendChild(personsList);

            for (DtoPerson person : persons) {
                personsList.appendChild(buildContactElement(doc, person));
            }
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }
        return new DOMSource(doc);
    }

    private static Element buildContactElement(Document doc, DtoPerson person){
        Element personElem = doc.createElement("person");
        personElem.setAttribute("firstName", person.getFisrtName());
        personElem.setAttribute("lastName", person.getLastName());
        personElem.setAttribute("middleName",  person.getMiddleName());
        personElem.setAttribute("birthDate", person.getBirthDate());
        return personElem;
    }
}

