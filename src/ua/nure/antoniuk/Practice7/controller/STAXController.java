package ua.nure.antoniuk.Practice7.controller;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ua.nure.antoniuk.Practice7.constants.Constants;
import ua.nure.antoniuk.Practice7.entity.Fond;


public class STAXController extends DefaultHandler {

	private String xmlFileName;

	// main container
	private Fond fond;

	public Fond getFond() {
		return fond;
	}

	public STAXController(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	/**
	 * Parses XML document with StAX (based on event reader). There is no validation during the
	 * parsing.
	 */
	public void parse() throws ParserConfigurationException, SAXException,
			IOException, XMLStreamException {


	}

	public static void main(String[] args) throws Exception {

		// try to parse (valid) XML file (success)
		STAXController staxContr = new STAXController(Constants.VALID_XML_FILE);
		staxContr.parse(); // <-- do parse (success)

		// obtain container

		// we have Test object at this point:
		System.out.println("====================================");
		//System.out.print("Here is the test: \n" + test);
		System.out.println("====================================");
	}
}