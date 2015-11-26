package eu.jpereira.trainings.designpatterns.creational.abstractfactory.json;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.Report;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportFactory;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportHeader;

public class JSONReportFactory extends ReportFactory{
	protected static JSONReportFactory instance;
	public static synchronized ReportFactory getInstance(){
		if(instance == null){
			instance = new JSONReportFactory();
		}		
		return instance;
	}
	@Override
	public ReportBody createBody() {
		
		return new JSONReportBody();
	}

	@Override
	public ReportHeader createHeader() {
		return new JSONReportHeader();
	}

	@Override
	public ReportFooter createFooter() {

		return new JSONReportFooter();
	}
}


