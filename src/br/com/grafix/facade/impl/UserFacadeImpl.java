package br.com.grafix.facade.impl;

import br.com.grafix.dao.UserDAO;
import br.com.grafix.facade.UserFacade;
import br.com.grafix.model.User;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Facade class for user
 * Created by Rogerio Ferracin on 01/06/2015.
 */
@Stateless
public class UserFacadeImpl implements UserFacade {

    @EJB
    private UserDAO dao;

    @Override
    public void save(User user) {
        user.setActive(true);
        dao.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }
}
