/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package eu.jpereira.trainings.designpatterns.creational.factorymethod;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
public class ReportGeneratorTest extends AbstractReportingTest{

	AbstractReport raport = null;
	
	@Test 
	public void testCreateJSONReport() {
		ReportData reportData = createDummyReportData();
		ReportFactory generator = new JSONReportFactory();
		Report generatedReport = generator.generateReport(reportData);
		assertEquals("JSON Report. Name: " + reportData.getName(), generatedReport.getReportContent());
	}
	
	
	@Test 
	public void testCreateXMLReport() {
		ReportData reportData = createDummyReportData();
		ReportFactory generator = new XMLReportFactory();
		Report generatedReport = generator.generateReport(reportData);
		assertEquals("XML Report. Name: "+reportData.getName(), generatedReport.getReportContent());
	}
	
	@Test
	public void testCreateHTMLReport() {
		ReportData reportData = createDummyReportData();
		ReportFactory generator = new HTMLReportFactory();
		Report generatedReport = generator.generateReport(reportData);
		assertEquals("HTML Report. Name: "+reportData.getName(), generatedReport.getReportContent());
	}
	
	@Test
	public void testCreatePDFReport() {
		ReportData reportData = createDummyReportData();
		ReportFactory generator = new PDFReportFactory();
		Report generatedReport = generator.generateReport(reportData);
		assertEquals("PDF Report. Name: "+reportData.getName(), generatedReport.getReportContent());
	}
	

	
	
}