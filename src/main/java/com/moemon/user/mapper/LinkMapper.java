package com.moemon.user.mapper;

import com.moemon.user.dto.LinkDTO;
import com.moemon.user.model.SocialLink;

import java.util.HashSet;
import java.util.Set;

public class LinkMapper {
    public static LinkDTO toDTO (SocialLink link){
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setLink(link.getUrl());
        linkDTO.setPlatform(link.getSocialPlatform());
        return  linkDTO;
    }

    public static Set<LinkDTO> toDTOs (Set<SocialLink> links){
        Set<LinkDTO> linkDTOs = new HashSet<>();
        for(SocialLink link : links){
            LinkDTO linkDTO = toDTO(link);
            linkDTOs.add(linkDTO);
        }
        return linkDTOs;
    }
}
