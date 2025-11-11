package com.moemon.gallery.service;

import com.moemon.gallery.dto.HackCreateDTO;
import com.moemon.gallery.dto.HackDTO;
import com.moemon.gallery.model.Hack;
import com.moemon.gallery.repository.HackRepository;
import com.moemon.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class HackService {

    private final HackRepository hackRepository;

    public HackService(HackRepository hackRepository){
        this.hackRepository = hackRepository;
    }

    public HackDTO getHack(Long id){
        Hack hack = hackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hack is not found."));
        return toHackDTO(hack);
    }

    public HackDTO addHack(HackCreateDTO hackCreateDTO, User developer){
        Hack hack = new Hack(
                hackCreateDTO.getName(),
                developer,
                hackCreateDTO.getDescription(),
                hackCreateDTO.getCanvasSize()
        );
        Hack savedHack = hackRepository.save(hack);
        return toHackDTO(savedHack);
    }

    public HackDTO toHackDTO(Hack hack){
        return new HackDTO(
                hack.getId(),
                hack.getName(),
                hack.getDescription(),
                hack.getDeveloper().getName(),
                hack.getCanvasSize()
        );
    }

    public Hack findHackByName (String name){
        return hackRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Hack unrecognized."));
    }
}
