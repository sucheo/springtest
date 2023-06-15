package com.example.health;

import com.example.health.model.InshealthDto;
import com.example.health.model.UphealthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Health")
public class HealthController {
private final HealthService service;
@Autowired
    public HealthController(HealthService service) {
        this.service = service;
    }
    @PostMapping
    public int inshealth(InshealthDto dto){
        return service.inshealth(dto);
    }
    @PatchMapping
    public int uphealth(@RequestBody UphealthDto dto){
    return service.uphealth(dto);
    }
}
