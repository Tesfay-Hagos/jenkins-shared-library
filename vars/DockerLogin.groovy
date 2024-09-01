#!usr/bin/env groovy
import com.Docker

//def call(String imageName,String version,String dockerfilePath){
def call(String credential, String server) {
    return new Docker(this).dockerLogin(credential, server)
}
