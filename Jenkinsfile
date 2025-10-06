pipeline {
    agent any

    tools {
        maven 'maven'     // Must match the Maven name in Manage Jenkins → Tools
        jdk 'Java JDK'    // Must match the JDK name in Manage Jenkins → Tools
    }

    environment {
        IMAGE_NAME = "springboot-docker-app"
        CONTAINER_NAME = "springboot-container"
        PORT = "8080"
    }

    stages {

        stage('Checkout') {
            steps {
                echo "Checking out source code from GitHub..."
                git branch: 'main', url: 'https://github.com/MadineniJayasree/restful-web-service.git'
            }
        }

        stage('Build with Maven') {
            steps {
                echo "Building the project with Maven..."
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Building Docker image..."
                sh "docker build -t ${IMAGE_NAME} ."
            }
        }

        stage('Stop Old Container') {
            steps {
                echo "Stopping and removing old container if running..."
                sh '''
                    if [ "$(docker ps -q -f name=${CONTAINER_NAME})" ]; then
                        docker stop ${CONTAINER_NAME}
                        docker rm ${CONTAINER_NAME}
                    fi
                '''
            }
        }

        stage('Run Docker Container') {
            steps {
                echo "Running Docker container..."
                sh "docker run -d -p ${PORT}:${PORT} --name ${CONTAINER_NAME} ${IMAGE_NAME}"
            }
        }
    }

    post {
        success {
            echo "✅ Build and Deployment Successful!"
        }
        failure {
            echo "❌ Build Failed. Check logs in Jenkins console."
        }
    }
}
