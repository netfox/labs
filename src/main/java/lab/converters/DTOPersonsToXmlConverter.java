package lab.converters;

import lab.dto.DtoPerson;
import lab.dto.DtoPersons;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/23/12
 * Time: 11:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class DTOPersonsToXmlConverter {

    public Source convertToXml(DtoPersons persons) {

        Document doc = null;
        try {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Element rootElement = doc.createElement("root");
            doc.appendChild(rootElement);

            Element personsList = doc.createElement("persons");
            rootElement.appendChild(personsList);

            for (DtoPerson person : persons.getDtoPersons()) {
                personsList.appendChild(buildContactElement(doc, person));
            }
            rootElement.appendChild(buildSimpleElement(doc, "path", persons.getPath()));
            rootElement.appendChild(buildSimpleElement(doc, "currentPage", String.valueOf(persons.getCurrentPage())));
            rootElement.appendChild(buildSimpleElement(doc, "numOfPages", String.valueOf(persons.getNumOfPages())));
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }
        return new DOMSource(doc);
    }

    private static Element buildContactElement(Document doc, DtoPerson person){
        Element personElem = doc.createElement("person");
        personElem.appendChild(buildSimpleElement(doc, "firstName", person.getFirstName()));
        personElem.appendChild(buildSimpleElement(doc, "lastName", person.getLastName()));
        personElem.appendChild(buildSimpleElement(doc, "middleName", person.getMiddleName()));
        personElem.appendChild(buildSimpleElement(doc, "birthDate", person.getBirthDate()));
        return personElem;
    }

    private static Element buildSimpleElement(Document doc, String node, String value) {
        Element childElement = doc.createElement(node);
        childElement.setTextContent(value);
        return childElement;
    }
}

