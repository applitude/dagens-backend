package no.applitude.dagensbackend;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.transfer.Upload;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;

public class AmazonUpload {

    public AmazonUpload(String fileName, String jsonString) {
        try{
            TransferManager tm = new TransferManager(new DefaultAWSCredentialsProviderChain());

            String bucketName = "todays-dinner";
            String jsonFile = String.format("%s.json", fileName);
            System.out.println(jsonFile);
            
            InputStream is = new ByteArrayInputStream(jsonString.getBytes());

            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType("application/json; charset=utf-8");
            meta.setContentLength(jsonString.getBytes().length);

            Upload upload = tm.upload(bucketName, jsonFile, is, meta);
            upload.waitForCompletion();

            AmazonS3 s3client = new AmazonS3Client(new DefaultAWSCredentialsProviderChain());
            s3client.setObjectAcl(bucketName, jsonFile, CannedAccessControlList.PublicRead);

        } catch(Exception e) {
        
        }
    }
}
