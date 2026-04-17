pipeline {
    agent any

    stages {

        stage('Clone Code') {
            steps {
                git 'https://github.com/susmithapasumarthi349/library_devops.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t library .'
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh 'minikube image load library'
                sh 'kubectl apply -f k8s/deployment.yaml'
                sh 'kubectl apply -f k8s/service.yaml'
            }
        }

    }
}