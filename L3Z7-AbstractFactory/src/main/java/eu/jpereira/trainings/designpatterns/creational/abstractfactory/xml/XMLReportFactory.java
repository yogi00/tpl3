package eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportFactory;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.ReportHeader;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportFactory;

public class XMLReportFactory extends ReportFactory{
	protected static XMLReportFactory instance;
	public static synchronized ReportFactory getInstance(){
		if(instance == null || instance.getClass() != XMLReportFactory.class ){
			instance = new XMLReportFactory();
		}		
		return instance;
	}
	
	@Override
	public ReportBody createBody() {
		// TODO Auto-generated method stub
		return new XMLReportBody();
	}

	@Override
	public ReportHeader createHeader() {
		// TODO Auto-generated method stub
		return new XMLReportHeader();
	}

	@Override
	public ReportFooter createFooter() {
		// TODO Auto-generated method stub
		return new XMLReportFooter();
	}

}
