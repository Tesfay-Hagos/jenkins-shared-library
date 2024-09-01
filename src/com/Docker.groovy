#!usr/bin/env groovy
package com

class Docker {

    def script
    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName, String version, String dockerfilePath) {
        echo "Building Docker image ${imageName}: ${version}..."
        if (version == '') {
            error('Version parameter is required')
    } else {
            echo 'Building docker image...'
            sh "docker build -t ${imageName}:${version} -f ./${dockerfilePath} ."
        }
    }
    def dockerLogin(String credentials, String server) {
        echo 'Docker login...'

        // To separate get the password and the username use functions as below
        withCredentials([usernamePassword(credentialsId: credentials ,
     usernameVariable: 'USER', passwordVariable: 'PWD')]) {
            // sh "some script ${USER} ${PWD}"  // No script for now
            sh "echo ${PWD} | docker login -u ${USER} --password-stdin ${server}"
     }
    }
    def dockerPush(String imageName, String version) {
        echo "Pushing to ${server}"
        sh "docker push ${imageName }:${ version }"
    }

}
