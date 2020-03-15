# tinyImage
图片压缩

图片上传页面
/tiny/compressPage


##项目启动

1、正常打包，将/ROOT-INF/lib目录单独上传（可以放jar包同级目录下）

2、pom文件插件-添加改依赖-确定main文件
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <mainClass>com.nolife.TinyImageApplication</mainClass>
        <layout>ZIP</layout>
        <includes>
            <include>
                <groupId>nothing</groupId>
                <artifactId>nothing</artifactId>
            </include>
        </includes>
    </configuration>
    <executions>
        <execution>
            <goals>
                <goal>repackage</goal>
            </goals>
        </execution>
    </executions>
</plugin>

3、添加插件后打包将去除lib目录的jar包上传

4、执行命令启动项目(lib与jar在同级目录下)
nohup java -Dloader.path=lib -jar jar包名称.jar &

##注意事项
com.nolife.utils.CompressUtil类是文件上传并压缩工具类
其中图片保存路径和结果返回路径在其中定义，有需要可以自行修改