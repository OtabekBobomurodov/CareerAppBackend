package com.example.careerapp.model;

import com.example.careerapp.entity.enums.Contract;
import com.example.careerapp.entity.enums.Currency;
import com.example.careerapp.entity.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreferencesReq {
    private String industry,position,workMode;
    private Integer salary;
    private Level level;
    private Currency currency;
    private Contract contract;
}
