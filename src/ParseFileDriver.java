import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class ParseFileDriver {

    public static void main(String[] args) throws IOException, XMLStreamException, ParserConfigurationException, SAXException, XPathExpressionException {
        ParseFile p = new ParseFile("/Users/oliviafeldman/Desktop/xmlFileReader/src/SampleDrugDatabase.xml");
//            HashMap map = p.getDrugDictionary();
//
//            Iterator hmIterator = map.entrySet().iterator();
//        while (hmIterator.hasNext()) {
//            Map.Entry mapElement = (Map.Entry)hmIterator.next();
//            System.out.println(mapElement.getKey());
//        }


    }
}
