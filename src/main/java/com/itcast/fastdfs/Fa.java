package com.itcast.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * @author: 11827
 * @date: 2019/1/6 02:20
 * @description:
 */
public class Fa {
    public static void main(String[] args) throws Exception {
        ClientGlobal.init(System.getProperty("user.dir")+"/src/main/resources/a.properties");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        String[] strings = storageClient.upload_file("d:/images/3.jpg", "jpg", null);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
