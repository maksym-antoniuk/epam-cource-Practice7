package ua.nure.antoniuk.Practice7;

import ua.nure.antoniuk.Practice7.controller.DOMController;
import ua.nure.antoniuk.Practice7.controller.SAXController;
import ua.nure.antoniuk.Practice7.controller.STAXController;
import ua.nure.antoniuk.Practice7.util.Sorter;


public class Main {
	public static void usage() {
		System.out.println("Usage:\njava -jar ST3ExampleSimple.jar xmlFileName");
		System.out.println("java ua.antoniuk.Practice7.Main xmlFileName");
	}
	
	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			usage();
			//return;
		}
		
		String xmlFileName = "input.xml";
		System.out.println("Input ==> " + xmlFileName);
		
		////////////////////////////////////////////////////////
		// DOM
		////////////////////////////////////////////////////////
		
		// get
		DOMController domController = new DOMController(xmlFileName);
		domController.parse(true);
		//Test test = domController.getTest();

		// sort (case 1)
		//Sorter.sortQuestionsByQuestionText(test);
		
		// save
		String outputXmlFile = "output.dom.xml";
		//DOMController.saveToXML(test, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);

		////////////////////////////////////////////////////////
		// SAX
		////////////////////////////////////////////////////////
		
		// get
		SAXController saxController = new SAXController(xmlFileName);
		saxController.parse(true);
		//test = saxController.getTest();
		
		// sort  (case 2)
		//Sorter.sortQuestionsByAnswersNumber(test);
		
		// save
		outputXmlFile = "output.Practice7.xml";
		
		// other way: 
		//DOMController.saveToXML(test, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);
		
		////////////////////////////////////////////////////////
		// StAX
		////////////////////////////////////////////////////////
		
		// get
		STAXController staxController = new STAXController(xmlFileName);
		staxController.parse();
		//test = staxController.getTest();
		
		// sort  (case 3)
		//Sorter.sortAnswersByContent(test);
		
		// save
		outputXmlFile = "output.stax.xml";
		//DOMController.saveToXML(test, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);
	}

}