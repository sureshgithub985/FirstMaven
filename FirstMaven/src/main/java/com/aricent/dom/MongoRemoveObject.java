package com.aricent.dom;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class MongoRemoveObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mongo mongo = new Mongo("localhost", 27017);
		DB db = mongo.getDB("customer");
		DBCollection collection = db.getCollection("customers");

		// insert empId 10001 to 10010 for testing

		for (int i = 10001; i <= 10010; i++) {
			collection.insert(new BasicDBObject().append("empId", i).append("salary", i+1000));
		}

		/*==
		 * Long count = collection.count(); System.out.println(
		 * "Before Removing the Entries ... "+count); System.out.println(
		 * "Removing the elements......"); BasicDBObject document = new
		 * BasicDBObject(); document.put("empId", 10001);
		 * 
		 * collection.remove(document); System.out.println(
		 * "After Removing the Entries ... "+count); */
		 

		mongo.close(); 
	}

}
