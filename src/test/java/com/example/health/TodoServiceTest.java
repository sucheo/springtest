package com.example.health;

import com.example.health.model.InshealthDto;
import com.example.health.model.UphealthDto;
import com.example.health.model.healthEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(HealthService.class)
public class TodoServiceTest {
    @Autowired
    private HealthService service;

    @MockBean
    private HealthMapper mapper;
    @Test
    @DisplayName("TodoService - 등록(post)")
    void inshealth() throws Exception{
        when(mapper.inshealth(any())).thenReturn(1);

        InshealthDto dto = new InshealthDto();
        dto.setCtnt("ㅎㅇ");
        int result = service.inshealth(dto);

        assertEquals(1,result);
        verify(mapper).inshealth(any(InshealthDto.class));
    }
    @Test
    @DisplayName("TodoService - 수정(patch)")
    void  uphealth() throws Exception{
        when(mapper.uphealth(any())).thenReturn(1);

        UphealthDto dto = new UphealthDto();
        dto.setItodo(1);
        int result =service.uphealth(dto);

        assertEquals(1,result);
        verify(mapper).uphealth(any(UphealthDto.class));
    }
}
