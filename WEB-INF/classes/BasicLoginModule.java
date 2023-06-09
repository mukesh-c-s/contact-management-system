
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;

import javax.security.auth.callback.UnsupportedCallbackException;

import javax.security.auth.login.LoginException;


import org.apache.catalina.Session;

public class BasicLoginModule implements javax.security.auth.spi.LoginModule {
    private CallbackHandler handler;
    Session session;
    private Subject subject;
    private String login;
    private String username;
    private String password;
    public static String uname;
    public static boolean isauthenticated=false;
    public static boolean isenabled=false;
    private Map<String, ?> options;
    private String secretKey ;
    private List<String> roles;
    UserPrincipal userPrincipal;
    RolePrincipal rolePrincipal;
    
    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String,?> sharedState,
            Map<String, ?> options) {
        handler = callbackHandler;
        this.subject = subject;
    }
    @Override
    public boolean login() throws LoginException {

        Callback[] callbacks = new Callback[2];
    callbacks[0] = new NameCallback("username");
    callbacks[1] = new PasswordCallback("password", false);
    
    
        try {
            handler.handle(callbacks);
        } catch (IOException e) {
            throw new LoginException(e.getMessage());
        } catch (UnsupportedCallbackException e) {
            throw new LoginException("Callback not supported: " + e.getCallback().getClass().getName());
        }
        
        String username = ((NameCallback) callbacks[0]).getName();
        String password = String.valueOf(((PasswordCallback) callbacks[1]).getPassword());
        if(username==null)
        {
            try {
                secretKey=new LoginDao().getSecretkey(uname);
                
                String code = LoginDao.getTOTPCode(secretKey);
                System.out.println(code);
                if (password.equals(code) ) {
                    login = LoginDao.getUid(uname);
                    
                    roles = new ArrayList<String>();
                    roles.add("user");
                    isauthenticated=false;
                    isenabled=false;
                    return true;
                }
                else{
                    isauthenticated=false;
                    isenabled=false;
                }
            
    
            } catch (SQLException e) {
    
                e.printStackTrace();
            }
            throw new LoginException("authentication failed");
        }    
        
        else{
        try {
           
            if (LoginDao.getLogin(username, password)) {
                if(LoginDao.enabled(username))
                {
                    
                    isauthenticated=true;
                    isenabled=true;
                    uname=username;
                    
                    return false;
                }
                else{
                    isauthenticated=true;
                login = LoginDao.getUid(username);
                
                roles = new ArrayList<String>();
                roles.add("user");
                
                return true;
                }
             
            }
            else{
                throw new LoginException("Authentication failed");
            }
        

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    
        throw new LoginException("Authentication failed");

    }

    @Override
    public boolean commit() throws LoginException {
        String userRoles = "";
        if (roles != null && roles.size() > 0) {
            for (String role : roles) {
                userRoles += role + " ";
                rolePrincipal = new RolePrincipal(role);
                subject.getPrincipals().add(rolePrincipal);
            }
        }
        userPrincipal = new UserPrincipal(login + " " + userRoles);
        subject.getPrincipals().add(userPrincipal);
        return true;
    }

    @Override
    public boolean abort() throws LoginException {

        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        subject.getPrincipals().remove(userPrincipal);
        subject.getPrincipals().remove(rolePrincipal);
        return true;
    }

}
