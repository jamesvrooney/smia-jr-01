package com.jamesvrooney.licensing.controller;

import com.jamesvrooney.licensing.model.License;
import com.jamesvrooney.licensing.service.LicenseService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value="v1/organization/{organizationId}/license")
public class LicenseController {

//    @Value("${example.property}")
//    private String exampleProperty;
    private final LicenseService licenseService;

    @RequestMapping(value="{licenseId}",method = RequestMethod.GET)
    public ResponseEntity<License> getLicense( @PathVariable("organizationId") String organizationId,
                                               @PathVariable("licenseId") String licenseId) {

//        log.info("Example property: {}", exampleProperty);

        License license = licenseService.getLicense(licenseId, organizationId);

        license.add(
                linkTo(methodOn(LicenseController.class).getLicense(organizationId, license.getLicenseId())).withSelfRel(),
                linkTo(methodOn(LicenseController.class).createLicense(organizationId, license, null)).withRel("createLicense"),
                linkTo(methodOn(LicenseController.class).updateLicense(organizationId, license)).withRel("updateLicense"),
                linkTo(methodOn(LicenseController.class).deleteLicense(organizationId, license.getLicenseId())).withRel("deleteLicense")
        );

        return ResponseEntity.ok(license);
    }

    @PutMapping
    public ResponseEntity<String> updateLicense(@PathVariable String organizationId, @RequestBody License request) {
        return ResponseEntity.ok(licenseService.updateLicense(request, organizationId));
    }

    @PostMapping
    public ResponseEntity<Long> createLicense(@PathVariable String organizationId, @RequestBody License request,
                                                @RequestHeader(value = "Accept-Language",required = false) Locale locale) {
//        return ResponseEntity.ok(licenseService.createLicense(request, organizationId, locale));
        Long licenseId = licenseService.createLicense(request, organizationId, locale);

        return ResponseEntity.ok(licenseId);
    }

    @DeleteMapping(value="{licenseId}")
    public ResponseEntity<String> deleteLicense(@PathVariable String organizationId, @PathVariable("licenseId") String licenseId) {
        return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId));
    }
}
