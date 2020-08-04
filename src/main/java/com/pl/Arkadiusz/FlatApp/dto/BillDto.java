package com.pl.Arkadiusz.FlatApp.dto;

import com.pl.Arkadiusz.FlatApp.model.entities.Bill;
import lombok.Data;

import java.util.Date;

@Data
public class BillDto {
    private Bill.Category category;
    private String invoiceNumber;
    private Date invoiceDate;
    private Double grossAmount;
    private Boolean active = true;
}
