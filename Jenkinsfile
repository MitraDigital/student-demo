stages {

	environment {
	    DOCKER_IMAGE = ''
	}
	
    stage ('Checkout source') {
    	checkout scm
    }	
    
	stage('Docker Build') {
		script {
			DOCKER_IMAGE = docker.build("nirushanth/student-demo")
		}
	}
	
	stage('Docker Push') {
		script {
			docker.withRegistry('https://registry.hub.docker.com', 'dockerHubCredentials') {
			    DOCKER_IMAGE.push()
		    }
		}
	} 	    
	
	stage('Kubernetes Deployment') {
		withKubeConfig([credentialsId: 'kubeconfig1']) {
			sh 'kubectl apply -f kubernetes/student-demo-deployment.yml'
		}
	}
	

}

