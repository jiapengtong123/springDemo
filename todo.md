### 结构
目标： 实现通过注解的ioc

一、bean注册
1. 定义注解类Component
2. 实现包扫描逻辑
3. 扫描到Component注解，进行bean注册

二、bean注入
1. 定义注解类 @Autowried, @Qualifer, @Value
2. 扫描到对应注解，从上下文/工厂/存储中得到对应bean
3. 注入bean

三、辅助
1. BeanDefinition类用于存储读出的bean的结构
2. BeanFactory或上下文值用于存储bean的实例
3. 包扫描代码实现


