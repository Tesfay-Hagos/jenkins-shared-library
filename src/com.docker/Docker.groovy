#!usr/bin/env groovy
package com.docker

class Docker {

    def script
    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName, String version, String dockerfilePath) {
        if (version == '') {
            error('Version parameter is required')
    } else {
            echo 'Building docker image...'
            sh "docker build -t ${imageName}:${version} -f ./${dockerfilePath} ."
        }
    }

}
