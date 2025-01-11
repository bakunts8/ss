pipeline {
    agent any

    environment {
        // Define your environment variables here
        JENKINS_URL = 'http://localhost:8080'
        JENKINS_API_TOKEN = credentials('JENKINS_API_TOKEN') // use Jenkins credentials for API token
        GITHUB_USER = 'admin' // Jenkins user to trigger build
        JOB_NAME = 'my-jenkins-job' // Name of the Jenkins job to trigger
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from GitHub
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building the application...'
                // Add build steps here, for example:
                sh './mvnw clean install'
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running tests...'
                // Run your tests here (for example with Maven or Gradle):
                // sh './mvnw test'
            }
        }

        stage('Deploy to QA') {
            when {
                branch 'main' // Only deploy if we are on the main branch
            }
            steps {
                echo 'Deploying to QA environment...'
                // Deploy to QA (you can add your deploy script here)
                // sh './deploy_to_qa.sh'
            }
        }

        stage('Deploy to Staging') {
            when {
                branch 'staging' // Only deploy if we are on the staging branch
            }
            steps {
                echo 'Deploying to Staging environment...'
                // Deploy to Staging (you can add your deploy script here)
                // sh './deploy_to_staging.sh'
            }
        }

        stage('Deploy to Production') {
            when {
                branch 'production' // Only deploy if we are on the production branch
            }
            steps {
                echo 'Deploying to Production environment...'
                // Deploy to Production (you can add your deploy script here)
                // sh './deploy_to_production.sh'
            }
        }
    }

    post {
        success {
            echo 'Build and deployment were successful!'
        }
        failure {
            echo 'Build or deployment failed!'
        }
    }
}
