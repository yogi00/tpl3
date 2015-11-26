package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class HTMLReportFactory implements ReportFactory {
	public Report generateReport(ReportData data) {
		HTMLReport htmlreport = new HTMLReport();
		htmlreport.generateReport(data);
		return htmlreport;
	}
}