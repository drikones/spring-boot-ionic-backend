package com.nelioalves.mc.services;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

/**
 * Classe de serviço do Amazon S3 
 * @author Adriano Rocha
 * @since 02/02/2020
 */
@Service
public class S3Service {
	
	private Logger LOG = LoggerFactory.getLogger(S3Service.class);
	
	@Autowired
	private AmazonS3 s3Client;
	
	@Value("${s3.bucket}")
	private String bucketName;
	
	public void uploadFile(String localFilePath) 
	{
		try {
			File file = new File(localFilePath);
			LOG.info("Iniciando upload");
			s3Client.putObject(new PutObjectRequest(bucketName, "teste.jpg", file));
			LOG.info("Upload finalizado");
		} 
		catch (AmazonServiceException e) {
			LOG.info("AmazonServiceException: "+e.getErrorMessage());
			LOG.info("Status Code: "+e.getErrorCode());
		} 
		catch(AmazonClientException e) 
		{
			LOG.info("AmazonClientException: "+e.getMessage());
		}
	}

}
