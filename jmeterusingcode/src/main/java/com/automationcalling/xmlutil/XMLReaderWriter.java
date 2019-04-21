package com.automationcalling.xmlutil;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;

import static com.automationcalling.globalconfig.Constant.jmxFILEPath;

public class XMLReaderWriter {
    private static Document doc;
    private static XPath xPath;
    private static NodeList nodes;
    private static Transformer xformer;

    public static void main(String[] args) {

       updateElementText("//hashTree/ThreadGroup/elementProp/stringProp[@name='LoopController.loops']"
                , jmxFILEPath + "HTTP_Sample.jmx"
                , 0, "2");
        updateElementText("//hashTree/ThreadGroup/stringProp[@name='ThreadGroup.num_threads']"
                , jmxFILEPath + "HTTP_Sample.jmx"
                , 0, "10");
        updateElementText("//hashTree/ThreadGroup/stringProp[@name='ThreadGroup.ramp_time']"
                , jmxFILEPath + "HTTP_Sample.jmx"
                , 0, "5");
    }

    public static void updateElementText(String givenXpath, String filePath, int itemNo, String modifiedContent) {
        try {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(
                    new InputSource(filePath));
            xPath = XPathFactory.newInstance().newXPath();
            nodes = (NodeList) xPath.evaluate(givenXpath, doc,
                    XPathConstants.NODESET);
            nodes.item(itemNo).setTextContent(modifiedContent);
            xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(new DOMSource(doc), new StreamResult(new File(filePath)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

