package com.ea.origin.store.common;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.ea.origin.store.exception.ExceptionCode;
import com.ea.origin.store.exception.ExceptionMessage;
import com.ea.origin.store.exception.ExecuteRuntimeException;
import com.ea.origin.store.exception.FileNotFoundException;
import com.ea.origin.store.exception.InvalidParameterException;

public class Utils {

    private static Logger logger = LogManager.getLogger(Utils.class);

    public static String classifyString(String value) {
        StringBuilder result = new StringBuilder();
        String array[] = value.trim().split("\\s+");
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i != array.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static String getElement(String path, String id) throws FileNotFoundException, ExecuteRuntimeException, XPathExpressionException, InvalidParameterException {
        try {
            File file = new File(path);
            if(file == null) {
                throw new FileNotFoundException(ExceptionCode.IO_EXCEPTION, ExceptionMessage.FILE_NOT_FOUND);
            }
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            Element element = (Element) xPath.evaluate(id, document, XPathConstants.NODE);
            if(element.equals(null)) {
                throw new InvalidParameterException(ExceptionCode.INVALID_SYSTEM_PARAM, ExceptionMessage.XML_ELEMENT_NOT_FOUND);
            }

            if(element.getTextContent().equals(null) || element.getTextContent().isEmpty()) {
                throw new InvalidParameterException(ExceptionCode.INVALID_SYSTEM_PARAM, ExceptionMessage.SQL_STATEMENT_INVALID_MESSAGE);
            }

            return classifyString(element.getTextContent());
        } catch(IOException e) {
            throw new FileNotFoundException(ExceptionCode.IO_EXCEPTION, "message", e);
        } catch(ParserConfigurationException e) {
            throw new ExecuteRuntimeException(ExceptionCode.PARSER_CONFIGURATION_EXCEPTION, "message", e);
        } catch(SAXException e) {
            throw new ExecuteRuntimeException(ExceptionCode.SAX_EXCEPTION, "message", e);
        }
    }
}