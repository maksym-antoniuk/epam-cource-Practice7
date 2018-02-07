package ua.nure.antoniuk.Practice7.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import ua.nure.antoniuk.Practice7.constants.Constants;
import ua.nure.antoniuk.Practice7.constants.XML;
import ua.nure.antoniuk.Practice7.entity.*;


public class DOMController {

	private String xmlFileName;

	public Fond getFond() {
		return fond;
	}

	private Fond fond;

	public DOMController(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	

	/**
	 * Parses XML document.
	 * 
	 * @param validate
	 *            If true validate XML document against its XML schema.
	 */
	public void parse(boolean validate) 
			throws ParserConfigurationException, SAXException, IOException {

		// obtain DOM parser 
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// set properties for Factory
		
		// XML document contains namespaces
		dbf.setNamespaceAware(true);
		
		// make parser validating
		if (validate) {
			// turn validation on
			dbf.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);
			
			// turn on xsd validation 
			dbf.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
		}

		DocumentBuilder db = dbf.newDocumentBuilder();

		// set error handler
		db.setErrorHandler(new DefaultHandler() {
			@Override
			public void error(SAXParseException e) throws SAXException {
				// throw exception if XML document is NOT valid
				throw e;
			}
		});

		// parse XML document
		Document document = db.parse(xmlFileName);
		
		// get root element
		Element root = document.getDocumentElement();

		// create container
		fond = new Fond();

		// obtain questions nodes
		NodeList questionNodes = root
				.getElementsByTagName(XML.GEM.value());

		// process questions nodes
		for (int j = 0; j < questionNodes.getLength(); j++) {
			Gem gem = getGem(questionNodes.item(j));
			fond.getGems().add(gem);
		}
	}


	private Gem getGem(Node qNode) {
		Gem gem = new Gem();
		Element qElement = (Element) qNode;

		// process question text
		Node qtNode = qElement.getElementsByTagName(XML.NAME.value())
				.item(0);
		// set question text
		gem.setName(getName(qtNode));
		qtNode = qElement.getElementsByTagName(XML.PRECIOUSNESS.value())
				.item(0);
		gem.setPreciousness(getPreciousness(qtNode));

		qtNode = qElement.getElementsByTagName(XML.PARAMETERS.value())
				.item(0);
		gem.setVisualParam(getVisualParam(qtNode));

		qtNode = qElement.getElementsByTagName(XML.ORIGIN.value())
				.item(0);
		gem.setOrigin(getOrigin(qtNode));

		qtNode = qElement.getElementsByTagName(XML.VALUE.value())
				.item(0);
		gem.setValue(getValue(qtNode));

		return gem;
	}

	private VisualParam getVisualParam(Node aNode) {
		VisualParam vp = new VisualParam();
		Element qElement = (Element) aNode;
		Node qtNode = qElement.getElementsByTagName(XML.COLOR.value())
				.item(0);
		vp.setColor(getColor(qtNode));
		qtNode = qElement.getElementsByTagName(XML.CUT.value())
				.item(0);
		vp.setCut(getCut(qtNode));
		qtNode = qElement.getElementsByTagName(XML.TRANSPARENCY.value())
				.item(0);
		vp.setTransparency(getPercent(qtNode));
		return vp;
	}

	private Value getValue(Node aNode) {
		Value value = new Value();
		Element aElement = (Element) aNode;
		value.setValue(Double.parseDouble(aElement.getNodeValue()));
		return value;
	}

	private Transparency getPercent(Node aNode) {
		Transparency value = new Transparency();
		Element aElement = (Element) aNode;
		value.setValue(Double.parseDouble(aElement.getNodeValue()));
		return value;
	}

	private Name getName(Node aNode) {
		Name value = new Name();
		Element aElement = (Element) aNode;
		value.setContent(aElement.getNodeValue());
		return value;
	}

	private Origin getOrigin(Node aNode) {
		Origin value = new Origin();
		Element aElement = (Element) aNode;
		value.setContent(aElement.getNodeValue());
		return value;
	}

	private Cut getCut(Node aNode) {
		Cut value = new Cut();
		Element aElement = (Element) aNode;
		value.setCut(Integer.parseInt(aElement.getNodeValue()));
		return value;
	}

	private Preciousness getPreciousness(Node aNode) {
		Element aElement = (Element) aNode;
		switch (aElement.getNodeValue()) {
			case "драгоценный":
				return Preciousness.PRECIOUS;
			default: return Preciousness.SEMIPRECIOUS;
		}
	}

	private Color getColor(Node aNode) {
		Element aElement = (Element) aNode;
		switch (aElement.getNodeValue()) {
			case "green":
				return Color.GREEN;
			case "red":
				return Color.RED;
			case "blue":
				return Color.BLUE;
			case "violet":
				return Color.VIOLET;
			default: return Color.WHITE;
		}
	}

	private VisualParam getVisualParams(Node node) {
	    VisualParam visualParam = new VisualParam();
		Element parameters = (Element) node;
        NodeList nodes = parameters.getChildNodes();
        Element tempElement;
        for(int i = 0; i < nodes.getLength(); i++) {
            tempElement = (Element) nodes.item(i);
            switch (tempElement.getTagName()) {
                case "color":
                    visualParam.setColor(Color.valueOf(tempElement.getNodeValue().toUpperCase()));
                    break;
                case "cut":
                    visualParam.setCut(new Cut(Integer.parseInt(tempElement.getNodeValue())));
                    break;
                case "transparency":
                    visualParam.setTransparency(new Transparency(Double.parseDouble(tempElement.getNodeValue())));
                    break;
            }
        }
        return visualParam;
	}
	
	// //////////////////////////////////////////////////////
	// Static util methods
	// //////////////////////////////////////////////////////

	/**
	 * Creates and returns DOM of the Test container.
	 * 
	 * @param fond
	 *            Test object.
	 * @throws ParserConfigurationException 
	 */
	public static Document getDocument(Fond fond) throws ParserConfigurationException {
	
		// obtain DOM parser
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// set properties for Factory

		// XML document contains namespaces
		dbf.setNamespaceAware(true);

		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument();

		// create root element
		Element fElement = document.createElement(XML.FOND.value());

		// add root element
		document.appendChild(fElement);

		// add questions elements
		for (Gem gem : fond.getGems()) {

			// add gem
			Element gElement = document.createElement(XML.GEM.value());
			fElement.appendChild(gElement);

			// add gem name
			Element nElement =
					document.createElement(XML.NAME.value());
			nElement.setTextContent(gem.getName().getContent());
			gElement.appendChild(nElement);

			//add gem preciousness
			Element pElement = document.createElement(XML.PRECIOUSNESS.value());
			pElement.setTextContent(gem.getPreciousness().getClaim());
			gElement.appendChild(pElement);

			//add gem origin
			Element oElement = document.createElement(XML.ORIGIN.value());
			oElement.setTextContent(gem.getOrigin().getContent());
			gElement.appendChild(oElement);

			//add gem parameters
			//for(VisualParam )


		}

		return document;		
	}
	
	/**
	 * Saves Test object to XML file.
	 * 
	 * @param test
	 *            Test object to be saved.
	 * @param xmlFileName
	 *            Output XML file name.
	 */
	public static void saveToXML(Fond test, String xmlFileName)
			throws ParserConfigurationException, TransformerException {		
		// Test -> DOM -> XML
		saveToXML(getDocument(test), xmlFileName);		
	}
	
	/**
	 * Save DOM to XML.
	 * 
	 * @param document
	 *            DOM to be saved.
	 * @param xmlFileName
	 *            Output XML file name.
	 */
	public static void saveToXML(Document document, String xmlFileName) 
			throws TransformerException {
		
		StreamResult result = new StreamResult(new File(xmlFileName));
		
		// set up transformation
		TransformerFactory tf = TransformerFactory.newInstance();
		javax.xml.transform.Transformer t = tf.newTransformer();
		t.setOutputProperty(OutputKeys.INDENT, "yes");			
		
		// run transformation
		t.transform(new DOMSource(document), result);
	}

	public static void main(String[] args) throws Exception {

		// try to parse NOT valid XML document with validation on (failed)
		DOMController domContr = new DOMController(Constants.INVALID_XML_FILE);
		try {
			// parse with validation (failed)
			domContr.parse(true);
		} catch (SAXException ex) {
			System.err.println("====================================");
			System.err.println("XML not valid");
			System.err.println("Test object --> " + domContr.getFond());
			System.err.println("====================================");
		}

		// try to parse NOT valid XML document with validation off (success)
		domContr.parse(false);

		// we have Test object at this point:
		System.out.println("====================================");
		System.out.print("Here is the test: \n" + domContr.getFond());
		System.out.println("====================================");

		// save test in XML file
		Fond test = domContr.getFond();
		DOMController.saveToXML(test, Constants.INVALID_XML_FILE + ".dom-result.xml");
	}
}
