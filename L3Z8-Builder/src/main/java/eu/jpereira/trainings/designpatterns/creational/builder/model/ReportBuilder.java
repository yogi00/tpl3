package eu.jpereira.trainings.designpatterns.creational.builder.model;

import java.util.Iterator;

public abstract class ReportBuilder {
	public abstract void buildReport();
	public abstract void buildCustomerInfo(Customer customer);
	public abstract void buildArrayOfItems(Iterator<SoldItem> it);
	public abstract Report getReport();
}
