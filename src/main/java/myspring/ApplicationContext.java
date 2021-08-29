package myspring;

import myspring.annotations.Component;
import myspring.factory.AutowireBeanFactory;
import packageScanner.PackageScanner;

import java.util.HashSet;
import java.util.Set;

public class ApplicationContext extends AutowireBeanFactory {

    public ApplicationContext(String pack) {
        constructDefinitions(pack);
    }

    public void constructDefinitions(String pack) {
        Set classes = PackageScanner.findClasses(pack);
        Set<BeanDefinition> beanDefinitions = new HashSet<>();

        for (Object aClass : classes) {
            String tmp = "C:.Users.jiapeng.Documents.code.springDemo.target.classes.";
            tmp = aClass.toString().replace(tmp, "");

            try {
                Class clazz = Class.forName(tmp);
                Component componentAnnotation = (Component) clazz.getAnnotation(Component.class);

                if (componentAnnotation != null) {
                    // 得到component的注解的值
                    String beanName = componentAnnotation.value();

                    // 为无名的bean创建默认beanName
                    if ("".equals(beanName)) {
                        // 获取类名的首字母小写
                        String className = clazz.getName().replaceAll(clazz.getPackage().getName() + ".", "");
                        beanName = className.substring(0, 1).toLowerCase() + className.substring(1);
                    }

                    BeanDefinition beanDefinition = new BeanDefinition(beanName, clazz);
                    // 将beanDefinition加入容器管理的map
                    registerBeanDefinition(beanName, beanDefinition);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
