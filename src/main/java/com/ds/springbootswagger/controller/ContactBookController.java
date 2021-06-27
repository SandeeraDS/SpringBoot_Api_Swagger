package com.ds.springbootswagger.controller;


import com.ds.springbootswagger.service.ContactBookService;
import com.ds.springbootswagger.bean.ContactBean;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/1")
public class ContactBookController {

    private final ContactBookService contactBookService;

    @Autowired
    public ContactBookController(ContactBookService contactBookService) {
        this.contactBookService = contactBookService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(
            value = "Find contact for given id",
            notes = "Provide an id to lookup specific contact from contact book",
            response = ContactBean.class
    )
    public ContactBean getContactById(@ApiParam(value = "Id value for the contact you need to retrieve", required = false)
                                          @PathVariable int id){
        return contactBookService.getById(id);
    }

    @GetMapping(value = "")
    @ApiOperation(
            value = "Get All Contacts Details",
            notes = "Provide all the contact details available in the database",
            response = List.class
    )
    public List<ContactBean> getAllContact(){
        return contactBookService.getAllContacts();
    }

    @PostMapping(value = "")
    @ApiOperation(
            value = "Add new Contact",
            notes = "Provide facility to save new contact",
            response = ContactBean.class
    )
    public ContactBean addContact(@ApiParam(value = "contact details", required = true, type = "ContactBean")
                                      @RequestBody ContactBean contact){
        return contactBookService.addContact(contact);
    }
}
