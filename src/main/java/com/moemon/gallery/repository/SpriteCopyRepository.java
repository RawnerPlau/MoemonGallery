package com.moemon.gallery.repository;

import com.moemon.gallery.model.Hack;
import com.moemon.gallery.model.SpriteCopy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpriteCopyRepository extends JpaRepository<SpriteCopy, Long> {

    List<SpriteCopy> findByHack (Hack hack);
}
