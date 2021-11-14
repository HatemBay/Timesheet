pipeline {
    agent any

    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling...';
                git branch: 'hatem',
                url: 'https://github.com/HatemBay/Timesheet';
            }
        }
        stage('Build'){
        steps {
            bat """mvn clean install -Dmaven.test.skip=true"""
        }    
        }
        
        stage('Sonar'){
            steps {
                bat """mvn sonar:sonar"""
            }
        }
        
        stage('Nexus'){
            steps {
                bat """mvn clean package deploy:deploy-file -DgroupId=tn.esprit -DartifactId=Timesheet -Dversion=0.0.3 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet-0.0.3.jar -Dmaven.test.skip=true"""
            }
        }
    }
    
    post {
        success {
            emailext body: 'build success', subject: 'Jenkins', to:
            'hatem.bayoudh1@esprit.tn'
        }
        
        failure {
            emailext body: 'build failure', subject: 'Jenkins', to:
            'hatem.bayoudh1@esprit.tn'
        }
    }
}
