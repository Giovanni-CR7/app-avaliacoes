name: Deploy Back-End to AWS

on:
push:
branches: [ "main" ]

jobs:
build-and-deploy:
runs-on: ubuntu-latest

steps:
        - uses: actions/checkout@v4

      - name: Set up JDK 21
uses: actions/setup-java@v4
with:
java-version: '21'
distribution: 'temurin'
cache: maven

      - name: Make mvnw executable
run: chmod +x mvnw

      - name: Build with Maven (No Tests)
run: ./mvnw -B clean package -DskipTests --file pom.xml

      - name: Login to Docker Hub
uses: docker/login-action@v3
with:
username: "givil"
password: ${{ secrets.DOCKERHUB_TOKEN }}

      - name: Set up Docker Buildx
uses: docker/setup-buildx-action@v3

      - name: Build and push
uses: docker/build-push-action@v5
with:
context: .
file: ./dockerfile
push: true
tags: givil/app-avaliacoes:${{ github.sha }}

      - name: Deploy via SSH to AWS EC2
uses: appleboy/ssh-action@master
with:
host: ${{ secrets.HOST_TEST }}
username: "ubuntu"
key: ${{ secrets.KEY_TEST }}
port: 22
script: |
docker stop app-avaliacoes || true
docker rm --force app-avaliacoes || true
docker run -d --restart unless-stopped --network host --name app-avaliacoes givil/app-avaliacoes:${{ github.sha }}