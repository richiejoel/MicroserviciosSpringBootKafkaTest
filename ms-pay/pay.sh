echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
#docker stop ms-pay
#docker rm  ms-pay
echo **************************************************************
docker  build -t richigm/ms-pay-v1 .
docker push  richigm/ms-pay-v1
echo **************************************************************
echo run image 
docker run -p 8020:8020 --name ms-pay --network bankservices -d richigm/ms-pay-v1
echo *************************************************************
echo End Process
echo *************************************************************