#!usr/bin/env groovy
//def call(String imageName,String version,String dockerfilePath){
def call(String imageName, String version,String dockerfilePath) {
    if (params.Version == '') {
        error('Version parameter is required')
    } else {
        echo 'Building docker image...'
        sh "docker build -t ${imageName}:${version} -f ./${dockerfilePath} ."
    }
}
