package th.ac.kmitl.origibakery.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import th.ac.kmitl.origibakery.model.Customer;
import th.ac.kmitl.origibakery.model.CustomerRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void createCustomer(Customer customer) {
        String hashPin = hash(customer.getPin());
        customer.setPin(hashPin);
        repository.save(customer);
    }

    public Customer findCustomer(int id) {
        try {
            return repository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    public Customer checkPin(Customer inputCustomer) {
        Customer storedCustomer = findCustomer(inputCustomer.getId());

        if (storedCustomer != null) {
            String storedPin = storedCustomer.getPin();
            if (BCrypt.checkpw(inputCustomer.getPin(), storedPin))
                return storedCustomer;
        }
        return null;
    }

    private String hash(String pin) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(pin, salt);
    }
}


