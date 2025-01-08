pipeline {
    agent any
    environment {
        // GitHub credentials reference (replace 'github-token' with your actual credential ID)
        GITHUB_CREDENTIALS = credentials('github-token')  // Reference GitHub PAT credentials

        // Define server addresses for each environment (replace with actual servers)
        DEV_SERVER = 'dev.example.com'
        QA_SERVER = 'qa.example.com'
        STAGING_SERVER = 'staging.example.com'
        PROD_SERVER = 'prod.example.com'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from GitHub using stored credentials
                git url: 'https://github.com/your-username/your-repo.git', credentialsId: 'github-token'
            }
        }

        stage('Run Health Tests') {
            when {
                branch 'feature/*'  // Trigger health tests on feature branches
            }
            steps {
                script {
                    // Run health tests (TestNG tests in the "health" group)
                    sh 'mvn test -Dtestng.groups=health'
                }
            }
            post {
                success {
                    echo 'Health tests passed!'
                }
                failure {
                    error 'Health tests failed, stopping the pipeline.'
                }
            }
        }

        stage('Run Smoke Tests') {
            when {
                anyOf {
                    branch 'qa'
                    branch 'staging'
                    branch 'production'
                }
            }
            steps {
                script {
                    // Run smoke tests (TestNG tests in the "smoke" group)
                    sh 'mvn test -Dtestng.groups=smoke'
                }
            }
            post {
                success {
                    echo 'Smoke tests passed!'
                }
                failure {
                    error 'Smoke tests failed, stopping the pipeline.'
                }
            }
        }

        stage('Deploy to Dev') {
            when {
                branch 'dev'  // Deploy only on dev branch (without smoke tests)
            }
            steps {
                script {
                    echo "Deploying to Dev environment..."
                    // Deploy to Dev environment
                    sh "deploy_to_dev.sh --server ${DEV_SERVER}"
                }
            }
        }

        stage('Deploy to QA') {
            when {
                branch 'qa'
            }
            steps {
                script {
                    echo "Deploying to QA environment..."
                    // Deploy to QA environment
                    sh "deploy_to_qa.sh --server ${QA_SERVER}"
                }
            }
        }

        stage('Deploy to Staging') {
            when {
                branch 'staging'
            }
            steps {
                script {
                    echo "Deploying to Staging environment..."
                    // Deploy to Staging environment
                    sh "deploy_to_staging.sh --server ${STAGING_SERVER}"
                }
            }
        }

        stage('Deploy to Production') {
            when {
                branch 'production'
            }
            steps {
                script {
                    echo "Deploying to Production environment..."
                    // Deploy to Production environment
                    sh "deploy_to_prod.sh --server ${PROD_SERVER}"
                }
            }
        }
    }

    post {
        always {
            // Always publish the test results and allure reports
            junit '**/target/test-*.xml'  // JUnit test results
            allure includeProperties: true, results: [[path: '**/allure-results']]  // Allure report
        }
    }
}