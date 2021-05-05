node {

	checkout scm
	
    docker.withRegistry('https://registry.hub.docker.com', 'dockerHubCredentials') {
	    def img = docker.build("nirushanth/student-demo")
	    img.push()
    }
}