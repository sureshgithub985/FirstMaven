package com.aricent.dom;

import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class MongoDBMapInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Mongo mongo = new Mongo("localhost",27017);
	DB db = mongo.getDB("customer");
	DBCollection collection = db.getCollection("customers");
	
	Map<String, Object> documentMap  = new HashMap<String, Object>();
	documentMap.put("database", "customer");
	documentMap.put("table", "customers");
	
	Map<String, Object> documentMapDetail  = new HashMap<String, Object>();
	documentMapDetail.put("first_name", "kumar");
	documentMapDetail.put("last_name", "kumar1");
	documentMap.put("documentMapDetail", documentMapDetail);
	
	collection.insert(new BasicDBObject(documentMap));
	
	DBCursor cusormap = collection.find();
	while(cusormap.hasNext())
	{
		System.out.println(cusormap.next());
	}
	
	}

}
