geração do certificado autoassinado

keytool -genkey -alias ontrack -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650 -dname "CN=Ednilson Veloso, OU=ProjOportunidade, O=ProjOportunidade, L=Rio de Janeiro, ST=Unknown, C=RJ" -keypass edveloso -storepass edveloso