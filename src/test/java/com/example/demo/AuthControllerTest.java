package com.example.demo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.AuthController;
import com.example.demo.service.AuthService;

@SpringBootTest
public class AuthControllerTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	 @Mock
	    private AuthService authService;

	    @InjectMocks
	    private AuthController authController;

	    private MockMvc mockMvc;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
	    }

	    @Test
	    void testSignUp_Success() throws Exception {
	        String requestBody = "{\"username\":\"testUser\",\"password\":\"testPassword\"}";
	        when(authService.signUp("testUser", "testPassword")).thenReturn(true);

	        mockMvc.perform(post("/signup")
	                .content(requestBody)
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());

	        verify(authService, times(1)).signUp("testUser", "testPassword");
	    }

	    @Test
	    void testSignUp_Failure() throws Exception {
	        String requestBody = "{\"username\":\"existingUser\",\"password\":\"testPassword\"}";
	        when(authService.signUp("existingUser", "testPassword")).thenReturn(false);

	        mockMvc.perform(post("/signup")
	                .content(requestBody)
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());

	        verify(authService, times(1)).signUp("existingUser", "testPassword");
	    }

	    @Test
	    void testSignIn_Success() throws Exception {
	        String requestBody = "{\"username\":\"testUser\",\"password\":\"testPassword\"}";
	        when(authService.signIn("testUser", "testPassword")).thenReturn(true);

	        mockMvc.perform(post("/signin")
	                .content(requestBody)
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());

	        verify(authService, times(1)).signIn("testUser", "testPassword");
	    }

	    @Test
	    void testSignIn_Failure() throws Exception {
	        String requestBody = "{\"username\":\"testUser\",\"password\":\"wrongPassword\"}";
	        when(authService.signIn("testUser", "wrongPassword")).thenReturn(false);

	        mockMvc.perform(post("/signin")
	                .content(requestBody)
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());

	        verify(authService, times(1)).signIn("testUser", "wrongPassword");
	    }	

}
