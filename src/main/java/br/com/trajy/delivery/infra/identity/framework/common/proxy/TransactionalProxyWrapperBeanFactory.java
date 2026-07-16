package br.com.trajy.delivery.infra.identity.framework.common.proxy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Component
@RequiredArgsConstructor
public class TransactionalProxyBeanFactory {

    private final ProxyWrapperFactory proxyWrapperFactory;
    private final PlatformTransactionManager transactionManager;

    public <T> T createProxy(T target) {
        return this.proxyWrapperFactory.wrap(target, this.createTransactionInterceptor(TransactionDefinition.PROPAGATION_REQUIRED, false));
    }

    public <T> T createReadOnlyProxy(T target) {
        return this.proxyWrapperFactory.wrap(target, this.createTransactionInterceptor(TransactionDefinition.PROPAGATION_REQUIRED, true));
    }



    private TransactionInterceptor createTransactionInterceptor(int transactionDefinition, boolean isReadOnly) {
        final TransactionInterceptor interceptor = new TransactionInterceptor();
        interceptor.setTransactionManager(transactionManager);
        final MatchAlwaysTransactionAttributeSource source = new MatchAlwaysTransactionAttributeSource();
        final RuleBasedTransactionAttribute attribute = this.getTransactionAttribute(transactionDefinition, isReadOnly);
        source.setTransactionAttribute(attribute);
        interceptor.setTransactionAttributeSource(source);
        return interceptor;
    }

    private RuleBasedTransactionAttribute getTransactionAttribute(int transactionDefinition, boolean isReadOnly) {
        final RuleBasedTransactionAttribute attribute = new RuleBasedTransactionAttribute();
        attribute.setPropagationBehavior(transactionDefinition);
        attribute.setReadOnly(isReadOnly);
        return attribute;
    }


}
