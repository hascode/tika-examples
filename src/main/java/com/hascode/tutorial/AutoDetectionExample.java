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

public class AutoDetectionExample {
	public static void main(final String[] args) throws IOException,
			SAXException, TikaException {
		Parser parser = new AutoDetectParser();

		System.out.println("------------ Parsing a PDF:");
		extractFromFile(parser, "/demo.pdf");

		System.out.println("------------ Parsing an Office Document:");
		extractFromFile(parser, "/demo.docx");

		System.out.println("------------ Parsing a Spreadsheet:");
		extractFromFile(parser, "/demo.xlsx");

		System.out.println("------------ Parsing a Presentation:");
		extractFromFile(parser, "/demo.odp");

		System.out.println("------------ Parsing a PNG:");
		extractFromFile(parser, "/demo.png");

		System.out.println("------------ Parsing a Video/AVI:");
		extractFromFile(parser, "/demo.avi");

		System.out.println("------------ Parsing a MP3:");
		extractFromFile(parser, "/demo.mp3");

		System.out.println("------------ Parsing a Java Class:");
		extractFromFile(parser,
				"/com/hascode/tutorial/ConcretePDFExtractor.class");

		System.out.println("------------ Parsing a HTML File:");
		extractFromFile(parser, "/demo.html");
	}

	private static void extractFromFile(final Parser parser,
			final String fileName) throws IOException, SAXException,
			TikaException {
		long start = System.currentTimeMillis();
		BodyContentHandler handler = new BodyContentHandler(10000000);
		Metadata metadata = new Metadata();
		InputStream content = AutoDetectionExample.class
				.getResourceAsStream(fileName);
		parser.parse(content, handler, metadata, new ParseContext());
		for (String name : metadata.names()) {
			System.out.println(name + ":\t" + metadata.get(name));
		}
		System.out.println(String.format(
				"------------ Processing took %s millis\n\n",
				System.currentTimeMillis() - start));
	}
}
