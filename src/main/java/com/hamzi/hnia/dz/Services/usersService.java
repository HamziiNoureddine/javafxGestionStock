package com.hamzi.hnia.dz.Services;

import com.hamzi.hnia.dz.Models.Users;

import java.util.List;


public interface usersService {



    public Users getuserByUsername(String username);
    public Users addUser(Users user);
    public List<Users> listUsers();
}
