package com.restExample.controller;

import com.restExample.dao.CustomerDao;
import com.restExample.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CustomerController {
    private CustomerDao customerDao = new CustomerDao();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView Hello(){
        System.out.println("In hello");
        ModelAndView model = new ModelAndView("hello");
        model.addObject("message","Welcome");
        return model;
    }

    @PostMapping("/checkName")
    public boolean checkName(@RequestBody String userName){
        boolean result = customerDao.checkName(userName);
        return result;
    }

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getCustomers(){
        System.out.println("Checked");
        List<Customer> customers =  customerDao.list();
        return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
       //return customerDao.list();
    }

    @GetMapping("customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id){
        System.out.println("Checked");
        Customer customer = customerDao.get(id);
        if (customer == null){
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id,@RequestBody Customer customer){
        customer = customerDao.update(id,customer);
        if(customer == null){
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }

    @PostMapping(name = "/customer" , headers= "Accept=application/json")
    public ResponseEntity<Void> create(@RequestBody Customer customer){
        String name = customer.getName();
        if (customerDao.checkName(name)){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        customerDao.create(customer);
        return new ResponseEntity(customer,HttpStatus.CREATED);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") Long id){

        if(customerDao.delete(id) == null){
            return new ResponseEntity("No customer with this id",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(id,HttpStatus.OK);
    }
    @GetMapping("/addCustomer")
    public ModelAndView getAddForm(){
        ModelAndView mv = new ModelAndView("addCustomer");
        return mv;
    }

}
