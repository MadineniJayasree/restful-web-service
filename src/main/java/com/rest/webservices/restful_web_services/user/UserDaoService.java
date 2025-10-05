package com.rest.webservices.restful_web_services.user;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

@Service
public class UserDaoService {
    private static int userCount=0;
    private static List<User> users = new ArrayList<>();
    static{
        users.add(new User(++userCount,"Jayasree", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount,"Lalitha",LocalDate.now().minusYears(40)));
        users.add(new User(++userCount,"Keerthi",LocalDate.now().minusYears(23)));
        users.add(new User(++userCount,"Mallikarjuna",LocalDate.now().minusYears(50)));
    }
    public List<User> findAll(){
        return users;
    }
    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }
    public User findOne(int id){
//        return users.get(id);
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public boolean deleteById(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.removeIf(predicate);
    }

    public User UpdateById(int id,String name){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        User res = users.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow(() -> new UserNotFoundException("id: "+id));
        res.setName("Ramana");
        return res;
    }
}
