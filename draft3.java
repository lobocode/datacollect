package br.com.collections;

// import AmazonSNSClient
import com.amazonaws.services.sns.AmazonSNSClient;

public class ConnectSNS {
    // connecta to SNS and ignore SSL certificate
    public static AmazonSNSClient connect() {
        AmazonSNSClient snsClient = new AmazonSNSClient();
        snsClient.setEndpoint("https://sns.us-east-1.amazonaws.com");
        return snsClient;
    }
    // snsClient ignore SSL certificate
    public static AmazonSNSClient connectIgnoreSSL() {
        AmazonSNSClient snsClient = new AmazonSNSClient();
        snsClient.setEndpoint("https://sns.us-east-1.amazonaws.com");
            snsClient.setSnsClientOptions(snsClient.getSnsClientOptions().withPayloadSigningEnabled(false));
        return snsClient;
    }
}
