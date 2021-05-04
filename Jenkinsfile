pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                sh 'ls'
                sh 'cat kubernetes/student-demo-deployment.yml'
                script {
                  kubernetesDeploy(configs: "kubernetes/student-demo-deployment.yml", kubeconfigId: "mykubeconfig2")
                }
            }
        }
    }
}