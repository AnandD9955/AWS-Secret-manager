package com.springsecretmanager.springsecretmanager.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClient;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.google.gson.Gson;

@Service
public class SecretManagerService {
	 public static AWSCredentials awsCredentials() {
		 
		 AWSCredentials credentials=new BasicAWSCredentials("AKIAZVRPA2GRHEOG5UAZ","KsNmxWAF7ITDWyZ2bBzZXjGWla2CK4TnBz/IknYe");
		 return credentials;
		 
	 }
	 
	 public  static void main(String[]args) {
		    AWSSecretsManager client =	AWSSecretsManagerClientBuilder.standard()
				 .withCredentials(new AWSStaticCredentialsProvider(awsCredentials()))
				 .withRegion("us-east-1")
				 .build();
			
			GetSecretValueRequest secretValueRequest=new GetSecretValueRequest().withSecretId("MyProdSecret");
			GetSecretValueResult secretValueResult=null;
			secretValueResult=client.getSecretValue(secretValueRequest);
			String secretValue=secretValueResult.getSecretString();
			System.out.println("secretValue:"+secretValue);
			Gson gson=new Gson();
			Map<String,Object> map=gson.fromJson(secretValue, Map.class);
			map.forEach((k,v)->System.err.println("key:"+k+",value:"+v));
	}
//	@Value("${my.secret.property}")
//    private String secretValue;
//
//    public String getSecretValue() {
//        if (secretValue == null || secretValue.isEmpty()) {
//            secretValue = fetchSecretFromSecretManager();
//        }
//        return secretValue;
//    }
//    private String fetchSecretFromSecretManager() {
//        AWSSecretsManagerClient client = SecretsManagerClient.builder()
//                .credentialsProvider(DefaultCredentialsProvider.create())
//                .region(Region.US_EAST_1) // Replace with your desired region
//                .build();
//
//        GetSecretValueRequest request = GetSecretValueRequest.builder()
//                .secretId("my-application-secret") // Replace with your secret name
//                .build();
//
//        GetSecretValueResponse response = client.getSecretValue(request);
//        return response.secretString();
//    }
}
