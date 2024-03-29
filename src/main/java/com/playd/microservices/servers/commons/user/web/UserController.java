package com.playd.microservices.servers.commons.user.web;

import com.playd.microservices.servers.commons.user.model.User;
import com.playd.microservices.servers.commons.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/common/user")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/insertUser", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<Map<String, Object>> insertUser(@RequestParam User user, HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", userService.insertUser(user));

		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}