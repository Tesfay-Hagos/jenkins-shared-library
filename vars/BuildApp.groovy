#!usr/bin/env groovy
import com.docker.Docker

//def call(String imageName,String version,String dockerfilePath){
def call(String imageName, String version, String dockerfilePath) {
    return new Docker(this).buildDockerImage(imageName, version, dockerfilePath)
}
