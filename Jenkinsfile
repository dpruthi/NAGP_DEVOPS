pipeline {
  agent any
  tools {
    maven 'Maven'
  }
  stages {
    stage('Checkout') {
      steps {
        echo 'Cloning the repository'
      }
    }
    stage("Build") {
      steps {
        bat 'mvn clean'
      }
    }
    stage('Test') {
      steps {
        echo 'Testing the code'
        bat 'mvn test'
      }
    }
    stage("Sonar Analysis") {
      steps {
        withSonarQubeEnv("SonarQube_Check") {
          //bat "mvn sonar:sonar"
          script {
                           // Perform the SonarQube analysis
                      def sonarResult = sh(script: 'mvn sonar:sonar', returnStatus: true)

                         // Check if the analysis was successful
                         if (sonarResult != 0) {
                             error("SonarQube analysis failed!")
                         }
                     }
        }
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
          goals: 'clean install',
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

      // Always archive reports, even if the build fails
      // Archive the TestNG reports for later analysis
       testNG()

    }

    success {
      echo 'build success'
    }
    failure {
      echo 'build failed'
    }
  }
}