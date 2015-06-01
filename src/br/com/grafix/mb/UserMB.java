package br.com.grafix.mb;

import br.com.grafix.dao.UserDAO;
import br.com.grafix.model.User;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * MB controller for users
 * Created by Rogerio Ferracin on 01/06/2015.
 */
@ManagedBean
@ViewScoped
public class UserMB {

    private static final String CREATE_USER = "createUser";
    private static final String LIST_USERS = "listUsers";
    private static final String STAY_IN_SAME_PAGE = null;

    private User user;
    private List<User> users;
    @EJB
    private UserDAO dao;

    //Controllers
    public String createUser()
    {
        try {
            dao.save(user);
        } catch (EJBException e) {
            e.printStackTrace();
            return STAY_IN_SAME_PAGE;
        }
        return "listUsers";
    }

    //Getters & Setters
    public User getUser() {
        if(this.user == null) {
            this.user = new User();
        }
        return user;
    }
    public void setUser(User user) { this.user = user; }

    public List<User> getUsers()
    {
        return dao.findAll();
    }
}
