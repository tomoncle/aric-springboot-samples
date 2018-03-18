# sprint-boot-samples

## running
*  tomcat-* is `jar` run :  inherit tomcat container, start with `java -jar tomcat-*.jar`
*  web-* is `war` run    :  Need external Tomcat container start project

## default config
* `jar` run : default resource location is "static, public, resources, /META-INF/resources/"
* `war` run : you can auto config the location, as `spring.mvc.view.prefix=/WEB-INF/jsp/`

## samples

* 热加载 : [aric-springboot-samples-tomcat-env](aric-springboot-samples-tomcat-env) and [aric-springboot-samples-tomcat-freemarker](aric-springboot-samples-tomcat-freemarker)
* 异常处理 : [aric-springboot-samples-tomcat-jsp](aric-springboot-samples-tomcat-jsp) and [aric-springboot-samples-web-jsp](aric-springboot-samples-web-jsp)
* JSP : [aric-springboot-samples-tomcat-jsp](aric-springboot-samples-tomcat-jsp) and [aric-springboot-samples-web-jsp](aric-springboot-samples-web-jsp)
* freemarker : [aric-springboot-samples-tomcat-freemarker](aric-springboot-samples-tomcat-freemarker) and [aric-springboot-samples-web-freemarker](aric-springboot-samples-web-freemarker)
* 环境变量 : [aric-springboot-samples-tomcat-env](aric-springboot-samples-tomcat-env)
* RestApi/Swagger : [aric-springboot-samples-tomcat-restful](aric-springboot-samples-tomcat-restful)
* Mybatis : [aric-springboot-samples-tomcat-mybatis](aric-springboot-samples-tomcat-mybatis)
* AutoDataSource+Mybatis : [aric-springboot-samples-tomcat-dbcp](aric-springboot-samples-tomcat-dbcp)
