package com.ds.springbootswagger.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Details about contact")
public class ContactBean {
     @ApiModelProperty(notes = "The unique id  of the contact")
     private int id;
     @ApiModelProperty(notes = "The person's name")
     private String name;
     @ApiModelProperty(notes = "The person's telephone number")
     private String tpNumber;
}
