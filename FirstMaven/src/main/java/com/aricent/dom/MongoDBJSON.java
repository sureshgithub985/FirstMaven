package com.aricent.dom;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

public class MongoDBJSON {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Long start_time = System.currentTimeMillis();
		Mongo mongo = new Mongo("localhost", 27017);
		DB db = mongo.getDB("customer");
		DBCollection collection = db.getCollection("customers");
		System.out.println("JSON parse example......");
		String json = "{'database' : 'customer','table' : 'customers',"
				+ "'detail' : {'first_name' : 'hello100', 'last_name' : 'okok100'}}}";
		DBObject dbobject = (DBObject) JSON.parse(json);
		collection.insert(dbobject);
		DBCursor cursorDocJSON = collection.find();
		while (cursorDocJSON.hasNext()) {
			System.out.println(cursorDocJSON.next());
		}
		long count = collection.count();
		System.out.println("Number of records in the collection is " + count);
		Long end_time = System.currentTimeMillis();
		long tot = (end_time - start_time) / 1000;
		System.out.println("Time taken is" + tot);
		System.out.println("Done");
	}

}
