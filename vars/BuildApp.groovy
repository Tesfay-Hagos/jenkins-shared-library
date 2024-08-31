def call(){
    if (params.Version == '') {
        error('Version parameter is required')
    } else {
        echo 'Building docker image...'
        sh "docker build -t tesfayh2121/manage-container:${params.Version} -f ./Dockerfile ."
    }
}
