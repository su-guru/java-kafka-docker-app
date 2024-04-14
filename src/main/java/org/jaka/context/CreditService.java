package org.jaka.context;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreditService extends AbstractCreditService implements PaymentService {
    public String output() {
        return "This is CreditService";
    }
}
