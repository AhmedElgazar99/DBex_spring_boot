package DBApplication.example.DBex.services;

import DBApplication.example.DBex.model.User;

import java.util.List;

public interface UserServices {
    public List<User> getalluser();
    public User getuserbyid(long id);
    public User createuser(User user);
    public void deleteuser(long id);
    public User updateuser(long id,User user);
}
