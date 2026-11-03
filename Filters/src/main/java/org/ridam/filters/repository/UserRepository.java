package org.ridam.filters.repository;


import org.ridam.filters.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository {

    HashMap<Integer, UserDto> map;
    public UserRepository(){
        this.map=new HashMap<Integer, UserDto>();
    }


    public UserDto saveUser(UserDto user){
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            System.out.println(e);
        }
        map.put(user.getId(),user);
        return map.get(user.getId());
    }

    public List<UserDto> getAll() {
        return map.values().stream().toList();
    }
}
