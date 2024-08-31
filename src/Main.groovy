#!usr/bin/env groovy
parameters{
  string(name:'test',defaultValue:'Hello test',description:'this is test parameter')
}
static void main(String[] args) {
  println "Hello world!"
}