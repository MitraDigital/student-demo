node {

    checkout scm

    docker.withRegistry('https://registry.hub.docker.com', 'dockerHubCredentials') {

        def img = docker.build("nirushanth/student-demo:1.0")
        img.push()
    }
}