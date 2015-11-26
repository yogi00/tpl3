package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportFactory;


public abstract class ReportFactory {
	public abstract ReportBody createBody();
	public abstract ReportHeader createHeader();
	public abstract ReportFooter createFooter();
}
