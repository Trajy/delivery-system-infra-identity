package br.com.trajy.delivery.infra.identity.core.common.utils;

import java.lang.annotation.Annotation;

import static br.com.trajy.delivery.infra.identity.core.common.exception.type.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;
import static java.lang.String.format;

public final class AnnotationUtils {

    private AnnotationUtils() {
        utilityClassUnsupportedInstantiationException();
    }

    public static <S, A extends Annotation> A resolve(S strategy, Class<A> annotationClazz) {
        A annotation = strategy.getClass().getAnnotation(annotationClazz);
        if (annotation == null) {
            throw new IllegalStateException(format("%s must be annotated with %s", strategy.getClass().getName(), annotationClazz.getName()));
        }
        return annotation;
    }

}
