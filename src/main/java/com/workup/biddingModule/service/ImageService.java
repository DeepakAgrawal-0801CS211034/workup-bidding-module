package com.workup.biddingModule.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.model.GridFSFile;

@Service
public class ImageService {

    @Autowired
    private GridFSBucket gridFSBucket;

    public String uploadImage(String base64Image, String imageName) {
        byte[] imageBytes = Base64.getDecoder().decode(base64Image);
        InputStream inputStream = new ByteArrayInputStream(imageBytes);
        ObjectId fileId = gridFSBucket.uploadFromStream(imageName, inputStream);
        return fileId.toHexString();  // Return MongoDB GridFS file ID
    }

    public InputStream getImage(String id) {
        GridFSFile gridFSFile = gridFSBucket.find(new org.bson.Document("_id", new ObjectId(id))).first();
        if (gridFSFile == null) {
            return null;
        }
        return gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
    }
}

