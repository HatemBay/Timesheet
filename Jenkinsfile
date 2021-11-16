pipeline {
	environment
	{
		registry = "hatembayoudh/timesheet"
		registryCredential= 'dockerHub'
		dockerImage = ''
	}
    agent any

    stages {
		stage('Checkout GIT') {
            steps {
                echo 'Pulling...';
                git branch: 'hatem',
                url: 'https://github.com/HatemBay/Timesheet';
            }
        }

        stage('Build, Testing'){
        	steps {
        		echo 'Building and testing...';
           		bat """mvn clean install"""
        	}    
        }
        
        stage('Sonar'){
            steps {
            	echo 'Sonar';
                bat """mvn sonar:sonar"""
            }
        }
        
        stage('Nexus'){
            steps {
            	echo 'Deploying on Nexus...';
                bat """mvn clean package deploy:deploy-file -DgroupId=tn.esprit -DartifactId=Timesheet -Dversion=0.0.3 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet-0.0.3.jar"""
            }
        }

		stage('Building our image') {
			steps { 
				script { 
					echo 'Building image...';
					dockerImage = docker.build registry + ":$BUILD_NUMBER"
				} 
			}
		}

		stage('Deploy our image') {
			steps { 
				script { 
					echo 'Deploying image...';
					docker.withRegistry( '', registryCredential) { dockerImage.push() } 
					} 
				}
		}

		stage('Cleaning up') {
			steps { 
				echo 'Cleaning up...';
				bat "docker rmi $registry:$BUILD_NUMBER" 
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