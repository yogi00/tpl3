package eu.jpereira.trainings.designpatterns.creational.builder.json;
import java.util.Iterator;
import java.util.List;

import eu.jpereira.trainings.designpatterns.creational.builder.model.Customer;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;


public class JSONReportBuilder extends ReportBuilder{

	private JSONReportBody reportBody;
	
	public void buildReport() {
		reportBody = new JSONReportBody();
	}

	@Override
	public void buildCustomerInfo(Customer customer) {
		reportBody.addContent("sale:{customer:{");
		reportBody.addContent("name:\"");
		reportBody.addContent(customer.getName());
		reportBody.addContent("\",phone:\"");
		reportBody.addContent(customer.getPhone());
		reportBody.addContent("\"}");
	}

	@Override
	public void buildArrayOfItems(Iterator<SoldItem> it) {
		reportBody.addContent(",items:[");
		while ( it.hasNext() ) {
			SoldItem item = it.next();
			reportBody.addContent("{name:\"");
			reportBody.addContent(item.getName());
			reportBody.addContent("\",quantity:");
			reportBody.addContent(String.valueOf(item.getQuantity()));
			reportBody.addContent(",price:");
			reportBody.addContent(String.valueOf(item.getUnitPrice()));
			reportBody.addContent("}");
			if ( it.hasNext() ) {
				reportBody.addContent(",");
			}
		}
		reportBody.addContent("]}");
	}
	
	

	@Override
	public Report getReport() {
		Report report = new Report();
		report.setReportBody(reportBody);
		return report;
	}

}
