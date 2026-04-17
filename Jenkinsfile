pipeline {
    agent any

    stages {

        stage('Clone Code') {
            steps {
                git branch: 'main', url: 'https://github.com/susmithapasumarthi349/library_devops.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t library .'
            }
        }

    }
}