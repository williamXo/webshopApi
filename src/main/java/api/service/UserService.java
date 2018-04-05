package api.service;

import api.model.User;
import api.persistence.UserDAO;
import org.jdbi.v3.core.Jdbi;

public class UserService {
    private UserDAO dao;

    public UserService(Jdbi jdbi) {
        this.dao = jdbi.onDemand(UserDAO.class);
    }
    public User getUserByName(String name){
  return dao.getUsernameByName(name);
    }
    public User getlogin(User name){
        return dao.getUsernameByName(name.getUsername());
    }


    public User loginUser(String username, String password)
    {
        return dao.loginUser(username, password);
    }

    public void updateUser(User user){
        dao.updateUser(user);
    }
}
