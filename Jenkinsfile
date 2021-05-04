pipeline {

  agent any

  stages {

    stage('Checkout Source') {
      steps {
        git url:'https://github.com/MitraInnovationRepo/student-demo.git', branch:'dev1'
      }
    }
    
    stage('Build') {
      steps {
      
        docker.withRegistry('https://registry.hub.docker.com', 'dockerHubCredentials') {
        def img = docker.build("nirushanth/student-demo-test")
        img.push()
    	}
      }
    }

    stage('Deploy App') {
      steps {
        script {
          kubernetesDeploy(configs: "kubernetes/student-demo-deployment.yml", kubeconfigId: "mykubeconfig")
        }
      }
    }

  }