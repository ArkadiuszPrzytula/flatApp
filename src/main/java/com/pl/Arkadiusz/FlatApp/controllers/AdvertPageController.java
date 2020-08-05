package com.pl.Arkadiusz.FlatApp.controllers;

import com.pl.Arkadiusz.FlatApp.dto.AdvertDto;

import com.pl.Arkadiusz.FlatApp.model.repositories.UserRepository;
import com.pl.Arkadiusz.FlatApp.service.AdvertService;
import com.pl.Arkadiusz.FlatApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;


@Controller
@RequestMapping("/advert")
public class AdvertPageController {
    private final AdvertService advertService;
    private final UserService userService;

    @Autowired
    public AdvertPageController(UserRepository userRepository, AdvertService advertService, UserService userService) {
        this.advertService = advertService;

        this.userService = userService;
    }


    @GetMapping()
    public String showAdverts(Model model) {
        model.addAttribute("adverts", advertService.getAllAdvert());
        return "advert-page";
    }

    @PostMapping("/add-advert")
    public String addAdvert(AdvertDto advertDto) {

        try {
            advertService.save(advertDto);
        } catch (Exception d){
            d.printStackTrace();
            return "redirect:/advert/add-advert";
        }

        return "redirect:/advert";
    }

    @GetMapping("/{id}")
    public String prepareEditAdvert(@PathVariable Long id, Model model) {

            model.addAttribute("advert", advertService.getAdvert(id));
            return "edit-advert";

    }

    @PostMapping("/edit-advert")
    public String processEditAdvert(AdvertDto advertDto) {

        try {
            advertService.save(advertDto);
        } catch (Exception d){
            d.printStackTrace();
            return "redirect:/advert/add-advert";
        }


        return "redirect:/advert";



    }
    @PostMapping("/delete-advert")
    public String processDeleteAdvert(Long advertId, Principal principal) {
        String username = principal.getName();
        log.debug("Usuwanie ogłoszenia o id {} dla użytkownika {}", advertId, username);

        Optional<Advert> optionalAdvert = advertRepository.findByIdAndUserUsername(advertId, username);
        optionalAdvert.ifPresent(advertRepository::delete);

        return "redirect:/adverts";
    }




}
