package com.hamzi.hnia.dz.Services;

import com.hamzi.hnia.dz.Models.Users;
import com.hamzi.hnia.dz.Repositorys.usersRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class userServiceImp implements usersService{
    private usersRepository usersRepositoryImp;

    public userServiceImp(com.hamzi.hnia.dz.Repositorys.usersRepository usersRepositoryImp) {
        this.usersRepositoryImp = usersRepositoryImp;
    }

    @Override
    public Users getuserByUsername(String username) {
        return usersRepositoryImp.findByUsername(username);
    }

    @Override
    public Users addUser(Users user) {
        return usersRepositoryImp.save(user);
    }

    @Override
    public List<Users> listUsers() {
        return usersRepositoryImp.findAll();
    }
}
