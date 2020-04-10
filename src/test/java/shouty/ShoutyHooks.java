package shouty;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ShoutyHooks {

    @Before()
    public  void aaa() {
        System.out.println("HELLO BEFORE");
    }


    @Before(order = 1, value = {"@wip", "@test"})
    public  void aaa2() {
        System.out.println("HELLO AGAIN BEFORE");
    }

    @After
    public  void bbb() {
        System.out.println("GOODBYE AFTER");
    }

}
