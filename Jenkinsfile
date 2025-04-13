pipeline {
    agent any

    environment {
        IMAGE_NAME = 'akanshasaxena1/survey-app'
        DEPLOYMENT_NAME = 'survey-app'
        CONTAINER_NAME = 'container-0'
        NAMESPACE = 'default'
        DOCKERHUB_CREDENTIALS = 'docker-creds'  // Jenkins credentials ID
    }

    stages {
        stage('Clone Repository') {
            steps {
                checkout scm
            }
        }

        stage('Build App') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME:latest .'
            }
        }

        stage('Docker Login') {
            steps {
                withCredentials([usernamePassword(credentialsId: "$DOCKERHUB_CREDENTIALS", usernameVariable: 'DOCKERHUB_CREDENTIALS_USR', passwordVariable: 'DOCKERHUB_CREDENTIALS_PSW')]) {
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                }
            }
        }

        stage('Push Image to Docker Hub') {
            steps {
                sh 'docker push $IMAGE_NAME:latest'
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh 'kubectl set image deployment/$DEPLOYMENT_NAME $CONTAINER_NAME=$IMAGE_NAME:latest -n $NAMESPACE'
                sh 'kubectl rollout restart deployment/$DEPLOYMENT_NAME -n $NAMESPACE'
            }
        }
    }
}
