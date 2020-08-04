package com.pl.Arkadiusz.FlatApp.service.implementation;

import com.pl.Arkadiusz.FlatApp.dto.BillDto;
import com.pl.Arkadiusz.FlatApp.model.entities.Bill;
import com.pl.Arkadiusz.FlatApp.model.repositories.BillRepository;
import com.pl.Arkadiusz.FlatApp.model.repositories.UserRepository;
import com.pl.Arkadiusz.FlatApp.service.BillService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BillServiceDefault implements BillService {

    private final BillRepository billRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public BillServiceDefault(BillRepository billRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.billRepository = billRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Double showAllBillsToPay(Long id) {
        return billRepository.findAllByActiveAndUser(true, userRepository.findById(id).get())
                .stream()
                .mapToDouble(Bill::getGrossAmount)
                .sum();
    }

    @Override
    public Map<Bill.Category, Double> allUnpaidBillsByCategory(Long id) {
        List<Bill> allByActiveAndUser = billRepository.findAllByActiveAndUser(true, userRepository.findById(id).get());
        Map<Bill.Category, Double> billsByCategory = new HashMap<>();
        for (Bill b : allByActiveAndUser) {
            billsByCategory.put(b.getCategory(), b.getGrossAmount());
        }
        return billsByCategory;
    }

    @Override
    public Map<Bill.Category, Double> percentageOfGeneratedCosts(Long id) {
        double sum = showAllBillsToPay(id);
        Map<Bill.Category, Double> bills = allUnpaidBillsByCategory(id);
        Map<Bill.Category, Double> percentageMap = new HashMap<>();
        for (Map.Entry<Bill.Category, Double> e : bills.entrySet()) {
            percentageMap.put(e.getKey(), (e.getValue() * 100) / sum);
        }
        return percentageMap;
    }

    @Override
    public List<BillDto> getInvoicesByCategory(Long id, Bill.Category category) {
          return billRepository.findAllByActiveAndUser(true, userRepository.findById(id).get())
                .stream().map(this::mapBillOnBillDto).collect(Collectors.toList());
    }

    private BillDto mapBillOnBillDto(Bill bill) {
        return modelMapper.map(bill, BillDto.class);
    }
}
