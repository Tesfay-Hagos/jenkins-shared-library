#!usr/bin/env groovy
import com.Docker

//def call(String imageName,String version,String dockerfilePath){
def call(String imageName, String version, String server) {
    return new Docker(this).dockerPush(imageName, version, server)
}
