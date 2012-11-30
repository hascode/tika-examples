package com.hascode.tutorial;

import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class ContentExtraction {
	public static void main(final String[] args) throws IOException,
			SAXException, TikaException {
		Parser parser = new AutoDetectParser();

		System.out
				.println("------------ Extracting the content from an Office Document:");
		extractContentFromFile(parser, "/demo.docx");

		System.out
				.println("------------ Extracting the content from a Spreadsheet:");
		extractContentFromFile(parser, "/demo.xlsx");

		System.out
				.println("------------ Extracting the content from a Presentation:");
		extractContentFromFile(parser, "/demo.odp");

		System.out.println("------------ Extracting the content from a MP3:");
		extractContentFromFile(parser, "/demo.mp3");

		System.out
				.println("------------ Extracting the content from a Java Class:");
		extractContentFromFile(parser,
				"/com/hascode/tutorial/ConcretePDFExtractor.class");

		System.out
				.println("------------ Extracting the content from a HTML File:");
		extractContentFromFile(parser, "/demo.html");
	}

	private static void extractContentFromFile(final Parser parser,
			final String fileName) throws IOException, SAXException,
			TikaException {
		BodyContentHandler handler = new BodyContentHandler(10000000);
		Metadata metadata = new Metadata();
		InputStream content = AutoDetectionExample.class
				.getResourceAsStream(fileName);
		parser.parse(content, handler, metadata, new ParseContext());
		System.out.println(handler.toString());
	}
}
