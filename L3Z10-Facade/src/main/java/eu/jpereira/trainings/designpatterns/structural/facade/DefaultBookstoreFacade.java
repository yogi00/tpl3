package eu.jpereira.trainings.designpatterns.structural.facade;

import eu.jpereira.trainings.designpatterns.structural.facade.model.Book;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Customer;
import eu.jpereira.trainings.designpatterns.structural.facade.model.DispatchReceipt;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Order;
import eu.jpereira.trainings.designpatterns.structural.facade.service.BookDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerDBService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.CustomerNotificationService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.OrderingService;
import eu.jpereira.trainings.designpatterns.structural.facade.service.WharehouseService;

public class DefaultBookstoreFacade implements BookstoreFacade {
	CustomerDBService customerService;
	BookDBService bookService;
	OrderingService orderingService;
	WharehouseService warehouseService;
	CustomerNotificationService customerNotificationService;
	
	public void setCustomerService(CustomerDBService x){
		customerService = x;
	}
	public void setBookDBService(BookDBService x){
		bookService = x;
	}
	public void setOrderingService(OrderingService x){
		orderingService = x;
	}
	public void setWharehouseService(WharehouseService x){
		warehouseService = x;
	}
	public void setCustomerNotificationService(CustomerNotificationService x){
		customerNotificationService = x;
	}
	
	
	
	
	@Override
	public void placeOrder(String customerId, String isbn) {
		
		Book book = bookService.findBookByISBN(isbn);
		Customer customer = customerService.findCustomerById(customerId);
		Order order = orderingService.createOrder(customer, book);
		DispatchReceipt dummyDispatchReceipt = warehouseService.dispatch(order);
		customerNotificationService.notifyClient(dummyDispatchReceipt);
		
		
	}

}
