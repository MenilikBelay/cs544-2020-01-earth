package com.cs544.controller;

import com.cs544.domain.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @RequestMapping(value = "/")
    public String locations(Location location ){
        return "student";

    }

}
