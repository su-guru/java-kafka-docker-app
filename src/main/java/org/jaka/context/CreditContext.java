package org.jaka.context;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CreditContext {
    @Inject
    PaymentService service1;

    @Inject
    AbstractCreditService service2;

    @Inject
    CreditService service3;

    public void process() {
        service3.output();
        System.out.println(service1.hashCode());
        System.out.println(service2.hashCode());
        System.out.println(service3.hashCode());
        System.out.println(service3.output());
    }
}
