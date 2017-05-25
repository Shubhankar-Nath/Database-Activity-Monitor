

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class SAXParserAuditor extends DefaultHandler{

	List myEmpls;
	
	private String tempVal;
	
	//to maintain context
	private Auditor tempEmp;
	
	
	public SAXParserAuditor(){
		myEmpls = new ArrayList();
	}
	
	public void runExample() {
		parseDocument();
		printData();
	}

	private void parseDocument() {
		
		//get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
		
			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();
			
			//parse the file and also register this class for call backs
			sp.parse("Audit.xml", this);
			
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * Iterate through the list and print
	 * the contents
	 */
	private void printData(){
		
		System.out.println("No of Entries '" + myEmpls.size() + "'.");
		
		Iterator it = myEmpls.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	

	//Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//reset
		tempVal = "";
		if(qName.equalsIgnoreCase("AUDIT_RECORD")) {
			//create a new instance of Auditor
			tempEmp = new Auditor();
		}
	}
	

	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(qName.equalsIgnoreCase("AUDIT_RECORD")) {
			//add it to the list
			myEmpls.add(tempEmp);
			
		}else if (qName.equalsIgnoreCase("TIMESTAMPA")) {
			tempEmp.setTIMESTAMPA(tempVal);
		}else if (qName.equalsIgnoreCase("NAME")) {
			tempEmp.setNAME(tempVal);
		}else if (qName.equalsIgnoreCase("CONNECTION_ID")) {
			tempEmp.setCONNECTION_ID(Integer.parseInt(tempVal));
		}else if (qName.equalsIgnoreCase("USER")) {
			tempEmp.setUSER(tempVal);
		}else if (qName.equalsIgnoreCase("HOST")) {
			tempEmp.setHOST(tempVal);
		}else if (qName.equalsIgnoreCase("IP")) {
			tempEmp.setIP(tempVal);
		}else if (qName.equalsIgnoreCase("COMMAND_CLASS")) {
			tempEmp.setCOMMAND_CLASS(tempVal);
		}
		
	}
	
	public static void main(String[] args){
		SAXParserAuditor spe = new SAXParserAuditor();
		spe.runExample();
	}
	
}




