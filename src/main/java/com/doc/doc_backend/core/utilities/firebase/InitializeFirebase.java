package com.doc.doc_backend.core.utilities.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.protobuf.DescriptorProtos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InitializeFirebase {



    public static FirebaseApp initializeFirebase() throws IOException {

        InputStream serviceAccount = new FileInputStream("doc-java-ffebc-firebase-adminsdk-cpogh-c85b57b97c.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .setStorageBucket("doc-java-ffebc.appspot.com")
                .build();
        return FirebaseApp.initializeApp(options);
    }
}
