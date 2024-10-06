pipeline{
  agent any
  tools{
     maven '3.23'
  }
  stages{
    stage("Checkout"){
      steps{
        checkout scm
      }
    }
    stage("Build"){
      steps{
       bat 'mvn clean'
      }
    }
    stage("Test"){
      steps{
       bat 'mvn test'
      }
    }
  }
}