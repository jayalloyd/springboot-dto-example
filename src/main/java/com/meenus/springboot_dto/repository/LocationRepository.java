package com.meenus.springboot_dto.repository;

import com.meenus.springboot_dto.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
