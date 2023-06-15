package com.example.health;

import com.example.health.model.InshealthDto;
import com.example.health.model.UphealthDto;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HealthController.class)
public class TodoContorllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private HealthService service;

    @Test
    @DisplayName("TODO - 등록(post)")
    void inshealth() throws Exception{
       given(service.inshealth(any(InshealthDto.class))).willReturn(1);

       InshealthDto dto = new InshealthDto();
       dto.setCtnt("안녕?");
       Gson gson = new Gson();
       String josn = gson.toJson(dto);

        ResultActions ra = mvc.perform(post("/Health")
                .content(josn).contentType(MediaType.APPLICATION_JSON));

        ra.andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());

        verify(service).inshealth(any());
    }
    @Test
    @DisplayName("TODO - finish수정")
    void uphealth() throws Exception{
        given(service.uphealth(any(UphealthDto.class))).willReturn(1);

        UphealthDto dto = new UphealthDto();
        dto.setItodo(1);
        Gson gson = new Gson();
        String json = gson.toJson(dto);

        ResultActions ra = mvc.perform(patch("/Health")
                .content(json).contentType(MediaType.APPLICATION_JSON));

        ra.andExpect(status().isOk())
        .andExpect(content().string("1"))
        .andDo(print());

        verify(service).uphealth(dto);
    }
}
