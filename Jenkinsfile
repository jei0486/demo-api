pipeline {
    agent any
    environment {
        SOURCECODE_JENKINS_CREDENTIAL_ID = 'jei0486'
        SOURCE_CODE_URL = 'https://github.com/jei0486/demo-api.git'
        RELEASE_BRANCH = 'main'
        GIT_OPS_URL = 'github.com/jei0486/demo-gitops.git'
        GIT_OPS_BRANCH = 'main'
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
            sh 'ls'
        }
      }


       stage('Build') {
            steps {
                withDockerRegistry([ credentialsId: 'dockerhub', url: '' ]) {
                  sh "skaffold build -p dev -t ${TAG}"
                }
            }
       }

        stage('workspace clear'){
            steps {
                cleanWs()
            }
        }

        stage('GitOps Update') {

            steps {
               print "======kustomization.yaml tag update====="

               withCredentials([string(credentialsId: "$SOURCECODE_JENKINS_CREDENTIAL_ID", variable: 'SECRET')]) {//set SECRET with the credential content
               git url: "https://$GIT_OPS_URL",
                   branch: "$GIT_OPS_BRANCH",
                   credentialsId: "$SOURCECODE_JENKINS_CREDENTIAL_ID"
                      sh '''
                        ls -la
                        cd ./demo-api
                        kustomize edit set image jei0486/demo-api:${TAG}
                        git config user.email "jei0486@gmail.com"
                        git config user.name "jei0486"
                        git add .
                        git commit -am "update image tag ${TAG}"
                        git remote set-url --push origin https://${SECRET}@$GIT_OPS_URL
                        git push origin $GIT_OPS_BRANCH
                        '''
                }
            }
       }


    }
}