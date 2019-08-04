package Sample.EJB.java.App;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SampleJmsSessionEJBClient {
    public static void main(String [] args) {
        try {
            final Context context = getInitialContext();
            SampleJmsSessionEJB sampleJmsSessionEJB = (SampleJmsSessionEJB)context.lookup("ServiceSchedulerApp-SampleSendingQueue-SampleJmsSessionEJB#Sample.EJB.java.App.SampleJmsSessionEJB");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x connection details
        env.put( Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
        env.put(Context.PROVIDER_URL, "t3://localhost:7001");
        return new InitialContext( env );
    }
}
