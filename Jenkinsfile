pipeline {
  agent any

  environment {
    IMAGE_NAME = "order-mgmt-app:1.0"
  }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'master', url: 'https://github.com/karthik458/order-mgmt-web.git'
      }
    }

    stage('Build and package') {
      steps {
        sh 'mvn -B clean package -DskipTests'
      }
    }

    stage('Docker Image Build') {
      steps {
        sh '''
          echo "Building Docker image..."
          docker build -t $IMAGE_NAME .
          echo "Docker image build completed."
          exit 0
        '''
      }
    }

    stage('Deploy') {
      steps {
        sh 'docker run -d -p 8081:8080 $IMAGE_NAME'
      }
    }
  }

  options {
    durabilityHint('PERFORMANCE_OPTIMIZED')
    timeout(time: 20, unit: 'MINUTES')
  }
}
