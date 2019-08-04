package Sample.EJB.java.App;

import javax.ejb.Remote;

import javax.jws.WebService;

@WebService
public interface SampleJmsSessionEJB {
    public void execute();
}
