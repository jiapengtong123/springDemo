package myspring.factory;

import myspring.BeanDefinition;

public interface BeanFactory {

    Object getBean(String name) throws Exception;

    void registerBeanDefinition(String name, BeanDefinition bean) throws Exception;
}
