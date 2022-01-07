package com.jamesvrooney.licensing.repository;

import com.jamesvrooney.licensing.model.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends JpaRepository<License, Long> {
}
