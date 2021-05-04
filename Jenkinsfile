pipeline {
  stages {

    stage('Checkout Source') {
      steps {
        git url:'https://github.com/MitraInnovationRepo/student-demo.git', branch:'dev1'
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

}