How to make a release
=====================

* Switch to Java 11

* Run the following command to deploy the artifact:

  ```
  mvn release:clean release:prepare release:perform
  ```

* Close/release artifacts on https://oss.sonatype.org/

* Push all changes

* Update artifact version in README.md
