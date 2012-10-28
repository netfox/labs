package lab.converters;

import lab.dto.DtoPerson;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/21/12
 * Time: 11:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class DTOPersonToXmlConverter {

    public Source convertToXml(DtoPerson person) {
        Document doc = null;
        try {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Element persons = doc.createElement("person");
            doc.appendChild(buildContactElement(doc, person));

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }
        return new DOMSource(doc);
    }

    private static Element buildContactElement(Document doc, DtoPerson person){
        Element personElem = doc.createElement("person");
        Element childElement = doc.createElement("firstName");
        childElement.setTextContent(person.getLastName());
        personElem.appendChild(childElement);
        childElement = doc.createElement("lastName");
        childElement.setTextContent(person.getLastName());
        personElem.appendChild(childElement);
        childElement = doc.createElement("middleName");
        childElement.setTextContent(person.getMiddleName());
        personElem.appendChild(childElement);
        childElement = doc.createElement("birthDate");
        childElement.setTextContent(person.getBirthDate());
        personElem.appendChild(childElement);
        return personElem;
    }
}
