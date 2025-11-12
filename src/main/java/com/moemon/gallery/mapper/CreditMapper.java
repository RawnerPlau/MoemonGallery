package com.moemon.gallery.mapper;

import com.moemon.gallery.dto.CreditDTO;
import com.moemon.gallery.model.Credit;
import com.moemon.user.model.User;

import java.util.HashSet;
import java.util.Set;

public class CreditMapper {

    public static CreditDTO toDTO (Credit credit){
        return new CreditDTO(
                credit.getUser().getName(),
                credit.getRole()
        );
    }

    public static Credit toEntity (User user, CreditDTO creditDTO){
        return new Credit(
                user,
                creditDTO.getCreditRole()
        );
    }

    public static Set<CreditDTO> toDTOs (Set<Credit> credits){
        Set<CreditDTO> creditDTOS = new HashSet<>();
        for (Credit credit : credits){
            CreditDTO creditDTO = new CreditDTO(
                    credit.getUser().getName(),
                    credit.getRole()
            );
            creditDTOS.add(creditDTO);
        }
        return creditDTOS;
    }
}
