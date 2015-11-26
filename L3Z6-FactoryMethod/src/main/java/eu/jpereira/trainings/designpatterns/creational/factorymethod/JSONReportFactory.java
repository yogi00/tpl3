package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class JSONReportFactory implements ReportFactory {
	@Override
	public Report generateReport(ReportData data) {
		JSONReport jsonraport = new JSONReport();
		jsonraport.generateReport(data);
		return jsonraport;
	}
}