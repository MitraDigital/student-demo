pipeline {
    agent any
    
	tools {
		maven 'Maven3.6.3'
	}

    stages {
        stage ('Compile') {

            steps {
                    sh 'mvn -v'
            }
        }
    }
}