node {

    docker.withRegistry('https://registry.hub.docker.com', 'dockerHubCredentials') {

        def img = docker.build("nirushanth/student-demo:2.0")
        img.push()
    }
    
  stage('Apply Kubernetes files') {
    withKubeConfig([credentialsId: 'kubeconfig1']) {
                sh 'ls'
                sh 'cat kubernetes/student-demo-deployment2.yml'
                sh 'kubectl apply -f kubernetes/student-demo-deployment2.yml'
    }
  }
}