echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
#docker stop ms-invoice
#docker rm  ms-invoice
echo **************************************************************
docker  build -t richigm/ms-invoice-v1 .
docker push  richigm/ms-invoice-v1
echo **************************************************************
echo run image 
docker run -p 8021:8021 --name ms-invoice --network bankservices -d richigm/ms-invoice-v1
echo *************************************************************
echo End Process
echo *************************************************************