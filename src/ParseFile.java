

import java.io.File;

import java.io.IOException;

import java.util.ArrayList;

import javax.xml.parsers.*;

import javax.xml.xpath.XPathExpressionException;
;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class ParseFile extends DefaultHandler {
    private String fileName,tempValue;


    public HashMap<String, XMLDRUG> getDrugDictionary() {
        return drugDictionary;
    }

    private HashMap<String, XMLDRUG> drugDictionary; //map drug name to drug object


    private boolean count = false;


    private ArrayList<XMLDRUG.DrugInt> drugList;


    public void setDrugId(boolean drugId) {
        this.drugId = drugId;
    }

    private boolean drugId;
    private boolean drugName;
    private boolean drugDescription;
    private boolean drugIndication;
    private boolean drugCount = true;
    private XMLDRUG.DrugInt intTemp = new XMLDRUG.DrugInt();
    private XMLDRUG drug = new XMLDRUG();

    public void setDrugName(boolean drugName) {
        this.drugName = drugName;
    }



    public void setDrugDescription(boolean drugDescription) {
        this.drugDescription = drugDescription;
    }



    public void setDrugIndication(boolean drugIndication) {
        this.drugIndication = drugIndication;
    }



    public void setDrugInteractions(boolean drugInteractions) {
        this.drugInteractions = drugInteractions;
    }

    private boolean drugInteractions;
    private boolean flag, intFlag;
    private boolean keep = false;





    private boolean packagers = true;
    ParseFile(String fileName) throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {
        this.fileName = fileName;
        drugDictionary = new HashMap<String, XMLDRUG>();
        drugList = new ArrayList<>();
        parseXML();


    }

    void parseXML() throws IOException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newDefaultInstance();

        try {
            File file = new File("/Users/oliviafeldman/Desktop/xmlFileReader/src/SampleDrugDatabase.xml");

            SAXParser parser = factory.newSAXParser();
            parser.parse(file, this);





        } catch(SAXException |ParserConfigurationException |
                IOException e)

        {
            e.printStackTrace();
        }

    }


    @Override
    public void startElement(String st, String st3, String elementName, Attributes attributes) throws SAXException {


        if(elementName.equalsIgnoreCase("drug")){
            XMLDRUG drug = new XMLDRUG();
            flag = true;

        }
        else if (elementName.equalsIgnoreCase("drugbank-id")) {


            setDrugId(true);


        } else if (elementName.equalsIgnoreCase("name")) {


            setDrugName(true);}

        else if (elementName.equalsIgnoreCase("description")) {


            setDrugDescription(true);


        } else if (elementName.equalsIgnoreCase("indication")) {

            setDrugIndication(true);

        } else if (elementName.equalsIgnoreCase("drug-interactions")) {

            intFlag = true;
        }else if (elementName.equalsIgnoreCase("drug-interaction")) {
            intTemp = new XMLDRUG.DrugInt();

            setDrugInteractions(true);
        }


    }
    @Override
    public void endElement(String uri, String name, String element) throws SAXException {
        //  System.out.println(element);


//
//            if(element.equalsIgnoreCase("drugbank-id")){
//
//
//            }
//            else if(element.equalsIgnoreCase("name")){
//
//            }
//            else if(element.equalsIgnoreCase("description")){
//
//            }
//            else if(element.equalsIgnoreCase("indication")){
//
//            } else if(element.equalsIgnoreCase("drug-interactions")){
//
//
//             if(element.equalsIgnoreCase("drug")){
//                    flag = false;
//           }










    }
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if ( flag && !intFlag) {
                drug = new XMLDRUG();
            if (drugId) {

                String temp = new String(ch, start, length);
                drug.setId(temp);
                System.out.println( "Drug ID:"+ drug.getId());
                drugId = false;

            }  else if (drugName) {
                String temp = new String(ch, start, length);
                drug.setName(temp);
                System.out.println("Drug Name"+ drug.getName());
                drugName = false;
            } else if (drugDescription) {
                String temp = new String(ch, start, length);
                drug.setDescription(temp);
                System.out.println(" Drug Description:"+drug.getDescription());
                drugDescription = false;

            }  else if (drugIndication) {
                String temp = new String(ch, start, length);
                drug.setIndication(temp);
                System.out.println( "Drug Indication:" + drug.getIndication());
                drugIndication = false;
               flag=false;

            }



        }

        else if (intFlag) {

            if (drugId) {
                String temp = new String(ch, start, length);
                intTemp.setID(temp);
                System.out.println("Drug ID:" + intTemp.getID());
                drugId = false;
            }  else if (drugName) {
                String temp = new String(ch, start, length);
                intTemp.setName(temp);
                System.out.println("DrugName:"+ intTemp.getName());
                drugName = false;
            } else if (drugDescription) {
                String temp = new String(ch, start, length);
                intTemp.setInteraction(temp);
                System.out.println("Interaction:" + intTemp.getInteraction());
                drugDescription = false;
            }

            else {
                drugList.add(intTemp);
                intFlag = false;



            }

        }

        if( !flag && !intFlag){
            System.out.println("new drug");
            drug.setDrugInteractionList(drugList);
            drugDictionary.put(drug.getId(), drug);
            flag = true;

        }



    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();

    }


}
