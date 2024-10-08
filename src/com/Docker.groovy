#!usr/bin/env groovy
package com

class Docker {

    def script
    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName, String version, String dockerfilePath) {
        script.echo "Building Docker image ${imageName}: ${version}..."
        if (version == '') {
            script.error('Version parameter is required')
        } else {
            script.echo 'Building docker image...'
            script.sh "docker build -t ${imageName}:${version} -f ./${dockerfilePath} ."
        }
    }

    def dockerLogin(String credentials, String server) {
        if (server == '') {
            server = 'https://index.docker.io/v1/'
        }
        script.echo 'Docker login...'
        script.withCredentials([script.usernamePassword(credentialsId: credentials, usernameVariable: 'USER', passwordVariable: 'PWD')]) {
            script.sh "echo ${script.PWD} | docker login -u ${script.USER} --password-stdin ${server}"
        }
    }

    def dockerPush(String imageName, String version, String server) {
        if (server == '') {
            server = 'https://index.docker.io/v1/'
        }
        script.echo "Pushing to ${server}"
        script.sh "docker push ${imageName}:${version}"
    }

}
