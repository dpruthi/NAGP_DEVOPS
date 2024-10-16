pipeline {
  agent any
  tools {
    maven 'Maven'
  }
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage("Build") {
      steps {
        bat 'mvn clean'
      }
    }
   stage("Sonar Analysis") {
        steps {
          withSonarQubeEnv("SonarQube_Check") {
            bat "mvn sonar:sonar"
          }
        }
      }
   stage("Quality Gate Status") {
     steps {
        timeout(time: 1, unit: 'HOURS') {
            waitForQualityGate abortPipeline: true
           }
        }
     }
    stage('Test') {
      steps {
        echo 'Testing the code'
        bat 'mvn test'
      }
    }
   stage('Generate TestNG report') {
        steps {
          echo 'Generate TestNG Report'
          testNG()
      }
    }
    stage("Publish to Artifactory") {
      steps {
        rtMavenDeployer(
          id: 'deployer',
          serverId: '9653338@artifactory',
          releaseRepo: 'nagp_assignment_2024',
          snapshotRepo: 'nagp_assignment_2024'
        )
          rtMavenRun(
            pom: 'pom.xml',
            goals: 'clean install -DskipTests',
            deployerId: 'deployer'
          )
        rtPublishBuildInfo(
          serverId: '9653338@artifactory',
        )
      }
    }
  }
  post {
    always {
      echo 'this is always going to execute, in case of failure as well'
    }

    success {
      echo 'build success'
    }
    failure {
      echo 'build failed'
    }
  }
}