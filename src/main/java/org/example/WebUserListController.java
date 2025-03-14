package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class WebUserListController {
    @Autowired
    WebUserListRepository webUserListRepository;

    @GetMapping("/getUsers")
    public List<UserEntry> getList(){
        return webUserListRepository.getAll();
    }
}