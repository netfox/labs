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

             doc.appendChild(buildContactElement(doc, person));

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
