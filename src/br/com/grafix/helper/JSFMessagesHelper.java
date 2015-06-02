package br.com.grafix.helper;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Class to send messages to users
 * Created by Rogerio Ferracin on 02/06/2015.
 */
public class JSFMessagesHelper {

    /***
     * Send info message to user
     * @param message String message
     */
    public static void sendInfoMessageToUser(String message)
    {
        FacesContext context = getContext();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", message));
    }

    /**
     * Send a error message to user
     * @param message String message
     */
    public static void sendErrorMessageToUser(String message)
    {
        FacesContext context = getContext();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", message));
    }


    private static FacesContext getContext()
    {
        FacesContext context = FacesContext.getCurrentInstance();
//        context.getExternalContext().getFlash().setKeepMessages(true);

        return context;
    }


}
