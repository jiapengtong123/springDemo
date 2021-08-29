package myspring.factory;

import myspring.BeanDefinition;
import myspring.annotations.Autowired;
import myspring.annotations.Qualifier;
import myspring.annotations.Value;
import packageScanner.PackageScanner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AutowireBeanFactory extends AbstractBeanFactory{
    @Override
    public Object doCreate(BeanDefinition beandefinition) throws Exception {
        Class clazz = beandefinition.getBeanClass();
        Object obj = clazz.getConstructor().newInstance();

        Field[] fields = clazz.getDeclaredFields();

        for (Field declaredField: fields) {
            injectValue(declaredField, clazz, obj);
            injectObj(declaredField, clazz, obj);
        }
        return obj;
    }

    private void injectValue(Field declaredField, Class clazz, Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Value valueAnnotation = declaredField.getAnnotation(Value.class);

        if (valueAnnotation != null) {
            String value = valueAnnotation.value();
            String fieldName = declaredField.getName();
            String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Method method =  clazz.getMethod(methodName, declaredField.getType());

            Object val = null;
            switch (declaredField.getType().getName()) {
                case "java.lang.Integer":
                    val =  Integer.parseInt(value);
                    break;
                case "java.lang.String":
                    val = value;
                    break;
                case "java.lang.Float":
                    val = Float.parseFloat(value);
                    break;
                default:
                    val = null;
            }
            method.invoke(obj, val);
        }
    }

    private void injectObj(Field declaredField, Class clazz, Object obj) throws Exception {
        Autowired autowiredAnnotation = declaredField.getAnnotation(Autowired.class);
        if (autowiredAnnotation != null) {
            Qualifier qualifierAnnotation = declaredField.getAnnotation(Qualifier.class);
            if (qualifierAnnotation != null) {
                String beanName = qualifierAnnotation.value();
                Object bean = getBean(beanName);

                String fieldName = declaredField.getName();
                String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Method method =  clazz.getMethod(methodName, declaredField.getType());

                method.invoke(obj, bean);
            }
        }
    }
}
