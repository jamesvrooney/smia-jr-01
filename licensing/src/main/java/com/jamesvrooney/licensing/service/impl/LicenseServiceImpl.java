package com.jamesvrooney.licensing.service.impl;

import com.jamesvrooney.licensing.model.License;
import com.jamesvrooney.licensing.repository.LicenseRepository;
import com.jamesvrooney.licensing.service.LicenseService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LicenseServiceImpl implements LicenseService {

    private final MessageSource messages;
    private final LicenseRepository licenseRepository;

    @Override
    public License getLicense(String licenseId, String organizationId) {
//        License license = new License();
//
//        license.setId(new Random().nextInt(1000));
//        license.setLicenseId(licenseId);
//        license.setOrganizationId(organizationId);
//        license.setDescription("Software product");
//        license.setProductName("Ostock");
//        license.setLicenseType("full");

//        return license;
        return null;
    }

    @Override
    public Long createLicense(License license, String organizationId, Locale locale){
        license.setLicenseId(UUID.randomUUID().toString());
        License savedLicense = licenseRepository.save(license);

        return savedLicense.getId();
    }

    @Override
    public String updateLicense(License license, String organizationId) {
        String responseMessage = null;

        if (license != null) {
            license.setOrganizationId(organizationId);

            responseMessage = String.format(messages.getMessage("license.update.message", null, null), license);
        }

        return responseMessage;
    }

    @Override
    public String deleteLicense(String licenseId, String organizationId) {
        String responseMessage;

        responseMessage = String.format("Deleting license with id %s for the organization %s",licenseId, organizationId);

        return responseMessage;
    }
}
