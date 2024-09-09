package DBApplication.example.DBex.services;

import DBApplication.example.DBex.model.User;
import DBApplication.example.DBex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices{

    private final UserRepository userRepository;
    public UserServicesImpl(UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getalluser() {
        return userRepository.findAll();
    }

    @Override
    public User getuserbyid(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createuser(User user) {
      return  userRepository.save(user);

    }

    @Override
    public void deleteuser(long id) {

        userRepository.deleteById(id);
    }

    @Override
    public User updateuser(long id, User user) {

        if(userRepository.existsById(id)){

            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }
}
