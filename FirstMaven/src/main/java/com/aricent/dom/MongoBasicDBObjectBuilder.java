package com.aricent.dom;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class MongoBasicDBObjectBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Conneting to mongodb ip and port number.
		Mongo mongo = new Mongo("localhost", 27017);
		// get Database from MongoDBmongo
		DB db = mongo.getDB("customer");
		// get the Single Collection
		DBCollection collection = db.getCollection("customers");

		System.out.println("Start the BasicDBObjectBuilder");
		BasicDBObjectBuilder documentBuilder = BasicDBObjectBuilder.start().add("database", "customer").add("table",
				"customers");
		BasicDBObjectBuilder documentBuilderDetail = BasicDBObjectBuilder.start().add("first_name", "suresh100")
				.add("last_name", "maram100");
		documentBuilder.add("detail", documentBuilderDetail.get());
		collection.insert(documentBuilder.get());

		DBCursor cursorDoc = collection.find();
		while (cursorDoc.hasNext()) {
			System.out.println(cursorDoc.next());
		}
		long count = collection.count();
		System.out.println("Number of record in customers collection is " + count);
		mongo.close();
	}

}
