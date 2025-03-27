package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class WebUserListController {
    @Autowired
    WebUserListRepository webUserListRepository;
    private RoleEntry roleName;

    @GetMapping("/getUsers")
    public List<UserEntry> getAll(){
        return webUserListRepository.getAll();
    }

    @GetMapping("/getRoles")
    public List<RoleEntry> getRoles(){
        return webUserListRepository.getRoles();
    }

    @PostMapping("/addRole")
    public void addRole(@RequestBody RoleEntry role) {
        webUserListRepository.addRole(role.getRoleName());
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody NewUserEntry newUser) {
        webUserListRepository.addUser(newUser.getUser().getUserName(), newUser.getRole().getRoleName());
    }

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {
        webUserListRepository.deleteUser(userId);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody UserEntry user) {
        webUserListRepository.deleteUser(user.getUserId());
    }

    @DeleteMapping("/deleteRole/{roleId}")
    public void deleteRole(@PathVariable("roleId") int roleId) {
        webUserListRepository.deleteRole(roleId);
    }

}