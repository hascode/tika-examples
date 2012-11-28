package com.hascode.tutorial;

import java.io.IOException;

import org.apache.tika.detect.DefaultDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;

public class ContentDetectionExample {
	public static void main(final String[] args) throws IOException {
		detectContentFromFile("/demo.pdf");
		detectContentFromFile("/demo.docx");
		detectContentFromFile("/demo.xlsx");
		detectContentFromFile("/demo.odp");
		detectContentFromFile("/demo.png");
		detectContentFromFile("/demo.avi");
		detectContentFromFile("/demo.mp3");
		detectContentFromFile("/com/hascode/tutorial/ConcretePDFExtractor.class");
		detectContentFromFile("/demo.html");
	}

	private static void detectContentFromFile(final String fileName)
			throws IOException {
		Detector detector = new DefaultDetector();
		MediaType type = detector.detect(
				ContentDetectionExample.class.getResourceAsStream(fileName),
				new Metadata());
		System.out.println(String.format(
				"detected media type for given file %s: %s", fileName,
				type.toString()));
	}

}
