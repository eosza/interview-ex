package oracle.interview.implementation;

import oracle.interview.metrics.MetricReader;
import oracle.interview.metrics.TargetMetricsContainer;

import java.io.InputStream;
import java.security.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.time.Instant;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MetricReaderImplementation implements MetricReader {
    @Override
    public List<TargetMetricsContainer> readMetrics(InputStream metricInputStream) {
        // TODO: implement this, reading data from the input stream, returning a list of
        // containers read from the stream
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(false);
            Document doc = dbf.newDocumentBuilder().parse(metricInputStream);
            doc.getDocumentElement().normalize();

            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("------");

            // get <targets>
            NodeList listTargets = doc.getElementsByTagName("target");

            for (int iterator = 0; iterator < listTargets.getLength(); iterator++) {

                Node node = listTargets.item(iterator);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element target = (Element) node;
                    // get targets attributes
                    String targetName = target.getAttribute("name");
                    String targetType = target.getAttribute("type");

                    TargetMetricsContainer container = new TargetMetricsContainer(targetName, targetType);

                    // get metrics
                    NodeList metricList = target.getElementsByTagName("metric");
                    for (int x = 0; x < metricList.getLength(); x++) {
                        String type = target.getElementsByTagName("metric").item(x).getAttributes().getNamedItem("type")
                                .getTextContent();
                        String timestamp = target.getElementsByTagName("metric").item(x).getAttributes()
                                .getNamedItem("timestamp").getTextContent();
                        try {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                            Date parsedDate = (Date) dateFormat.parse(timestamp);

                            Instant timeInstant = parsedDate.toInstant();
                            System.out.println(timeInstant.toString());
                            String value = target.getElementsByTagName("metric").item(x).getAttributes()
                                    .getNamedItem("value").getTextContent();

                            int valueInt = Integer.parseInt(value);

                            container.addMetric(type, timeInstant, valueInt);

                        } catch (Exception e) {
                            System.out.println(e.toString());
                        }

                    }

                }
            }
        } catch (ParserConfigurationException | IOException | SAXException exp) {
            // exp.printStackTrace();
            System.out.println(exp);
        }
        // Read data from an XML file
        // parse XML
        // List<TargetMetricsContainer>
        return Collections.emptyList();
    }

}
