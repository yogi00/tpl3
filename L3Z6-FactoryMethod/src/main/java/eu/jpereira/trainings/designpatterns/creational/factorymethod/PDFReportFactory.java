package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class PDFReportFactory implements ReportFactory {
	public Report generateReport(ReportData data) {
		PDFReport pdfraport = new PDFReport();
		pdfraport.generateReport(data);
		return pdfraport;
	}
}