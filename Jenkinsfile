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
          bat "echo Sonar Run half"
          bat "mvn sonar:sonar"
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
  stage('Generate Reports') {
    steps {
      // Publish TestNG results
      // Assuming reports are generated in target/surefire-reports
      publishTestNGResults(testngXml: '**/target/surefire-reports/testng-results.xml')
    }
  }
}
post {
  always {
    echo 'this is always going to execute, in case of failure as well'

    // Always archive reports, even if the build fails
    // Archive the TestNG reports for later analysis
    archiveArtifacts artifacts: 'target/surefire-reports/testng-results.xml', fingerprint: true
    archiveArtifacts artifacts: 'target/surefire-reports/*.html', fingerprint: true
  }
}
success {
  echo 'build success'
}
failure {
  echo 'build failed'
}