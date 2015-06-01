package br.com.grafix.facade;

import br.com.grafix.model.User;

import javax.ejb.Local;

/**
 * Facade class for user
 * Created by Rogerio Ferracin on 01/06/2015.
 */
@Local
public interface UserFacade {

    void save(User user);
    User update(User user);

}
