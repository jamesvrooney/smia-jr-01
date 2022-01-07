package com.jamesvrooney.licensing.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Data
@Getter
@Setter
@ToString
@Entity
public class License extends RepresentationModel<License> {

    @Id
    @GeneratedValue
    private Long id;

    private String licenseId;
    private String description;
    private String organizationId;
    private String productName;
    private String licenseType;
}