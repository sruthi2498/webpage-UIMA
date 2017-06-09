package com.prescienced.uima;

import java.util.*;
import java.io.*;
import java.io.FileWriter;  
import java.io.File;
import java.io.BufferedWriter;
import java.util.Arrays;

import  org.apache.uima.*;
import  org.apache.uima.util.*;
import  org.apache.uima.resource.*;
import  org.apache.uima.analysis_component.*;
import  org.apache.uima.analysis_engine.*;
import  org.apache.uima.cas.*;
import  org.apache.uima.cas.TypeSystem;
import  org.apache.uima.cas.impl.*;
import  org.apache.uima.jcas.*;
import  org.apache.uima.jcas.tcas.*;
import  org.apache.uima.cas.text.AnnotationFS;
import  org.apache.uima.impl.*;
import  org.apache.uima.collection.*;
import  org.apache.uima.examples.*;
import  org.apache.uima.flow.*;
import  org.apache.uima.cas_data.*;
import  org.apache.uima.resource.*;
import  org.apache.uima.search.*;





class Test {
	

public static void DisplayList(String[] array) {

   for (String a  : array) {
         System.out.print(a+ "\n");
      }
}
public static int Find(String[] array, String e) {

   for (String a  : array) {
         if(a==e)return 1;
      }
      return 0;
}
	static String[] addElement(String[] a, String e) {
		    a  = Arrays.copyOf(a, a.length + 1);
		    a[a.length - 1] = e;
		    return a;
	}
	static String AnnotatorName(String searchval){

		//System.out.println("searchVal= "+searchval);
		//if(searchval=="org.apache.uima.examples.tokenizer.Sentence") return "Sentence";
		if(searchval.equals("org.apache.uima.examples.tokenizer.Sentence"))return "Sentence";
		if(searchval.equals("org.apache.uima.examples.tokenizer.Token")) return "Token";
		if(searchval.equals("example.Name")) return "Name";
		if(searchval.equals("example.EmailAddress")) return "EmailAddress";
		if(searchval.equals("example.PersonTitle")) return "PersonTitle";
		if(searchval.equals("uima.tcas.DocumentAnnotation"))return "DocumentAnnotation";

		//return "";
		return "what";
	}
   public static void main(String[] args) {


		try{ 
			XMLInputSource in = new XMLInputSource("data/descriptors/analysis_engine/UIMA_Analysis_Example.xml");
			ResourceSpecifier specifier = UIMAFramework.getXMLParser().parseResourceSpecifier(in);
			 //create AE here
			AnalysisEngine ae = UIMAFramework.produceAnalysisEngine(specifier);
            
			  //create a JCas, given an Analysis Engine (ae)
			JCas jcas = ae.newJCas();
			  
			BufferedReader br = new BufferedReader(new FileReader("data/text_files/Apache_UIMA.txt"));
			String everything;
			try {
			    StringBuilder sb = new StringBuilder();
			    String line = br.readLine();
				while (line != null) {
			        sb.append(line);
			        sb.append(System.lineSeparator());
			        line = br.readLine();
			    }
			    everything = sb.toString();
			} finally {
			    br.close();
			}
			//System.out.println(everything);
            

			jcas.setDocumentText(everything);
			jcas.setDocumentLanguage("en");
			ae.process(jcas);
			FSIterator it = jcas.getAnnotationIndex().iterator();
			Annotation a = null;

			String filename="data/text_files/op/op.txt";

			PrintWriter pw = new PrintWriter(filename);
			pw.close();
			File file = new File(filename);
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter output = null;
			FileWriter fw = null;
			fw = new FileWriter(file.getAbsoluteFile(), true);
			output = new BufferedWriter(fw);

			String filelist="data/text_files/op/list.txt";
			PrintWriter pw2 = new PrintWriter(filelist);
			pw2.close();
			File f2 = new File(filelist);
			if (!f2.exists()) {
				f2.createNewFile();
			}
			BufferedWriter output2 = null;
			FileWriter fw2 = null;
			fw2 = new FileWriter(f2.getAbsoluteFile(), true);
			output2 = new BufferedWriter(fw2);

			String[] arr=new String[6];


			while (it.isValid()){
				a = (Annotation) it.get();
				int s=a.getBegin();
				int e=a.getEnd();
				Type mytype=a.getType();
				// initializing unsorted array
				
				// sorting array
				String searchVal=mytype.toString();
				String actualAn=AnnotatorName(searchVal);
				if(searchVal!=null && actualAn!="what"){
					int retVal = Find(arr,actualAn);
					if(retVal==0){
						
						//System.out.println("new name + "+actualAn);
						arr=addElement(arr,actualAn);
						output2.write(actualAn);
						output2.write("\n");

					}
				}

				it.moveToNext();
			}
			output2.close();
			fw2.close();

			filelist="data/text_files/op/list.txt";
			f2 = new File(filelist);
			if (!f2.exists()) {
				f2.createNewFile();
			}
			 FileReader fileReader = new FileReader(new File(filelist));

 			BufferedReader br2 = new BufferedReader(fileReader);

			 String line = null;
			 while ((line = br2.readLine()) != null){                       
			   // System.out.println(cells.length);
			    System.out.println(line);
			   // System.out.println("k\n");
			    String actualAn=line;
			    filename="data/text_files/op/"+actualAn+".csv";
				file = new File(filename);
				//if(file.exists())System.out.println("file present");
				if (!file.exists()) {
							file.createNewFile();
				}
				pw2 = new PrintWriter(filename);
				pw2.close();
				fw = new FileWriter(file.getAbsoluteFile(), true);
				output = new BufferedWriter(fw);
				output.write("");
				//output.write("\n");
				output.close();
				fw.close();
			}
			output2.close();
			fw2.close();
			it = jcas.getAnnotationIndex().iterator();
			a = null;
		

			while (it.isValid()){
				a = (Annotation) it.get();
				int s=a.getBegin();
				int e=a.getEnd();
				Type mytype=a.getType();
				String searchVal=mytype.toString();

				String actualAn=AnnotatorName(searchVal);
				//System.out.println("new name + "+actualAn);
				//System.out.println(searchVal+" "+actualAn);
				filename="data/text_files/op/"+actualAn+".csv";
				file = new File(filename);
				//if(file.exists())System.out.println("file present");
				if (!file.exists()) {
							file.createNewFile();
				}
				fw = new FileWriter(file.getAbsoluteFile(), true);
				output = new BufferedWriter(fw);
				if(s && e && a.getCoveredText()){
					 String text=s+","+e+"," + a.getCoveredText();
					output.write(text);
					output.write("\n");
				}
				output.close();
				fw.close();
				it.moveToNext();
			}


			
			 //System.out.println("Done");
		}
		catch(IOException e){ System.out.println("IOException" + e.getMessage());}
		catch(InvalidXMLException e2){ System.out.println("InvalidXMLException" + e2.getMessage());}
		catch(ResourceInitializationException e3){ System.out.println("InvalidXMLException" + e3.getMessage());}
		catch(AnalysisEngineProcessException e4){ System.out.println("InvalidXMLException" + e4.getMessage());}
		//catch(AnalysisEngineProcessException e4){ System.out.println("InvalidXMLException" + e4.getMessage());}
   }
}
