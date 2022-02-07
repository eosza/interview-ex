package oracle.interview.implementation;

import oracle.interview.metrics.MetricReader;
import oracle.interview.metrics.TargetMetricsContainer;

import java.io.InputStream;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        List<TargetMetricsContainer> listMerticsContainer = new ArrayList<TargetMetricsContainer>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(false);
            Document doc = dbf.newDocumentBuilder().parse(metricInputStream);
            doc.getDocumentElement().normalize();

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
                    // add container to collection
                    listMerticsContainer.add(container);

                    // get metrics
                    NodeList metricList = target.getElementsByTagName("metric");
                    for (int x = 0; x < metricList.getLength(); x++) {
                        String type = target.getElementsByTagName("metric").item(x).getAttributes().getNamedItem("type")
                                .getTextContent();
                        String timestamp = target.getElementsByTagName("metric").item(x).getAttributes()
                                .getNamedItem("timestamp").getTextContent();
                        try {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                            Date parsedDate = dateFormat.parse(timestamp);

                            Instant timeInstant = parsedDate.toInstant();

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

        return listMerticsContainer;
    }

}
