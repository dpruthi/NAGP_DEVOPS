pipeline {
    agent any
    stages {
        stage('Checkout'){
        steps{
            echo 'Cloning the repository'
        }
    }
     stage("Build"){
          steps{
           bat 'mvn clean'
          }
        }
    stage('Test'){
        steps{
             echo 'Testing the code'
             bat 'mvn test'
        }
    }
    }
    post{
        always{
            echo 'this is always going to execute, in case of failure as well'
        }
        success{
            echo 'build success'
        }
        failure{
            echo 'build failed'
        }
    }
}