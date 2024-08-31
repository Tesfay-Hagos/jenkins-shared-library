#!usr/bin/env groovy
def call(){
    if (params.Version == '') {
        error('Version parameter is required')
    } else {
        echo 'Building docker image...'
        sh "docker build -t ${params.ImageName}:${params.Version} -f ./Dockerfile ."
    }
}
