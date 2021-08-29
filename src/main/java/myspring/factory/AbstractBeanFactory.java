package myspring.factory;

import myspring.BeanDefinition;

import java.util.HashMap;

public abstract class AbstractBeanFactory implements BeanFactory {

    protected HashMap<String, BeanDefinition> map = new HashMap<>();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beandefinition = map.get(name);
        if (beandefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beandefinition.getBean();
        if (bean == null) {
            bean = doCreate(beandefinition);
        }
        return bean;
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beandefinition) throws Exception {
        Object bean = doCreate(beandefinition);
        beandefinition.setBean(bean);
        map.put(name, beandefinition);
        System.out.println(map);
    }

    abstract Object doCreate(BeanDefinition beandefinition) throws Exception;
}
