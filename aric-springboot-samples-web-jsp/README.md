# tomcat-war-jsp
> 项目打包为`war`包使用外部`tomcat`启动项目

## 关于首页的默认显示
`spingboot` 使用外部 `tomcat` 启动时，会默认加载 `webapp` 下的 `index.jsp`或 `index.html`
假如找到该文件，则显示该文件，假如没有找到会根据 `controller` 配置的 `/` 根路径及配置文件中配置的页面路径地址
联合查找回调的页面位置


## 配置文件 `resources:application.properties`
```
server.port=8085
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```

## pom依赖
```xml
<dependencies>
        <!--spring-boot-starter-web jar提供启动嵌入式Tomcat容器的自动化配置,
       并且提供对微服务应用有价值的端点信息，如服务器信息、应用指标（metrics）以及环境详情
       -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>1.3.3.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
            <version>8.0.36</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <version>1.3.3.RELEASE</version>
            <scope>test</scope>
        </dependency>
</dependencies>

```

## pom 插件
```xml
 <build>
        <finalName>app</finalName>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <configuration>
                    <useSystemClassLoader>false</useSystemClassLoader>
                </configuration>
            </plugin>
        </plugins>
    </build>
```