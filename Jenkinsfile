pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-username/order-mgmt-web.git'
            }
        }

        stage('Build') {
            steps {
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t order-mgmt-app:1.0 .'
            }
        }

        stage('Stop Old Containers') {
            steps {
                sh '''
                docker rm -f order-app || true
                docker rm -f prometheus || true
                '''
            }
        }

        stage('Run App Container') {
            steps {
                sh '''
                docker run -d --name order-app -p 8081:8080 order-mgmt-app:1.0
                '''
            }
        }
 	stage('Deploy') {
	    steps {
        	script {
            // Stop old container if exists
            sh 'docker stop order-mgmt-app || true'
            sh 'docker rm order-mgmt-app || true'

            // Run new container
            sh 'docker run -d -p 8081:8080 --name order-mgmt-app order-mgmt-app:1.0'
        	}
   	 }	
	}

	stage('Run Prometheus') {
    		steps {
    		    script {
            def workspaceDir = pwd()
            	sh """
		docker rm -f prometheus || true
                docker run -d \
                  --name prometheus \
                  -p 9090:9090 \
                  -v ${workspaceDir}/prometheus.yml:/etc/prometheus/prometheus.yml \
                  prom/prometheus
            """
        }
    }
}
}
