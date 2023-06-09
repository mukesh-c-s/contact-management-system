import java.io.IOException;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;

public class OtpModule implements javax.security.auth.spi.LoginModule
{    private CallbackHandler handler;
    private Subject subject;
    private String login;
    private String username;
    private String password;
    private String otp;
    private Map<String, String> sharedState;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
            Map<String, ?> options) {
        // TODO Auto-generated method stub
        handler = callbackHandler;
        this.subject = subject;

        
    }

    @Override
    public boolean login() throws LoginException {

        // TODO Auto-generated method stub
        Callback[] callbacks = new Callback[2];
        callbacks[0]=new NameCallback("username");
        callbacks[1] = new PasswordCallback("password", false);
        try {
            handler.handle(callbacks);
        } catch (IOException | UnsupportedCallbackException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String username = ((NameCallback) callbacks[0]).getName();
        String password = String.valueOf(((PasswordCallback) callbacks[1])
                .getPassword());
                //String uname=(String)sharedState.get("username");
        System.out.println(username+password);
        return true;
    }

    @Override
    public boolean commit() throws LoginException {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean abort() throws LoginException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        // TODO Auto-generated method stub
        return false;
    }

}