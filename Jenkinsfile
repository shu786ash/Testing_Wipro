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
                dir('CucumberBDD2') {

                    bat 'mvn clean test'

                }
            }
        }

        stage('Package') {
            steps {
                dir('CucumberBDD2') {

                    bat 'mvn package -DskipTests'

                }
            }
        }

    }

    post {

        always {

            junit allowEmptyResults: true,
                  testResults: 'CucumberBDD2/target/junitreports/*.xml'

            archiveArtifacts artifacts: 'CucumberBDD2/target/**/*.*',
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