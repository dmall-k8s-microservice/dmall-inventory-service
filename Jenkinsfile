pipeline {
    agent any

    triggers {
        pollSCM('* * * * *')
    }
    
    environment {
        TOKEN='eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlLXN5c3RlbSIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJrdWJlcm5ldGVzLWRhc2hib2FyZC10b2tlbi1rNjdrNCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50Lm5hbWUiOiJrdWJlcm5ldGVzLWRhc2hib2FyZCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50LnVpZCI6IjlmN2U0NGUyLTA0M2QtMTFlOC1hMDU2LTA2YWJjN2I5MzhhYSIsInN1YiI6InN5c3RlbTpzZXJ2aWNlYWNjb3VudDprdWJlLXN5c3RlbTprdWJlcm5ldGVzLWRhc2hib2FyZCJ9.bugHCnbcfckzv-eM_zgsQiEObmAvb8-olYdolS6P0RACmzZPoCj-frmkur7ruN8nMcJQUY4L-S1eJbOvAqOfBWrBPjGpIQ0_mwMyl7xdIFIzyeRKlA0LUTNGPVmZ7rD9S6kppRcJk_HJBC0We3fbXRcZMqIZteB_OarG460sTnGXrhpK_zysoEvHHccQiBT5vcjmibi3aNqMlcnL0hv09V7lY025KT2l3W5jZdzDcGGmjrvuRRegfqc6AtLUvDzESCOci92yKEeoiwucOLZUe4deBMEdCsbkmHmUq7ptjqQrIYZL0M3u_ca_oJZwBLr-TOdQwlyKl68KOc9UWeFLsw'
        API_SERVER='https://kubernetes'
        DMALL_DOCKER_REGISTRY='ec2-54-223-92-91.cn-north-1.compute.amazonaws.com.cn:5000'
        SLUG='dmall'
    }
    
    stages {
        stage('repo clean up'){
            steps {
                step([$class: 'WsCleanup'])
            }
        }

        stage('Checkout') {
            steps {
                step([$class: 'WsCleanup'])
            git  poll: true,  url: 'https://gitee.com/linwenjun/dmall-inventory-service.git', branch: 'master'
            }
                
        }

        stage('Build') {
            steps{
                sh './gradlew clean build'
            }
        }

        stage('Check') {
            parallel {
                stage('Findbugs') {
                        agent none
                        steps {
                            echo 'Findbugs is finished.'
                        }
                    }
                stage('Checkstyle') {
                        agent none
                        steps {
                            echo 'Checkstyle is finished.'
                        }
                    }
                stage('PMD') {
                        agent none
                        steps {
                            echo 'PMD is finished.'
                        }
                    }
            }
        }

        stage('Docker image') {
            steps{
                sh './genImages.sh'
            }
        }

        stage('Deploy to DEV') {
            steps{
                sh './deployToDEV.sh'
            }
        }
  }  
}