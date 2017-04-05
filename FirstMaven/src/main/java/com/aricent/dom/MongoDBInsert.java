package com.aricent.dom;

import java.util.Scanner;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class MongoDBInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Passing the values at runtime.
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter the First Name");
		String first_name = s.next();
		System.out.println("Please Enter the Last Name");
		String last_name = s.next();
		// Conneting to mongodb ip and port number.
		Mongo  mongo= new Mongo("localhost", 27017);
		// get Database from MongoDBmongo
		DB db = mongo.getDB("customer");
		// get the Single Collection
		DBCollection collection = db.getCollection("customers");

		// BasicDBObject example
		System.out.println("BasicDBObject example.........");
	/*	BasicDBObject document = new BasicDBObject();
		document.put("database", "customer");
		document.put("table", "customers");

		BasicDBObject documentDetail = new BasicDBObject();
		documentDetail.put("first_name", first_name);
		documentDetail.put("last_name", last_name);
		document.put("detail", documentDetail);
		collection.insert(document);

		DBCursor cursdoc = collection.find();
		while (cursdoc.hasNext()) {
			System.out.println(cursdoc.next());
		}
		long count = collection.count();
		System.out.println("Number of records in Customers table is "+count);*/
		collection.remove(new BasicDBObject());
		mongo.close();
	}

}
