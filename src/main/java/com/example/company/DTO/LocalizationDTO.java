package com.example.company.DTO;

import com.example.company.entity.Localization;
import com.example.company.entity.Project;
import lombok.*;

/**
 * Created by Magda on 06.06.2018.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocalizationDTO {

    private Long id;
    private String name;
    private String address;


    public static LocalizationDTO ofLocalization(Localization localization) {


        return LocalizationDTO.builder()

                .id(localization.getId())
                .name(localization.getName())
                .address(localization.getAddress())
                .build();
    }



}
