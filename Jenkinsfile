pipeline {
  agent any
  stages {
    stage('Package') {
      steps {
        sh 'mvn -B -DskipTests -Dmaven.javadoc.skip=true clean package'
      }
    }
    stage('Build Image') {
      steps {
        sh 'docker build -t registry-vpc.cn-beijing.aliyuncs.com/micro-java/$PROJECT .'
      }
    }
    stage('Push Image') {
      steps {
        sh 'docker push registry-vpc.cn-beijing.aliyuncs.com/micro-java/$PROJECT'
      }
    }
    stage('Deploy') {
      steps {
        sh '''ansible-playbook /etc/ansible/playbooks/spring-boot-deploy.yaml \\
--extra-vars project=$PROJECT \\
--extra-vars app_name=$PROJECT \\
--extra-vars app_label=$GIT_BRANCH
'''
      }
    }
  }
  environment {
    PROJECT = 'micro-server-douyin'
  }
}