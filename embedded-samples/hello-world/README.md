# hello-world

This project presents the basic structure for using TotalCross. If you already have the [prerequisites](https://learn.totalcross.com/documentation/get-started/install), just run `mvn package` in command line and *voy a la*!

## Pimp your code :sunglasses:

See how to start making your own project with TotalCross, [get start](https://learn.totalcross.com/documentation/get-started)!

## Need Help?

- Contact us in the [Telegram Community](https://t.me/totalcrosscommunity)
- Ask a question on [StackOverflow](https://stackoverflow.com/) and tag it with `totalcross`
- Found a bug? Please [open an issue](https://github.com/TotalCross/totalcross/issues)

### PS: Starting out with Eclipse IDE

If you want to start with Eclipse IDE, you will get an error on the POM.xml file. This error should not impact in the execution of your project neither in any maven task, but if you want to fix it, copy the tags below before the </project> tag, at the end of the pom.xml 

<pre><code>
&lt;profiles&gt;
    &lt;profile&gt;
      &lt;id&gt;only-eclipse&lt;/id&gt;
      &lt;activation&gt;
        &lt;property&gt;
          &lt;name&gt;m2e.version&lt;/name&gt;
        &lt;/property&gt;
      &lt;/activation&gt;
      &lt;build&gt;
        &lt;pluginManagement&gt;
          &lt;plugins&gt;
            &lt;plugin&gt;
              &lt;groupId&gt;org.eclipse.m2e&lt;/groupId&gt;
              &lt;artifactId&gt;lifecycle-mapping&lt;/artifactId&gt;
              &lt;version&gt;1.0.0&lt;/version&gt;
              &lt;configuration&gt;
                &lt;lifecycleMappingMetadata&gt;
                  &lt;pluginExecutions&gt;
                    &lt;pluginExecution&gt;
                      &lt;pluginExecutionFilter&gt;
                        &lt;groupId&gt;com.totalcross&lt;/groupId&gt;
                        &lt;artifactId&gt;totalcross-maven-plugin&lt;/artifactId&gt;
                        &lt;versionRange&gt;[1.1.6,)&lt;/versionRange&gt;
                        &lt;goals&gt;
                          &lt;goal&gt;retrolambda&lt;/goal&gt;
                        &lt;/goals&gt;
                      &lt;/pluginExecutionFilter&gt;
                      &lt;action&gt;
                        &lt;execute /&gt;
                      &lt;/action&gt;
                    &lt;/pluginExecution&gt;
                  &lt;/pluginExecutions&gt;
                &lt;/lifecycleMappingMetadata&gt;
              &lt;/configuration&gt;
            &lt;/plugin&gt;
          &lt;/plugins&gt;
        &lt;/pluginManagement&gt;
      &lt;/build&gt;
    &lt;/profile&gt;
  &lt;/profiles&gt;
</code></pre>
