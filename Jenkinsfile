pipeline{
	agent any
	
	triggers {
		pollSCM '* * * * * *'
	}
	environment {
		DOCKER_IMAGE = ''
	}
	stages {
	    stage ('Checkout source') {
	    	steps{
	    		checkout scm
	    	}
	    }	
	    
		stage('Docker Build') {
			steps{
				script {
					DOCKER_IMAGE = docker.build("nirushanth/student-demo")
				}
			}
		}
		
		stage('Docker Push') {
			steps{
				script {
					docker.withRegistry('https://registry.hub.docker.com', 'dockerHubCredentials') {
					    DOCKER_IMAGE.push()
				    }
				}	
			}
		} 	    
		
		stage('Kubernetes Deployment') {
			steps{
				withKubeConfig([credentialsId: 'kubeconfig1']) {
					sh 'kubectl apply -f kubernetes/student-demo-deployment.yml'
				}
			}
		}
	}
}