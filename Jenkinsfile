pipeline {

    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK 21'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/shu786ash/Testing_Wipro.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t cucumber-framework .'
            }
        }

        stage('Docker Run') {
            steps {
                bat 'docker run --rm cucumber-framework'
            }
        }
    }

    post {

        always {
            junit allowEmptyResults: true,
                  testResults: 'target/junitreports/*.xml'

            archiveArtifacts artifacts: 'target/**/*',
                             fingerprint: true
        }

        success {
            echo 'Build Successful'
        }

        failure {
            echo 'Build Failed'
        }
    }
}