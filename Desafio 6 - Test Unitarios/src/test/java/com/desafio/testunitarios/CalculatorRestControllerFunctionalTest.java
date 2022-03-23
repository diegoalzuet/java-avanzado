package com.desafio.testunitarios;


import com.desafio.testunitarios.domain.Operation;
import com.desafio.testunitarios.domain.Operator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorRestControllerFunctionalTest {

    @Autowired
    protected MockMvc mockMvc;

    @Test
    void testCalculationFunctionality_ReturnValidResultForDifferenceOperator() throws Exception {

        Operation operation = new Operation(40.0, Operator.DIFFERENCE, 30.0);

        String json = new ObjectMapper().writeValueAsString(operation);

        this.mockMvc.perform(post("/calculator/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(10.0));
    }
}