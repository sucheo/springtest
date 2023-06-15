package com.example.health;

import com.example.health.model.InshealthDto;
import com.example.health.model.UphealthDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HealthMapper {
    int inshealth(InshealthDto dto);
    int uphealth(UphealthDto dto);
}
