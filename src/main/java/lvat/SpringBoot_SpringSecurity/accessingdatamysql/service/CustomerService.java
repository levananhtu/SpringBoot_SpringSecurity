package lvat.SpringBoot_SpringSecurity.accessingdatamysql.service;

import lvat.SpringBoot_SpringSecurity.accessingdatamysql.entity.Customer;
import lvat.SpringBoot_SpringSecurity.accessingdatamysql.entity.Order;
import lvat.SpringBoot_SpringSecurity.accessingdatamysql.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final static int SIZE = 20;
    private final CustomersRepository customersRepository;

    @Autowired
    public CustomerService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public <T> T getCustomersByCustomerNumber(Long customerNumber, Class<T> type) {
        return customersRepository.findByCustomerNumber(customerNumber, type);
    }

    public <T> List<T> getAllCustomers(Integer page, Class<T> type) {
        return customersRepository.findAllCustomersBy(type, PageRequest.of(page, 20)).get().collect(Collectors.toList());
    }

    public <T> List<T> getCustomersByCustomerName(String customerName, Class<T> type, Integer page) {
        return customersRepository.findByCustomerNameContaining(customerName, type, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }

    public <T> List<T> getCustomersByCountryAndState(String country, String state, Class<T> type, Integer page) {
        return customersRepository.findByCountryAndState(country, state, type, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }

    public List<List<Order>> getOrdersByCustomerNumber(Long customerNumber) {
        List<List<Order>> ordersList = new LinkedList<>();
        Customer customer = customersRepository.findByCustomerNumber(customerNumber, Customer.class);
        ordersList.add(customer.getOrderList());
        return ordersList;
    }

    public <T> List<T> getByCustomerNameAndCreditLimit(String customerName, Double creditLimit, Class<T> type, Integer page) {
        return customersRepository.findByCustomerNameContainingAndCreditLimitLessThanEqual(customerName, creditLimit, type, PageRequest.of(page, SIZE)).get().collect(Collectors.toList());
    }
}
