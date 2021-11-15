pipeline {
	environment
	{
		registry = "hatembayoudh/Timesheet"
		registryCredential= 'dockerHub'
		dockerImage = ''
	}
    agent any

    stages {
		stage('Cloning our Git') {
			steps { 
				git 'https://github.com/HatemBay/Timesheet.git’
			}
		}
		stage('Building our image') {
			steps { 
				script { 
					dockerImage= docker.build registry + ":$BUILD_NUMBER" 
				} 
			}
		}
		stage('Deploy our image') {
			steps { 
				script { 
					docker.withRegistry( '', registryCredential) { dockerImage.push() } 
					} 
				}
		}
		stage('Cleaning up') {
			steps { 
				bat "docker rmi $registry:$BUILD_NUMBER" 
			}
		}
        stage('Checkout GIT') {
            steps {
                echo 'Pulling...';
                git branch: 'hatem',
                url: 'https://github.com/HatemBay/Timesheet';
            }
        }
        stage('Build, Testing'){
        steps {
            bat """mvn clean install"""
        }    
        }
        
        stage('Sonar'){
            steps {
                bat """mvn sonar:sonar"""
            }
        }
        
        stage('Nexus'){
            steps {
                bat """mvn clean package deploy:deploy-file -DgroupId=tn.esprit -DartifactId=Timesheet -Dversion=0.0.3 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet-0.0.3.jar"""
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
