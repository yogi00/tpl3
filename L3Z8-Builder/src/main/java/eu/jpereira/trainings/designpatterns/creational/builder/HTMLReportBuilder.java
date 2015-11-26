package eu.jpereira.trainings.designpatterns.creational.builder;

import java.util.Iterator;

import eu.jpereira.trainings.designpatterns.creational.builder.model.Customer;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;

public class HTMLReportBuilder extends ReportBuilder{

	private HTMLReportBody reportBody;
	
	public void buildReport() {
		reportBody = new HTMLReportBody();
	}

	@Override
	public void buildCustomerInfo(Customer customer) {
		reportBody.putContent("<span class=\"customerName\">");
		reportBody.putContent(customer.getName());
		reportBody.putContent("</span><span class=\"customerPhone\">");
		reportBody.putContent(customer.getPhone());
		reportBody.putContent("</span>");
	}

	@Override
	public void buildArrayOfItems(Iterator<SoldItem> it) {
		reportBody.putContent("<items>");
		while ( it.hasNext() ) {
			SoldItem soldEntry= it.next();
			reportBody.putContent("<item><name>");
			reportBody.putContent(soldEntry.getName());
			reportBody.putContent("</name><quantity>");
			reportBody.putContent(soldEntry.getQuantity());
			reportBody.putContent("</quantity><price>");
			reportBody.putContent(soldEntry.getUnitPrice());
			reportBody.putContent("</price></item>");
		}
		reportBody.putContent("</items>");
	}
	
	@Override
	public Report getReport() {
		Report report = new Report();
		report.setReportBody(reportBody);
		return report;
	}

}
