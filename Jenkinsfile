pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                sh 'ls'
                sh 'cat kubernetes/student-demo-deployment.yml'
                script {
                        docker.withRegistry('https://registry.hub.docker.com', 'dockerHubCredentials') {
                        def img = docker.build("nirushanth/student-demo:1.0")
                        img.push()
                    }
                  kubernetesDeploy(configs: "kubernetes/student-demo-deployment.yml", kubeconfigId: "mykubeconfig2")
                }
            }
        }
    }
}