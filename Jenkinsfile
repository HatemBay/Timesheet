pipeline {
    environment
    {
        registry = "osamaml97/docker7"
        registryCredential= 'dockerHub'
        dockerImage = ''
    }




    

    agent any
    stages{
        stage('check git'){
            steps {
                echo'pulling..';
                git branch: 'oussama',
                url:'https://github.com/HatemBay/Timesheet';
            }
        }
        
        stage("build"){
            steps{
                bat"""mvn clean install"""
            }
        }
        
                stage("Test"){
            steps{
                bat"""mvn test"""
            }
        }
        
        
        
        stage("sonar"){
            steps {
                bat"""mvn sonar:sonar"""
            }
    }
    

    
                stage("nexus"){
            steps {
                bat"""mvn clean package deploy:deploy-file -DgroupId=tn.esprit -DartifactId=Timesheet -Dversion=1.0.2 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet-1.0.2.jar"""
            }
    }
    

    stage('Building our image') {
        steps { script { dockerImage= docker.build registry + ":$BUILD_NUMBER" } }
    }
    stage('Deploy our image') {
        steps { script { docker.withRegistry( '', registryCredential) { dockerImage.push() } } }
    }
    stage('Cleaning up') {
        steps { bat "docker rmi $registry:$BUILD_NUMBER" }





}


}
    post {
        success {
            emailext body: 'build success', subject: 'Jenkins', to:
            'oussama.mleiki1@esprit.tn'
        }
        
        failure {
            emailext body: 'build failure', subject: 'Jenkins', to:
            'oussama.mleiki1@esprit.tn'
        }
    }
}
