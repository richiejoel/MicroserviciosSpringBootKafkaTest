echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
#docker stop ms-transaction
#docker rm  ms-transaction
echo **************************************************************
docker  build -t richigm/ms-transaction-v1 .
docker push  richigm/ms-transaction-v1
echo **************************************************************
echo run image 
docker run -p 8022:8022 --name ms-transaction --network bankservices -d richigm/ms-transaction-v1
echo *************************************************************
echo End Process
echo *************************************************************