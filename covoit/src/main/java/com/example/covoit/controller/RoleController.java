package com.example.covoit.controller;


import com.example.covoit.dto.RoleDto;
import com.example.covoit.entity.ERole;
import com.example.covoit.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("Covoit")
public class RoleController {

//@Autowired
//    private IRoleService roleService;
//
//    @PostMapping("addRole")
//    public ResponseEntity addRole(@RequestParam ERole role, String username) {
//        roleService.createRoleToUser(username, role);
//
//        if (role == null) {
//            return ResponseEntity.badRequest().body("Le titre est obligatoire");
//
//        }
//        return ResponseEntity.ok("Le role a bien été ajouté");
//    }
}
