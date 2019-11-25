package com.tist.factory;

import com.tist.factory.callback.PersonNameFieldCallback;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 * @author Jack Lin
 */
@Component
public class PersonNameAnnotationProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> managedBeanClass = bean.getClass();
        ReflectionUtils.FieldCallback fieldCallback = new PersonNameFieldCallback(bean);
        ReflectionUtils.doWithFields(managedBeanClass, fieldCallback);
        return bean;
    }
}
