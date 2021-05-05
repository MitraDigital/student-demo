node {

	environment {
	    dockerImage = ''
	}
	
    stage ('Checkout source') {
    	checkout scm
    }	
    
	stage('Docker Build') {
		script {
			dockerImage = docker.build("nirushanth/student-demo")
		}
	}
	
	stage('Docker Push') {
		script {
			docker.withRegistry('https://registry.hub.docker.com', 'dockerHubCredentials') {
			    dockerImage.push()
		    }
		}
	} 	    
	
	stage('Kubernetes Deployment') {
		withKubeConfig([credentialsId: 'kubeconfig1']) {
			sh 'kubectl apply -f kubernetes/student-demo-deployment.yml'
		}
	}
	

}

