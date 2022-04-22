package com.baton.Calculator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@WebAppConfiguration
public class CalculatorApplicationTests {
	@Autowired
	public WebApplicationContext webApplicationContext;
	Integer Num1=5;
	Integer Num2=5;
	@Test
	public void add() throws Exception {
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String uri = "/add/";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).param("Num1", String.valueOf(Num1)).param("Num2", String.valueOf(Num2)).
				accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(Integer.parseInt(mvcResult.getResponse().getContentAsString()),10);

	}
	@Test
	public void subract() throws Exception {
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String uri = "/sub/";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).param("Num1", String.valueOf(Num1)).param("Num2", String.valueOf(Num2)).
				accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(Integer.parseInt(mvcResult.getResponse().getContentAsString()),0);

	}
	@Test
	public void multiply() throws Exception {
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String uri = "/mul/";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).param("Num1", String.valueOf(Num1)).param("Num2", String.valueOf(Num2)).
				accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(Integer.parseInt(mvcResult.getResponse().getContentAsString()),25);

	}
	@Test
	public void divide() throws Exception {
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String uri = "/div/";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).param("Num1", String.valueOf(Num1)).param("Num2", String.valueOf(Num2)).
				accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		MvcResult mvcResult_zero_error = mvc.perform(MockMvcRequestBuilders.get(uri).param("Num1", String.valueOf(Num1)).param("Num2", String.valueOf(0)).
				accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		assertEquals(400, mvcResult_zero_error.getResponse().getStatus()); //  check for Divide By Zero error
		assertEquals(Integer.parseInt(mvcResult.getResponse().getContentAsString()),1);

	}


	}

