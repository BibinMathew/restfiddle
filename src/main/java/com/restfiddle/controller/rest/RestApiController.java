/*
 * Copyright 2014 Ranjan Kumar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.restfiddle.controller.rest;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restfiddle.handler.RequestHandler;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class RestApiController {
    Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    RequestHandler requestHandler;

    @RequestMapping("/api/channel")
    String channel() {
	try {
	    requestHandler.handleGet();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return "success!";
    }

    @RequestMapping("/api/ping")
    String ping() {
	return "Server is up and running!";
    }
}