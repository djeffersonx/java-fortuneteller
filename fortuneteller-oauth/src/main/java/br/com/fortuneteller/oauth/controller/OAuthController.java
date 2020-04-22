package br.com.fortuneteller.oauth.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {

	@ResponseBody
	@GetMapping("/oauth/user")
	public Principal user(Principal user) {
		return user;
	}

}