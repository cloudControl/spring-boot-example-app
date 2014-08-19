/*
 * Copyright 2012-2013 the original author or authors.
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

package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import sample.data.jpa.service.CityService;

import java.util.Map;

@Controller
public class SampleController {


    @Value("#{systemEnvironment['DOMAIN']?:'cloudcontrolled.com'}")
    private String domain = "Hello World";

    @Autowired
    private CityService cityService;

    @RequestMapping("/")
    @Transactional(readOnly = true)
    public String helloWorld(Map<String, Object> model) {
        String cityName = this.cityService.getCity("Bath", "UK").getName();
        model.put("city", cityName);
        model.put("domain", domain);
        return "welcome";
    }
}
