package Sample.EJB.java.App;

import Sample.EJB.java.QueueSend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Hashtable;

import javax.ejb.Stateless;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;

import javax.jws.WebService;

import javax.naming.Context;
import javax.naming.InitialContext;

@Stateless(name = "SampleJmsSessionEJB", mappedName = "ServiceSchedulerApp-SampleSendingQueue-SampleJmsSessionEJB")
@WebService
public class SampleJmsSessionEJBBean implements SampleJmsSessionEJB {
    public SampleJmsSessionEJBBean() {
    }
    private QueueConnectionFactory qconFactory;
    private QueueConnection qcon;
    private QueueSession qsession;
    private QueueSender qsender;
    private Queue queue;
    private TextMessage msg;
 
    public final static String JNDI_FACTORY="weblogic.jndi.WLInitialContextFactory";

    // Defines the JMS context factory.
    public final static String JMS_FACTORY="jms/SampleConnectionFactory";

    // Defines the queue.
    public final static String QUEUE="jms/SampleQueue";
    
    
         public void execute() {
         DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         Date date = new Date();
        QueueSend qs = new QueueSend();
      
        
        try {
           
           System.out.println("Creating Queue Connection");
           Hashtable env = new Hashtable();
           env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
           env.put(Context.PROVIDER_URL, "t3://localhost:7001");
           InitialContext ic = new InitialContext(env);
           qs.init(ic, "jms/SampleQueue");
           qs.send("<dem:NewOperation xmlns:dem=\"http://www.example.org/DemoEchoWS/\">\n" + 
             "    <dem:NewOperation xmlns:dem=\"http://www.example.org/DemoEchoWS/\">\n" + 
             "   <in>second</in>\n" + 
             "   </dem:NewOperation>\n" ); 
           
           qs.close(); 
              
            
        } 
         
         catch (Exception e) {
         System.out.println(" Process failed: " + e.toString());
         e.printStackTrace();
        
        }
       
        }
    
}
