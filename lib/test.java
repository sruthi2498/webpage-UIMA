

import java.util.*;
import java.io.*;
import  org.apache.uima.*;
import  org.apache.uima.util.*;
import  org.apache.uima.resource.*;
import  org.apache.uima.analysis_component.*;
import  org.apache.uima.analysis_engine.*;
import  org.apache.uima.cas.*;
import  org.apache.uima.impl.*;
import  org.apache.uima.collection.*;
import  org.apache.uima.examples.*;
import  org.apache.uima.flow.*;
class test {
   public static void main(String[] args) {


		try{ 
			XMLInputSource in = new XMLInputSource("data/MyDescriptor.xml");
			ResourceSpecifier specifier = UIMAFramework.getXMLParser().parseResourceSpecifier(in);
			 //create AE here
			AnalysisEngine ae = UIMAFramework.produceAnalysisEngine(specifier);

			//create a CAS
			CAS aCasView = ae.newCAS();
			//analyze a document\
			String doc1txt="abcdef";
			aCasView.setDocumentText(doc1txt);
			ae.process(aCasView);
			String ret=aCasView.getDocumentText();
			System.out.println(ret);
			//doSomethingWithResults(aCasView);
			aCasView.reset();
  
		}
		catch(IOException e){ System.out.println("IOException" + e.getMessage());}
		catch(InvalidXMLException e2){ System.out.println("InvalidXMLException" + e2.getMessage());}
		catch(ResourceInitializationException e3){ System.out.println("InvalidXMLException" + e3.getMessage());}
		catch(AnalysisEngineProcessException e4){ System.out.println("InvalidXMLException" + e4.getMessage());}
		
   }
}