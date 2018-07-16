#!/usr/bin/env bash

echo $JAVA_HOME

while read p; do
    echo $p
    openssl s_client -CApath $JAVA_HOME/jre/lib/security/cacerts -connect $p:443 < /dev/null | sed -ne '/-BEGIN CERTIFICATE-/,/-END CERTIFICATE-/p' > downloaded.crt
    keytool -trustcacerts -storepass password -keypass password -noprompt -import -alias $p -keystore $JAVA_HOME/jre/lib/security/cacerts -file downloaded.crt
    rm -rf downloaded.crt
done <ssl-hosts.txt
