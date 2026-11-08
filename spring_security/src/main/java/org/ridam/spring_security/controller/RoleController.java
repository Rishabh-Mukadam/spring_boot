package org.ridam.spring_security.controller;


import lombok.AllArgsConstructor;
import org.ridam.spring_security.dto.RoleAddReqDto;
import org.ridam.spring_security.repository.RoleRepository;
import org.ridam.spring_security.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/api/role")
public class RoleController {

    private RoleService roleService;

    @PostMapping("/addRole")
    public ResponseEntity<String> addRole(@RequestBody RoleAddReqDto reqDto){
        return ResponseEntity.ok(roleService.addRole(reqDto));
    }
}
