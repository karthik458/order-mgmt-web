pipeline {
  agent any
  stages {
    stage('Build and package') {
      steps {
        sh '''mvn -B clean package -DskipTests
'''
      }
    }

    stage('Docker Image Build') {
      steps {
      script {
                    docker.build('order-mgmt-app:1.0', '.')
'''
      }
    }

    stage('Deploy') {
      steps {
        sh 'docker run -d -p 8081:8080 order-mgmt-app:1.0'
      }
    }

  }
  options {
    durabilityHint('PERFORMANCE_OPTIMIZED')
    timeout(time: 20, unit: 'MINUTES')
  }
}
