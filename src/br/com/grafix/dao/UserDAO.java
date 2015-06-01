package br.com.grafix.dao;

import br.com.grafix.model.User;

import javax.ejb.Stateless;

/**
 * DAO fro User Crud Operations
 * Created by Rogerio Ferracin on 29/05/2015.
 */
@Stateless
public class UserDAO extends GenericDAO<User> {

    public UserDAO() {
        super(User.class);
    }

    public void delete(User user)
    {
        super.delete(user.getId(), User.class);
    }

}
