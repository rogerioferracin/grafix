package br.com.grafix.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to hel emit logs
 * Created by Rogerio Ferracin on 02/06/2015.
 */
public class LoggerUtil {

    private static Class clazz;

    public LoggerUtil(Object object)
    {
        clazz = object.getClass();
    }

    public static void logInfoData(String mensagem)
    {
        Logger.getLogger(clazz.getName()).log(Level.INFO, mensagem);
    }

    public static void logErrorData(String mensagem, Exception e)
    {
        Logger.getLogger(clazz.getName()).log(Level.SEVERE, mensagem);
        Logger.getLogger(clazz.getName()).log(Level.SEVERE, e.getMessage());
    }

}
