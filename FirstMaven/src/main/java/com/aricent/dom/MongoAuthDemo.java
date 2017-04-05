package com.aricent.dom;

import java.util.Arrays;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongoAuthDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Inside the MongoDB Authenication Suresh Maram....");
		System.out.println("Inside Suresh Maram123");
		MongoClient mongoClient = null;
		MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("suresh", "customer",
				"suresh".toCharArray());
		mongoClient = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(mongoCredential));
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB("customer");
		System.out.println(db.getStats());
		System.out.println(db.getCollectionNames());
		mongoClient.close();
	}

}
