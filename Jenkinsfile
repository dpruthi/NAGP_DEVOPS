pipeline {
    agent any
    stages {
        stage('Checkout'){
        steps{
            echo 'Cloning the repository'
            git branch: 'master', url: 'https://github.com/dpruthi/NAGP_DEVOPS.git'
        }
    }
    stage('Test'){
        steps{
             echo 'Testing the code'
             bat 'mvn clean test'
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