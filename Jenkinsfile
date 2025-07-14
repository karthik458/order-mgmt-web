pipeline {
  agent any
  stages {
    stage('Build and package') {
      steps {
        sh '''mvn clean package -DskipTests
'''
      }
    }

    stage('Docker Image Build') {
      steps {
        sh '''docker build -t order-mgmt-app:1.0 .
'''
      }
    }

    stage('Deploy') {
      steps {
        sh 'docker run -d -p 8081:8080 order-mgmt-app:1.0'
      }
    }

  }
}