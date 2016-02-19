package no.applitude.dagensbackend;

import java.io.File;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.transfer.Upload;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;

public class AmazonUpload {

    public AmazonUpload(String jsonString){
        try{
            TransferManager tm = new TransferManager(new DefaultAWSCredentialsProviderChain());

            String bucketName = "todays-dinner";
            String fileName = "food.json";

            InputStream is = new ByteArrayInputStream(jsonString.getBytes());

            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType("application/json; charset=utf-8");
            meta.setContentLength(jsonString.getBytes().length);

            Upload upload = tm.upload(bucketName, fileName, is, meta);
            upload.waitForCompletion();

            AmazonS3 s3client = new AmazonS3Client(new DefaultAWSCredentialsProviderChain());
            s3client.setObjectAcl(bucketName, fileName, CannedAccessControlList.PublicRead);

        }catch(Exception e){
        }
    }
}
