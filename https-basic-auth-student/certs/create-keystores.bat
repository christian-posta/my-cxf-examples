@echo off 

echo Deleting old keystore
del *.jks

echo Generating keystore hello-world.jks
keytool -genkey -alias HelloWorld -keypass HelloWorld12345 -keystore hello-world.jks -storepass HelloWorldKeyStore12345 -dname "cn=HelloWorld" -keyalg RSA

echo Self-signing certificate in hello-world.jks
keytool -selfcert -alias HelloWorld -keystore hello-world.jks -storepass HelloWorldKeyStore12345 -keypass HelloWorld12345

echo Exporting public key
keytool -export -alias HelloWorld -file HelloWorld-public-key.rsa -keystore hello-world.jks -storepass HelloWorldKeyStore12345

echo Importing public-key to a Java key store for the client
keytool -import -alias HelloWorld  -file HelloWorld-public-key.rsa -keystore hello-world-client.jks -storepass client54321

echo Deleting intermediate files
del *.rsa