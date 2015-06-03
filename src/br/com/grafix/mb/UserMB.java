package br.com.grafix.mb;

import br.com.grafix.dao.UserDAO;
import br.com.grafix.helper.JSFMessagesHelper;
import br.com.grafix.helper.LoggerUtil;
import br.com.grafix.model.Role;
import br.com.grafix.model.User;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * MB controller for users
 * Created by Rogerio Ferracin on 01/06/2015.
 */
@ManagedBean
@RequestScoped
public class UserMB extends AbstractMB{

    private static final String CREATE_USER = "createUser";
    private static final String UPDATE_USER = "updateUser";
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
            LoggerUtil.logErrorData("Ocorreu um erro ao persistir o objeto: ", e);
            JSFMessagesHelper.sendErrorMessageToUser("Ocorreu um erro ao persistir o usuário. Tente novamente.");
            return STAY_IN_SAME_PAGE;
        }
        JSFMessagesHelper.sendInfoMessageToUser("Usuario cadastrado com sucesso.");
        return LIST_USERS;
    }

    public String updateUser() {
        try {
            dao.update(user);
        } catch (EJBException e) {
            JSFMessagesHelper.sendErrorMessageToUser("Ocorreu um erro ao persistir o usuário. Tente novamente.");
            return STAY_IN_SAME_PAGE;
        }
        return LIST_USERS;
    }

    //Navigation
    public String navListUsers(){ return LIST_USERS; }
    public String navCreateUser(){ return CREATE_USER; }
    public String navUpdateUser(){ return "/pages/protected/users/updateUser.xhtml"; }

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

    public Role[] getRoles() {
        return Role.values();
    }
}
