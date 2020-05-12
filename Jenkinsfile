node()
{
  stage('SCM Checkout')
  {
    git 'https://github.com/Biplab-C/Cucumber-Selenium-Reporting'
  }
  stage('Compile-Package')
  {
    def mvnhome = tool name: '', type: 'maven'
    sh "${mvnhome}/bin/mvn package"
  }
}
    
