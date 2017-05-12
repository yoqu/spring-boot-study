# Spring Boot核心

`author` : [yoqu](http://www.yoqu.org)

`createTime` : 2017年05月11 下午3:36


---

## 6.1 基本配置

### 入口类和@SpringBootApplication

 Spring Boot有一个名为*Application类的入口类,通过main方法,使用`SpringApplication.run`来启动Spring Boot项目.

 @SpringBootApplication是Spring Boot的核心注解,它是一个组合注解,源码:

 ```java
 @Target(ElementType.TYPE)
 @Retention(RetentionPolicy.RUNTIME)
 @Documented
 @Inherited
 @SpringBootConfiguration
 @EnableAutoConfiguration
 @ComponentScan(excludeFilters = {
 		@Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
 		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
 public @interface SpringBootApplication {

	/**
	 * Exclude specific auto-configuration classes such that they will never be applied.
	 * @return the classes to exclude
	 */
	@AliasFor(annotation = EnableAutoConfiguration.class, attribute = "exclude")
	Class<?>[] exclude() default {};

	/**
	 * Exclude specific auto-configuration class names such that they will never be
	 * applied.
	 * @return the class names to exclude
	 * @since 1.3.0
	 */
	@AliasFor(annotation = EnableAutoConfiguration.class, attribute = "excludeName")
	String[] excludeName() default {};

	/**
	 * Base packages to scan for annotated components. Use {@link #scanBasePackageClasses}
	 * for a type-safe alternative to String-based package names.
	 * @return base packages to scan
	 * @since 1.3.0
	 */
	@AliasFor(annotation = ComponentScan.class, attribute = "basePackages")
	String[] scanBasePackages() default {};

	/**
	 * Type-safe alternative to {@link #scanBasePackages} for specifying the packages to
	 * scan for annotated components. The package of each class specified will be scanned.
	 * <p>
	 * Consider creating a special no-op marker class or interface in each package that
	 * serves no purpose other than being referenced by this attribute.
	 * @return base packages to scan
	 * @since 1.3.0
	 */
	@AliasFor(annotation = ComponentScan.class, attribute = "basePackageClasses")
	Class<?>[] scanBasePackageClasses() default {};

 }
 ```
 @EnableAutoConfiguration让Spring Boot根据类路径中的jar包依赖未当前项目自动配置

### 6.1.2 关闭特定的自动配置

通过注解,我们可以看出应该使用exclude参数,例如:
```java
@SpringBootApplication(exclude={TestAutoConfiguration.class})
```

### 6.1.3 定制Banner

1. 修改Banner
 * 在Spring Boot启动时候会有一个默认图案
 * 我们可以在双人床/main/resources/新建一个banner.txt
 * 通过http://patorjk.com/software/taag 网站生成字符,并复制到Banner.txt中

2. 关闭Banner
 * main中的内容修改为
 `app.setShowBanner(false);`

## 6.3日志配置

Spring Boot支持Java Util Logging Log4j Log4j2和Logback作为日志框架
默认Spring Boot使用Logback作为日志框架