package com.projeto.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Controller
public class ImageController {

	@Autowired
	private AmazonS3 amazonS3;

	private static final String BUCKET = "epasstracktag";
	private static final String REGION = "us-east-2";

	public String saveImageS3(byte[] foto) {
		// DatatypeConverter.parseBase64Binary(foto.toString());
		InputStream stream = new ByteArrayInputStream(foto);
		String fileName = getRandomKey() + ".jpg";
		amazonS3.putObject(
				new PutObjectRequest(BUCKET, fileName, stream, null).withCannedAcl(CannedAccessControlList.PublicRead));

		// "http://s3-us-east-2.amazonaws.com/" + BUCKET + "/" + fileName;

		return "http://s3-" + REGION + ".amazonaws.com/" + BUCKET + "/" + fileName;
	}

	private String getRandomKey() {
		UUID uuid = UUID.randomUUID();
		String myRandom = uuid.toString();
		return myRandom.substring(0, 20);
	}

}
