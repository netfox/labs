package lab.transformers;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/21/12
 * Time: 11:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class XSLTTransformer {
    public void transform(Source xmlSource, InputStream xslSourseStream, OutputStream resultStream) {
        try {
            TransformerFactory transFact = TransformerFactory.newInstance();
            Source xsltSource = new StreamSource(xslSourseStream);
            Transformer trans = transFact.newTransformer(xsltSource);
            trans.transform(xmlSource, new StreamResult(resultStream));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
