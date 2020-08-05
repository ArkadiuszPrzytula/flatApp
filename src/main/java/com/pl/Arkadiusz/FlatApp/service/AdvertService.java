package com.pl.Arkadiusz.FlatApp.service;

import com.pl.Arkadiusz.FlatApp.dto.AdvertDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdvertService {
    List<AdvertDto> getAllAdvert();

    void save(AdvertDto advertDto) throws Exception;

    AdvertDto getAdvert(Long id);
}
