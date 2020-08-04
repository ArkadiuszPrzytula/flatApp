package com.pl.Arkadiusz.FlatApp.service;

import com.pl.Arkadiusz.FlatApp.dto.BillDto;
import com.pl.Arkadiusz.FlatApp.model.entities.Bill;
import com.pl.Arkadiusz.FlatApp.model.repositories.BillRepository;
import com.pl.Arkadiusz.FlatApp.model.repositories.UserRepository;

import java.util.List;
import java.util.Map;


public interface BillService {


    public Double showAllBillsToPay(Long id);

    public Map<Bill.Category,Double> allUnpaidBillsByCategory(Long id);

    public Map<Bill.Category,Double> percentageOfGeneratedCosts(Long id);

    public List<BillDto> getInvoicesByCategory(Long id, Bill.Category category);
}
