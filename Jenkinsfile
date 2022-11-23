pipeline {
    agent any
    environment {
        SOURCECODE_JENKINS_CREDENTIAL_ID = 'jei0486'
        SOURCE_CODE_URL = 'https://github.com/jei0486/demo-api'
        RELEASE_BRANCH = 'main'
        REGISTRY = 'jei0486/demo-api'
    }

    stages {

        stage('init') {
            steps {
                echo 'init'
                echo "Current workspace : ${workspace}"
            }
        }

      stage('clone') {
        steps {
            echo 'clone'
            git url: "$SOURCE_CODE_URL",
            branch: "$RELEASE_BRANCH",
            credentialsId: "$SOURCECODE_JENKINS_CREDENTIAL_ID"
        }
      }

      stage('Gradle Build') {
        steps {
            echo 'build'
            sh 'pwd'
            sh '''
            chmod +x gradlew
            ./gradlew clean bootJar
            '''
         }
      }

        stage('Publish-release') {
            steps {
                withDockerRegistry([ credentialsId: 'dockerhub', url: '']) {
                      sh '''
                      ./gradlew jib -Ddocker.repo.username=$USERNAME -Ddocker.repo.password=$PASSWORD
                      '''
                  }
            }
        }

        stage('workspace clear'){
            steps {
                cleanWs()
            }
        }

    }
}