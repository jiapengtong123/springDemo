package myspring;

public class BeanDefinition {
    private Object bean;

    private Class beanClass;

    private String beanName;

    public BeanDefinition(String beanName, Class beanClass) {
        this.beanName = beanName;
        this.beanClass = beanClass;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }


}
