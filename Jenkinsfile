node {

  checkout scm 
  
  stage('Apply Kubernetes files') {
    withKubeConfig([credentialsId: 'kubeconfig1']) {
		sh 'ls'
		sh 'cat kubernetes/student-demo-deployment.yml'
		sh 'kubectl apply -f kubernetes/student-demo-deployment.yml'
    }
  }
}