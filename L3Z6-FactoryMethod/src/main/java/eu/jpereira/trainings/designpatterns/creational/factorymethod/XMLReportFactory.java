package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class XMLReportFactory implements ReportFactory {
	public Report generateReport(ReportData data) {
		XMLReport xmlraport = new XMLReport();
		xmlraport.generateReport(data);
		return xmlraport;
	}
}