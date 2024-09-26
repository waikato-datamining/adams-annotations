# adams-annotations
Java annotations and processors for the ADAMS project.

## Maven

### Dependency

```xml
    <dependency>
      <groupId>nz.ac.waikato.cms.adams</groupId>
      <artifactId>adams-annotations</artifactId>
      <version>0.0.1</version>
    </dependency>

```

### Plugin management

```xml
        <plugin>
          <groupId>org.bsc.maven</groupId>
          <artifactId>maven-processor-plugin</artifactId>
          <version>5.1</version>
          <executions>
            <execution>
              <id>process</id>
              <goals>
                <goal>process</goal>
              </goals>
              <phase>process-classes</phase>
              <configuration>
                <processors>
                   <processor>adams.core.annotation.MixedCopyrightProcessor</processor>
                   <processor>adams.core.annotation.ThirdPartyCopyrightProcessor</processor>
                </processors>
                <options>
                  <printheader>true</printheader>
                  <module>${project.artifactId}</module>
                  <output>${project.build.directory}/${project.artifactId}-${project.version}</output>
                </options>
              </configuration> 
            </execution>
          </executions>
        </plugin>         
```

### Plugin

```xml
      <plugin>
        <groupId>org.bsc.maven</groupId>
        <artifactId>maven-processor-plugin</artifactId>
      </plugin>
```
