package com.restExample.dao;

import com.restExample.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CustomerDao {
    private static List<Customer> customers;
    {
        customers = new ArrayList();
        customers.add(new Customer(12L,"Raju","Raju@gmail.com"));
        customers.add(new Customer(102L,"Sanju","Sanju@gmail.com"));
        customers.add(new Customer(103L,"Anju","Aju@gmail.com"));
    }

    public List list(){
        return customers;
    }

    public Customer get(Long id){
        for(Customer cust : customers){
                if(cust.getCustId().equals(id)){
                    return cust;
                }
        }
        return null;
    }

    public boolean checkName(String UserName){
        for (Customer customer : customers){
            if (customer.getName().equalsIgnoreCase(UserName)){
                return true;
            }
        }
        return false;
    }


    public Customer create(Customer customer){
        customers.add(customer);
        return customer;
    }

    public Long delete(Long id){
        for(Customer customer : customers){
            if(customer.getCustId().equals(id)){
                customers.remove(customer);
                return id;
            }
        }
        return null;
    }
    public Customer update(Long id,Customer customer){
        for (Customer customer1 : customers){
            if(customer1.getCustId().equals(id)){
                customer1 = customer;
                return customer;
            }
        }
        return null;
    }
}
