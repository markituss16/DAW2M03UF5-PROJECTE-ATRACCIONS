package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Controller implements Initializable {

    @FXML
    private TableView<Entrada> taula;

    @FXML
    private Button boto;

    @FXML
    protected void carregar(ActionEvent event) {
        ObservableList<Entrada> dades = taula.getItems();
        carregarXML(dades);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void carregarXML(ObservableList<Entrada> dades) {
        try {
            File entrades = new File(Controller.class.getResource("infoEntrades.xml").toURI());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(entrades);
            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("entrada");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    dades.add(new Entrada(Integer.parseInt(obtenirContingut("idEntrada", element)),
                            obtenirContingut("categoria", element),
                            Double.parseDouble(obtenirContingut("preu", element)),
                            Boolean.parseBoolean(obtenirContingut("estat",
                                    element))));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String obtenirContingut(String etiqueta, Element element) {
        NodeList nodes = element.getElementsByTagName(etiqueta).item(0)
                .getChildNodes();
        Node node = (Node) nodes.item(0);
        return node.getNodeValue();
    }
}

