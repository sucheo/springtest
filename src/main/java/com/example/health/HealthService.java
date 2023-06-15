package com.example.health;

import com.example.health.model.InshealthDto;
import com.example.health.model.UphealthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthService {
    private final HealthMapper mapper;

    @Autowired
    public HealthService(HealthMapper mapper) {
        this.mapper = mapper;
    }
    public int inshealth(InshealthDto dto){
        return mapper.inshealth(dto);
    }
    public int uphealth(UphealthDto dto){
        dto.setItodo(dto.getItodo());
        return mapper.uphealth(dto);
    }

}
