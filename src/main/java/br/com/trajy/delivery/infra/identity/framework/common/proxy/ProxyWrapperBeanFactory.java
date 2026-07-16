package br.com.trajy.delivery.infra.identity.framework.common.proxy;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.stereotype.Component;

@Component
public class ProxyWrapperFactory {

    public <T> T wrap(T target, Advice... advices) {
        final ProxyFactory proxyFactory = new ProxyFactory(target);
        for(Advice advice : advices) {
            proxyFactory.addAdvice(advice);
        }
        return (T) proxyFactory.getProxy();
    }

}
