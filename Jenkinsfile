pipeline {
    agent any
    stages {
        stage("Setup IFrame") {
            steps {
                script {
                    currentBuild.rawBuild.project.setDescription("<iframe src='http://${localhost}:4444/grid/admin/live' width='1400' height='500'></iframe>")
                }
            }
        }
        stage("Run Test") {
            steps {
                  bat 'mvn test'
         //       echo 'Running Test'
            }
        }   
        stage("Remove IFrame") {
            steps {
                script {
                    currentBuild.rawBuild.project.setDescription("")
                }
            }
        }        
    }
}