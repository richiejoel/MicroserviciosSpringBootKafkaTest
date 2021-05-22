echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
#docker stop ms-config-server
#docker rm  ms-config-server
echo **************************************************************
docker  build -t richigm/ms-config-server-v1 .
docker push  richigm/ms-config-server-v1
echo **************************************************************
echo run image 
docker run -p 8888:8888 --name ms-config-server --network bankservices -d richigm/ms-config-server-v1
echo *************************************************************
echo End Process
echo *************************************************************