package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String street;
private String city;
}
