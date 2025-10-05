package com.rest.webservices.restful_web_services.user;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    static{
        users.add(new User(1,"Jayasree", LocalDate.now().minusYears(25)));
        users.add(new User(2,"Lalitha",LocalDate.now().minusYears(40)));
        users.add(new User(3,"Keerthi",LocalDate.now().minusYears(23)));
        users.add(new User(4,"Mallikarjuna",LocalDate.now().minusYears(50)));
    }
    public List<User> findAll(){
        return users;
    }
//    public User save(User user){
//
//    }
//    public User findOne(int id){
//
//    }
}
