package org.ridam.spring_security.service;

import lombok.AllArgsConstructor;
import org.ridam.spring_security.dto.RoleAddReqDto;
import org.ridam.spring_security.entity.Roles;
import org.ridam.spring_security.repository.RoleRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleService {
    RoleRepository roleRepository;

    public String addRole(RoleAddReqDto roleAddReqDto){
        Roles role=new Roles();
        role.setRollName(roleAddReqDto.getName());
        roleRepository.save(role);
        return roleAddReqDto.getName()+" has been added successfully";
    }
}
