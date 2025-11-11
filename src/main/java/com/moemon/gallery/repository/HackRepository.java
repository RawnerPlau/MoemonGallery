package com.moemon.gallery.repository;

import com.moemon.gallery.model.Hack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HackRepository extends JpaRepository<Hack, Long> {
    public Optional<Hack> findByNameIgnoreCase(String name);
}
