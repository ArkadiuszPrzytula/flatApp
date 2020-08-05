package com.pl.Arkadiusz.FlatApp.controllers;

import com.pl.Arkadiusz.FlatApp.dto.LoggedUserDto;
import com.pl.Arkadiusz.FlatApp.model.entities.Bill;
import com.pl.Arkadiusz.FlatApp.service.BillService;
import com.pl.Arkadiusz.FlatApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.pl.Arkadiusz.FlatApp.utilis.SecurityUtils.getUsername;

@Controller
@RequestMapping("/bills")
public class BillSectionController {

    private final BillService billService;
    private final UserService userService;

    @Autowired
    public BillSectionController(BillService billService, UserService userService) {
        this.billService = billService;
        this.userService = userService;
    }

    @GetMapping
    public String getBillSectionPage(Model model) {
        basicBillsData(model, userService.getUser(getUsername()));
        return  "bill-page";
    }

    @GetMapping("/{media}")
    public String getEnergyBills(Model model, @PathVariable String media){
        LoggedUserDto user = userService.getUser(getUsername());
        basicBillsData(model, user);
        addBillsByCategory(model, user, media);
        return  "bill-page";
    }

    private void addBillsByCategory(Model model, LoggedUserDto user, String media) {
        switch (media){
            case "energy":
                addEnergyBill(model, user);
                break;
            case "water":
                addWaterBill(model, user);
                break;
            case "heat":
                addHeatBill(model, user);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + media);
        }
    }

    private void addHeatBill(Model model, LoggedUserDto user) {
        model.addAttribute("statistics",billService.getInvoicesByCategory(user.getId(), Bill.Category.CENTRAL_HEATING));
    }

    private void addWaterBill(Model model, LoggedUserDto user) {
        model.addAttribute("statistics",billService.getInvoicesByCategory(user.getId(), Bill.Category.WATER_HEATING));
        model.addAttribute("coldWater",billService.getInvoicesByCategory(user.getId(), Bill.Category.COLD_WATER_AND_SEWAGE));

    }

    private void addEnergyBill(Model model, LoggedUserDto user) {
        model.addAttribute("statistics",billService.getInvoicesByCategory(user.getId(), Bill.Category.ENERGY));
    }


    private void basicBillsData(Model model, LoggedUserDto user) {
        model.addAttribute("billsToPay", billService.showAllBillsToPay(user.getId()));
        model.addAttribute("bills", billService.allUnpaidBillsByCategory(user.getId()));
        model.addAttribute("percentage", billService.percentageOfGeneratedCosts(user.getId()));
    }
}
